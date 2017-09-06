package com.cqu.edu.ebmis.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqu.edu.ebmis.domain.FileInfo;
import com.cqu.edu.ebmis.domain.TaskDO;
import com.cqu.edu.ebmis.domain.UrlDO;
import com.cqu.edu.ebmis.repository.TaskRepository;
import com.cqu.edu.ebmis.repository.UrlRepository;
import com.cqu.edu.ebmis.service.TaskService;
import com.cqu.edu.ebmis.service.convert.FileOperation;
import com.cqu.edu.ebmis.service.convert.LengthComp;
import com.cqu.edu.ebmis.service.page.Page;
import com.cqu.edu.ebmis.utils.Md5Util;

@Service
public class TaskServiceImpl implements TaskService {
	@Resource
	private TaskRepository taskRepository;
	@Resource
	private UrlRepository urlRepository;

	public int save(TaskDO task,List<Integer> projectIds) {
		
		/*
		List<FileInfo> fileInfos =new ArrayList<FileInfo>();
		FileInfo fileInfo=new FileInfo();
		fileInfo.setUrl(task.getUrl());
		fileInfo.setKeyword(task.getKeyword());
		fileInfo.setWebsite(task.getWebsite());
		fileInfos.add(fileInfo);
		this.saveBatch(task.getProjectId(),task.getDataObj(),projectIds,fileInfos);
		*/
		//1.构造新task链接的MD5
		String taskMd5=Md5Util.toMd5(task.getUrl());
		task.setMd(taskMd5);
		UrlDO newUrl=new UrlDO();
		//2.通过MD5去URL表查找是否存在
		boolean urlExist=false;
		UrlDO oldUrl= urlRepository.findByMd5(taskMd5);
		//  2.1 如果不存在，则添加，得到一个productInnerId
		if(oldUrl==null){
			newUrl.setProductURL(task.getUrl());
			newUrl.setMd(taskMd5);
			newUrl.setKeyWord(task.getKeyword());
			newUrl.setPlatform(task.getWebsite());
			newUrl.setGetURLTime(new Date());
			urlRepository.insert(newUrl);
			
		}
		
		//  2.2 如果存在，则比较关键字，将URL表中的关键字以较长的为准，进行更新。同时还需要得到productInnerId
		else{
			if(oldUrl.getKeyWord()==null||oldUrl.getKeyWord().length()<task.getKeyword().length()){
				oldUrl.setKeyWord(task.getKeyword());
				urlRepository.update(oldUrl);
			}
			newUrl=oldUrl;
			urlExist=true;
		}
		//3.添加到任务基本列表
		task.setProductInnerId(newUrl.getProductInnerId());
		task.setKeyword(newUrl.getKeyWord());
		if(urlExist){
		//  3.1 通过productInnerId，到需要去重的项目里面（in关键字）进行查找，看此任务是否存在。
			HashMap map=new HashMap();
			map.put("productInnerId", newUrl.getProductInnerId());
			map.put("projectIds", projectIds);
			List<TaskDO> tasks=taskRepository.findTasks(map);
		//	    3.1.1 如果存在，比较、更新关键字
			if(tasks.size()==0){
				taskRepository.insertTask(task);
			}
			else{
			for(TaskDO t:tasks){
				t.setKeyword(newUrl.getKeyWord());
				taskRepository.updateTask(t);
			}
			}
		}		
		//    	3.1.2 如果不存在，则直接添加任务
		else{
			taskRepository.insertTask(task);
		}
		return 1;
	}
	
	

	public boolean saveBatch(int projectId,int projectPriority,String dataObj,List<Integer> projectIds,String filePath) {
		
		FileOperation fileOperation = new FileOperation();
		List<FileInfo> fileInfos =new ArrayList<FileInfo>();
		if(filePath==null||filePath.equals("")){
			return false;
		}
		else{
			fileInfos = fileOperation.readFile(filePath);
		}
		if(fileInfos.size()<1000){
			for(FileInfo fileInfo:fileInfos){
				TaskDO task=new TaskDO();
				task.setProjectId(projectId);
				task.setUrl(fileInfo.getUrl());
				task.setWebsite(fileInfo.getWebsite());
				task.setDataObj(dataObj);
				task.setKeyword(fileInfo.getKeyword());
				task.setProjectPriority(projectPriority);
				task.setTaskPriority(0);
				this.save(task, projectIds);
			}
			
		}
		return true;
		//return this.saveBatch(projectId, dataObj, projectIds, fileInfos);
	}
	
	public boolean saveBatch(int projectId,String dataObj,List<Integer> projectIds,List<FileInfo> fileInfos) {
		List<TaskDO> initTasks = new ArrayList<TaskDO>();
		
		initTasks = this.generateTasks(projectId,dataObj, fileInfos);
		
		this.addTaskByJDBC(projectId, dataObj, initTasks,projectIds); 
		
		return true;
	}

	public int delete(int code) {
		return taskRepository.deleteTask(code);
	}

	public void update(TaskDO task) {
		taskRepository.updateTask(task);
		;
	}

	public List<TaskDO> findAll() {
		return taskRepository.findAll();
	}
	public TaskDO find(int taskId){
		return taskRepository.findById(taskId);
	}

	public List<TaskDO> findByProjectId(int projectId) {
		return taskRepository.findTaskByProjectId(projectId);
	}

	public Page<TaskDO> findByPage(int projectId,Page<TaskDO> page) {
		List<TaskDO> tasks = taskRepository.selectByPageProject(projectId, page.getLimit(), page.getOffset());
		page.setTotal(taskRepository.selectAllCountProject(projectId));

		page.setRecords(tasks);
		return page;
	}
	public Page<TaskDO> findByPageField(int projectId,Page<TaskDO> page,String field) {
		List<TaskDO> tasks = taskRepository.selectByPageProjectField(projectId, page.getLimit(), page.getOffset(),field);
		page.setTotal(taskRepository.selectAllCountProjectField(projectId,field));
		
		page.setRecords(tasks);
		return page;
	}
	
	/**
	 * 生成初始任务
	 */
	public List<TaskDO> generateTasks(int pId,String dataObj,List<FileInfo> fileInfos){
		List<TaskDO> tasks = new ArrayList<TaskDO>();
		for(int i=0;i<fileInfos.size();i++){
			TaskDO task = new TaskDO();
			task.setProjectId(pId);
			task.setDataObj(dataObj);
			task.setUrl(fileInfos.get(i).getUrl());
			String md5 = Md5Util.toMd5(fileInfos.get(i).getUrl());
			task.setMd(md5);
			task.setWebsite(fileInfos.get(i).getWebsite());
			task.setKeyword(fileInfos.get(i).getKeyword());
			tasks.add(task);
		}
		return tasks;
	}
	
	/*
	 * 2016-10-29
	 * 1.读取txt中的任务，并选出关键字最长的任务
	 * 2.读取url表中的数据，根据步骤1中获得的任务，更新url表中关键字或者插入url
	 * 3.读取task表中指定项目ID下的任务表，根据步骤1中获得的任务，更新task表中关键字或者插入task
	 * 说明：*Manage用于与数据库操作，*Deal用于处理内存中数据
	 */
	public void addTaskByJDBC(int pId,String dataObj,List<TaskDO> initTasks,List<Integer> pIds){
		
		
		
		//读取数据到内存
		
		//List<Task> initTasks = taskDeal.generateTasks(pId, dataObj, fileInfos);
	    //对于同一链接的任务，选出关键字长度最长的任务
		List<TaskDO> tasks = this.getMaxKeyLengthTasks(initTasks);
		System.out.println("当前初始任务大小为"+tasks.size());
		
		HashMap<String, String> keyWordMap = urlRepository.getExsitUrls();
		HashMap<String, List<UrlDO>> urlsMap = this.getUrls(keyWordMap, tasks);
		List<UrlDO> updateUrls = urlsMap.get("update");
		List<UrlDO> insertUrls = urlsMap.get("insert");
		if(updateUrls.size()>0){
			boolean flag = urlRepository.updateKeyWord(updateUrls);
			System.out.println("是否更新URL关键词成功?"+flag+updateUrls.size());
		}
		if(insertUrls.size()>0){
			boolean flag;
			flag = urlRepository.insertUrls(insertUrls);
			System.out.println("是否插入URL成功?"+flag+insertUrls.size());
			
		}
		
		
		
		//获取更新后url表的productInnerId，，并设置tasks的productInnerId
		HashMap<String, Integer> idMap = urlRepository.getProductIds();
		List<TaskDO> targetTasks = this.updateProductId(idMap, tasks);
		
		HashMap<String, String> taskKeyMap = taskRepository.getTasksByProjectIds(pIds);
		
		if(taskKeyMap.size()==0){
			boolean flag = taskRepository.insertTasksBatch(targetTasks);
			System.out.println("插入任务是否成功？"+flag+targetTasks.size());
		}else{
			HashMap<String, List<TaskDO>> tasksMap = this.getTargetTasks(taskKeyMap, targetTasks);
			List<TaskDO> updateTasks = tasksMap.get("update");
			List<TaskDO> insertTasks = tasksMap.get("insert");
			if(updateTasks.size()>0){
				boolean flag =  taskRepository.updateKeyWord(updateTasks);
				System.out.println("更新任务是否成功？"+flag+updateTasks.size());
			}
			if(insertTasks.size()>0){
				boolean flag = taskRepository.insertTasksBatch(insertTasks);
				System.out.println("插入任务是否成功？"+flag+insertTasks.size());
			}	
			
		}
	}
	/**
	 * 2016/10/29
	 * 针对JDBC，获得需要处理的url，一部分用于更新，一部分用于插入
	 */
	
		public HashMap<String,List<UrlDO>> getUrls(HashMap<String,String> map,List<TaskDO> tasks){
			HashMap<String,List<UrlDO>> urlsMap = new HashMap<String,List<UrlDO>>();
			//用于新增到url表的url集合
			List<UrlDO> insertUrls = new ArrayList<UrlDO>();
			//用于更新url表的url集合
			List<UrlDO> updateUrls = new ArrayList<UrlDO>();
			for(int i=0;i<tasks.size();i++){
				if(!map.containsKey(tasks.get(i).getMd())){
					UrlDO url = new UrlDO();
					url.setProductURL(tasks.get(i).getUrl());
					url.setGetURLTime(new Date());
					url.setPlatform(tasks.get(i).getWebsite());
					url.setKeyWord(tasks.get(i).getKeyword());
					//url.setHashValue(tasks.get(i).getUrlHashForm());
					url.setMd(tasks.get(i).getMd());
					insertUrls.add(url);
					//加入新增url
					//map.put(tasks.get(i).getMd(), url);
				}
				else {
					String keyWord = map.get(tasks.get(i).getMd());
					
					int curLength = 0,taskLength = 0; 
					if(keyWord!=null){
						curLength = keyWord.length();			
					}
					if(tasks.get(i).getKeyword()!=null){
						taskLength = tasks.get(i).getKeyword().length();
					}
					
					if(curLength<taskLength){
						UrlDO url = new UrlDO();
						url.setMd(tasks.get(i).getMd());
						url.setKeyWord(tasks.get(i).getKeyword());
						System.out.println(tasks.get(i).getMd()+"url关键字"+keyWord+"被更新为:"+tasks.get(i).getKeyword());
						updateUrls.add(url);
					}
					else{
						tasks.get(i).setKeyword(keyWord);
					}
					
					//判断当前url是否具有关联的parentId，如有则更新待入库任务的parentId
					//if()
					
					}
					
		}
			System.out.println("inserurls:"+insertUrls.size());
			System.out.println("updateurls:"+updateUrls.size());
			urlsMap.put("insert", insertUrls);
			urlsMap.put("update", updateUrls);
			return urlsMap;
			
		}
		
		/**
		 * 对链接相同的task筛选出关键字长度最长的
		 */
		public List<TaskDO> getMaxKeyLengthTasks(List<TaskDO> tasks){
			List<TaskDO> targetTasks = new ArrayList<TaskDO>();
			HashMap<String, TreeSet<TaskDO>> map = new HashMap<String, TreeSet<TaskDO>>();
			for(int i=0;i<tasks.size();i++){
				if(map.get(tasks.get(i).getUrl())==null){
					TreeSet<TaskDO> taskSets = new TreeSet<TaskDO>(new LengthComp());
					taskSets.add(tasks.get(i));
					map.put(tasks.get(i).getUrl(), taskSets);
				}else {
					map.get(tasks.get(i).getUrl()).add(tasks.get(i));
				}
				
			}
			for(Entry<String, TreeSet<TaskDO>> entry:map.entrySet()){
				TaskDO task= entry.getValue().first();
				targetTasks.add(task);
			}	
			
			return targetTasks;
		}
		
		/**
		 * 实现关键字长度比较的容器,返回最长的关键字
		 */
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			TaskDO task1 = (TaskDO)o1;
			TaskDO task2 = (TaskDO)o2;
			int a = 0, b = 0;
			if(task1.getKeyword()!=null){
				a = task1.getKeyword().length();
			}
			if(task2.getKeyword()!=null){
				b = task2.getKeyword().length();
			}
			return -(a-b);
		}
		
		/**
		 * 2016/10/29
		 */
		//获得任务的productInnerId
		public List<TaskDO> updateProductId(HashMap<String, Integer> map,List<TaskDO> tasks){
			for(int i=0;i<tasks.size();i++){
				if(map.get(tasks.get(i).getMd())!=null){
					tasks.get(i).setProductInnerId(map.get(tasks.get(i).getMd()));
				}
			}
			return tasks;
		}
		
		/**
		 * 更新关键词
		 * @param map
		 * @param tasks
		 * @return
		 */
		public HashMap<String,List<TaskDO>> getTargetTasks(HashMap<String,String> map,List<TaskDO> tasks){
			HashMap<String, List<TaskDO>> tasksMap = new HashMap<String,List<TaskDO>>();
			//用于新增到task表的task集合
			List<TaskDO> insertTasks = new ArrayList<TaskDO>();
			//用于更新task表的task集合
			List<TaskDO> updateTasks = new ArrayList<TaskDO>();
			for(int i=0;i<tasks.size();i++){
				if(!map.containsKey(tasks.get(i).getMd())){
					insertTasks.add(tasks.get(i));
					//加入新增url
					//map.put(tasks.get(i).getMd(), url);
				}
				else {
					String keyWord = map.get(tasks.get(i).getMd());
					
					int curLength = 0,taskLength = 0; 
					if(keyWord!=null){
						curLength = keyWord.length();			
					}
					if(tasks.get(i).getKeyword()!=null){
						taskLength = tasks.get(i).getKeyword().length();
					}
					
					if(curLength<taskLength){
						TaskDO task = new TaskDO();
						task.setMd(tasks.get(i).getMd());
						task.setKeyword(tasks.get(i).getKeyword());
						updateTasks.add(task);
						System.out.println("task关键字"+keyWord+"被更新为:"+tasks.get(i).getKeyword());
					}
		
					}
					
		}
			System.out.println("insertTasks:"+insertTasks.size());
			System.out.println("updateTasks:"+updateTasks.size());
			tasksMap.put("insert", insertTasks);
			tasksMap.put("update", updateTasks);
			return tasksMap;
			
		}
	

}

package com.cqu.edu.ebmis.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.cqu.edu.ebmis.domain.ProjectDO;
import com.cqu.edu.ebmis.domain.TaskDO;
import com.cqu.edu.ebmis.domain.UrlDO;
import com.cqu.edu.ebmis.handler.MapResultHandler;
import com.cqu.edu.ebmis.mapper.TaskMapper;
import com.cqu.edu.ebmis.repository.TaskRepository;

@Repository
public class TaskRepositoryImpl extends SqlSessionDaoSupport  implements TaskRepository {
	@Resource
	private TaskMapper taskMapper; 
	

	 @Resource
	     public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
	       super.setSqlSessionFactory(sqlSessionFactory);
	      }

	@Override
	public int insertTask(TaskDO task) {
		return taskMapper.insertTask(task);
	}

	@Override
	public List<TaskDO> findAll() {
		return taskMapper.findAll();
	}

	@Override
	public TaskDO findById(int taskId) {
		return taskMapper.findById(taskId);
	}

	@Override
	public List<TaskDO> findTaskByProjectId(int projectId) {
		return taskMapper.findTaskByProjectId(projectId);
	}

	@Override
	public void updateTask(TaskDO task) {
		taskMapper.updateTask(task);

	}

	@Override
	public int deleteTask(int taskId) {
		return taskMapper.deleteTask(taskId);
	}

	@Override
	public List<TaskDO> selectByPage(int size, int offset) {
		return taskMapper.selectByPage(size, offset);
	}

	@Override
	public int selectAllCount() {
		return taskMapper.selectAllCount();
	}

	@Override
	public HashMap<String, String> getTasksByProjectId(int projectId) {
		try{
        	MapResultHandler mrh=new MapResultHandler();
    		this.getSqlSession().select("getTasksByProjectId", projectId,mrh);
    		Map map=mrh.getMappedResults();
    		return (HashMap<String, String>) map;
            
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
	}
	
	public List<TaskDO> findTasks(HashMap map){
		return taskMapper.findTasks(map);
	}

	@Override
	public boolean insertTasksBatch(List<TaskDO> tasks) {
		//对于大数据量，需要分批次执行，每1000个一批。
				int size=tasks.size();
				if(size==0)
					return true;
				int count=size/1000 + 1; //循环的次数
				List<TaskDO> tmpUrl=new ArrayList<TaskDO>();
				
				for(int i=0;i<count;i++ ){
					//如果是最后一批，则只统计到列表的大小-1。
					if(i==count-1)
						tmpUrl=tasks.subList(i*1000, size-1);
					else
					 tmpUrl=tasks.subList(i*1000, (i+1)*1000-1);
					if(!tmpUrl.isEmpty())
					   taskMapper.insertTasksBatch(tmpUrl);
				}
				
				return true;
		
	}

	@Override
	public boolean updateKeyWord(List<TaskDO> tasks) {
		return taskMapper.updateKeyWord(tasks);
	}

	@Override
	public HashMap<String, String> getTasksByProjectIds(List<Integer> ids) {
		 try{
	        	MapResultHandler mrh=new MapResultHandler();
	    		this.getSqlSession().select("getTasksByProjectIds",ids, mrh);
	    		Map map=mrh.getMappedResults();
	    		return (HashMap<String, String>) map;
	            
	        }catch (Exception e){
	            e.printStackTrace();
	            return null;
	        } 
	}

	@Override
	public List<TaskDO> selectByPageProject(int projectId, int size, int offset) {
		return taskMapper.selectByPageProject(projectId, size, offset);
	}

	@Override
	public int selectAllCountProject(int projectId) {
		return taskMapper.selectAllCountProject(projectId);
	}

	@Override
	public List<TaskDO> selectByPageProjectField(int projectId, int size, int offset, String field) {
		// TODO Auto-generated method stub
		return taskMapper.selectByPageProjectField(projectId, size, offset, field);
	}

	@Override
	public int selectAllCountProjectField(int projectId, String field) {
		// TODO Auto-generated method stub
		return taskMapper.selectAllCountProjectField(projectId, field);
	}

	@Override
	public void updateTaskInfoPriority(TaskDO task) {
		// TODO Auto-generated method stub
		taskMapper.updateTaskInfoPriority(task);
	}

	
}

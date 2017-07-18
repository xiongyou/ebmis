/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.cqu.edu.ebmis.domain.TaskDO;
import com.cqu.edu.ebmis.service.TaskService;
import com.cqu.edu.ebmis.service.page.Page;

/**
 * 三级分类管理
 * 
 * @author mxl
 * @version $ CategoryController.java v1.0, 2017年5月5日 上午11:38:18 mxl Exp $
 */
@Controller
@RequestMapping("/projectTask")
public class ProjectTaskController extends SuperController {
	
	/** 三级层级 */
	private final static int	THRID_LEVEL	= 2;
	
	@Autowired
	private TaskService	taskService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		String projectID = request.getParameter("projectID");
		model.addAttribute("projectID" , projectID);
		return "/projectTask/list";
	}
	
	@ResponseBody
	@RequestMapping("/getProjectTaskList")
	public String getProjectTaskList() {
	
		Page<TaskDO> page = getPage();
		String projectID1 = request.getParameter("projectID");
		int projectID=Integer.parseInt(projectID1);
		taskService.findByPage(projectID,page);
		return jsonPage(page);
	}
	/*
	@ResponseBody
	@RequestMapping("/getParentCategory/{parentCode}")
	public JSONObject getParentCategory(@PathVariable String parentCode) {
	
		List<CategoryDO> categorys = categoryService.findAll();
		
		List<CategoryNode> nodes = CategoryConvert.covert(categorys ,
				parentCode);
		
		return jsonList(nodes);
	}
	*/
	@RequestMapping("/edit")
	public String edit(Model model) {
		String taskId = request.getParameter("taskId");
		String projectID = request.getParameter("projectID");
		if (taskId != null) {
			int taskId1= Integer.parseInt(taskId);
			TaskDO taskDO=taskService.find(taskId1);
			model.addAttribute("update" , "update");
			model.addAttribute("taskId" , taskId);
			model.addAttribute("taskDO" , taskDO);
		}
		model.addAttribute("projectID",projectID);
		return "/projectTask/edit";
	}
	@RequestMapping("/edits")
	public String edits(Model model) {
		String taskId = request.getParameter("taskId");
		String projectID = request.getParameter("projectID");
		model.addAttribute("projectID",projectID);
		return "/projectTask/edits";
	}
	
	@ResponseBody
	@RequestMapping("/editProjectTask")
	public String editProjectTask(TaskDO taskDO) {
		JSONObject json = new JSONObject();
		String success1="";
		String error1="";
		String update = request.getParameter("update");
		String dropProjectId = request.getParameter("dropProjectId");
		String[] strsId=dropProjectId.split(",");
		List<Integer> projectIds=new ArrayList<Integer>();
		for(String str:strsId){
			Integer projectId=Integer.parseInt(str);
			projectIds.add(projectId);
		}
		projectIds.add(taskDO.getProjectId());
		try {
			if(update!=null&&!update.equals("")&&!update.equals("null")&&update.equals("update")){
				taskService.update(taskDO);
				success1="修改成功";
			}else{
				System.out.println("1111111111111");
				taskService.save(taskDO,projectIds);
				System.out.println("222222222222222222");
				success1="添加成功";
			}
			json.put("success" , true);
			json.put("data" , success1);
		} catch (Exception e) {
			e.printStackTrace();
			if(update!=null&&!update.equals("")&&!update.equals("null")&&update.equals("update")){
				error1="修改失败";
			}else{
				error1="添加失败";
			}
			json.put("success" , false);
			json.put("data" , error1);
		}
		return json.toJSONString();
	}
	@ResponseBody
	@RequestMapping("/addProjectsTask")
	public String addProjectsTask(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,Model model) {
		System.out.println("888888888888888888");
		JSONObject json = new JSONObject();
		String dropProjectId = request.getParameter("dropProjectId");
		List<Integer> projectIds=new ArrayList<Integer>();
		if(dropProjectId!=null&&!dropProjectId.equals("")){
			String[] strsId=dropProjectId.split(",");
			for(String str:strsId){
				Integer projectId1=Integer.parseInt(str);
				projectIds.add(projectId1);
			}
		}
		String projectID1 = request.getParameter("projectID");
		String dataObj = request.getParameter("dataObj");
		int projectId=Integer.parseInt(projectID1);
		projectIds.add(projectId);
		System.out.println(projectId);
		System.out.println(projectIds);
		 String path = request.getSession().getServletContext().getRealPath("upload");  
	        String fileName = file.getOriginalFilename();  
//	        String fileName = new Date().getTime()+".jpg";  
	        System.out.println(path);  
	        File targetFile = new File(path, fileName);  
	        if(!targetFile.exists()){  
	            targetFile.mkdirs();  
	        }  
	  
	        //保存  
	        try {  
	            file.transferTo(targetFile);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } 
	        String strPath=path.replace("\\", "/");
	        String filePath=strPath+"/"+fileName;
	        String fileUrl=request.getContextPath()+"/upload/"+fileName;
	        System.out.println(fileUrl);
	        System.out.println(filePath);
		try {
			System.out.println("44444444444444444");
			taskService.saveBatch(projectId,dataObj,projectIds,filePath);
			System.out.println("5555555555555555");
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("projectID" , projectId);
		return "/projectTask/list";
	}
	 /*@RequestMapping(value = "/fileList")  
	 public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {  
	  
	        System.out.println("开始"); 
	        System.out.println(file.isEmpty()); 
	        String path = request.getSession().getServletContext().getRealPath("upload");  
	        String fileName = file.getOriginalFilename();  
//	        String fileName = new Date().getTime()+".jpg";  
	        System.out.println(path);  
	        File targetFile = new File(path, fileName);  
	        if(!targetFile.exists()){  
	            targetFile.mkdirs();  
	        }  
	  
	        //保存  
	        try {  
	            file.transferTo(targetFile);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);  
	        System.out.println("11111111111111111111111");
	        System.out.println(request.getContextPath()+"/upload/"+fileName); 
	        return "";  
	    }*/
	/*
	@ResponseBody
	@RequestMapping("/delCategory/{code}")
	public String delUser(@PathVariable String code) {
	
		categoryService.delete(code);
		return Boolean.TRUE.toString();
	}*/
}

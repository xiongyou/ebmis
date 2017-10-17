/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cqu.edu.ebmis.domain.ProjectDO;
import com.cqu.edu.ebmis.service.ProjectService;
import com.cqu.edu.ebmis.service.page.Page;


@Controller
@RequestMapping("/project")
public class ProjectController extends SuperController {
	
	
	@Autowired
	private ProjectService projectService;
	@RequestMapping("/list")
	public String list(Model model) {
	
		return "/project/list";
	}
	
	@ResponseBody
	@RequestMapping("/getProjectList")
	public String getProjectList() {
		Page<ProjectDO> page = getPage();
		
		projectService.findByPage(page);
		return jsonPage(page);
	}
	@ResponseBody
	@RequestMapping("/getProjectListField")
	public String getProjectListField() {
		String field="%";
		String field1=request.getParameter("field");
		field+=field1+"%";
		Page<ProjectDO> page = getPage();
		
		projectService.findByPageField(page,field);
		return jsonPage(page);
	}
	
	@RequestMapping("/edit")
	public String edit(Model model) {
	
		String projectID1 = request.getParameter("projectID");
		if (projectID1 != null) {
			int projectId=Integer.parseInt(projectID1);
			ProjectDO projectDo=projectService.findById(projectId);
			if(projectDo.getStartTime()==null){
				projectDo.setStartTime1(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				projectDo.setEndedTime1(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			}else{
				projectDo.setStartTime1(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(projectDo.getStartTime()));
				projectDo.setEndedTime1(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(projectDo.getEndedTime()));
			}
			model.addAttribute("projectDo" , projectDo);
			model.addAttribute("update" , "update");
		}
		return "/project/edit";
	}
	
	@ResponseBody
	@RequestMapping("/editProject")
	public String editProject(ProjectDO projectDo) {
		JSONObject json = new JSONObject();
		String success1="";
		String error1="";
		String update = request.getParameter("update");
		try {
			projectDo.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(projectDo.getStartTime1()));
			projectDo.setEndedTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(projectDo.getEndedTime1()));
			if(update!=null&&!update.equals("")&&!update.equals("null")){
				ProjectDO projectDo1=projectService.findById(projectDo.getProjectID());
				if(projectDo1.getProjectPriority()!=projectDo.getProjectPriority()){
					projectService.updateProjectTaskPriority(projectDo);
					projectService.updateProjectTaskInfoPriority(projectDo);
				}
				projectService.update(projectDo);
				success1="修改成功";
			}else{
				projectService.save(projectDo);
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
	@RequestMapping("/delProject/{projectID}")
	public String delProject(@PathVariable int projectID) {
		projectService.delete(projectID);
		projectService.deleteProjectTask(projectID);
		return Boolean.TRUE.toString();
	}
}

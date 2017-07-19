/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cqu.edu.ebmis.domain.CategoryDO;
import com.cqu.edu.ebmis.domain.ProjectDO;
import com.cqu.edu.ebmis.service.CategoryService;
import com.cqu.edu.ebmis.service.ProjectService;
import com.cqu.edu.ebmis.service.page.Page;
import com.cqu.edu.ebmis.web.convert.CategoryConvert;
import com.cqu.edu.ebmis.web.model.CategoryNode;

/**
 * 三级分类管理
 * 
 * @author mxl
 * @version $ CategoryController.java v1.0, 2017年5月5日 上午11:38:18 mxl Exp $
 */
@Controller
@RequestMapping("/project")
public class ProjectController extends SuperController {
	
	/** 三级层级 */
	private final static int	THRID_LEVEL	= 2;
	
	@Autowired
	private ProjectService projectService;
	@RequestMapping("/list")
	public String list(Model model) {
	
		return "/project/list";
	}
	@RequestMapping("/projectControl")
	public String projectControl(Model model) {
		
		return "/project/projectControl";
	}
	
	@ResponseBody
	@RequestMapping("/getProjectList")
	public String getProjectList() {
		Page<ProjectDO> page = getPage();
		
		projectService.findByPage(page);
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
		return Boolean.TRUE.toString();
	}
}

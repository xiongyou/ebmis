/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.controller;

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
	
	@ResponseBody
	@RequestMapping("/getProjectList")
	public String getProjectList() {
	System.out.println("1111111111111111111");
		Page<ProjectDO> page = getPage();
		
		projectService.findByPage(page);
		return jsonPage(page);
	}
	
/*	@ResponseBody
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
	
		String code = request.getParameter("code");
		if (code != null) {
			
		}
		return "/project/edit";
	}
	
/*	@RequestMapping("/selectcategory")
	public String selectCategory(Model model) {
	
		return "category/selectcategory";
	}*/
	
	@ResponseBody
	@RequestMapping("/editProject")
	public String editProject(ProjectDO project) {
	
		JSONObject json = new JSONObject();
		System.out.println("222222222222222");
		try {
			System.out.println(project.toString());
			System.out.println(project.getStartTime1());
			System.out.println(project.getEndedTime1());
			System.out.println(project.getStartTime());
			System.out.println(project.getEndedTime());
				projectService.save(project);
				json.put("success" , true);
				json.put("data" , "添加成功");
			
		} catch (Exception e) {
			e.printStackTrace();
			json.put("success" , false);
			json.put("data" , "添加失败");
		}
		
		return json.toJSONString();
	}
	@ResponseBody
	@RequestMapping("/delProject/{code}")
	public String delProject(@PathVariable int code) {
	
		projectService.delete(code);
		return Boolean.TRUE.toString();
	}
}

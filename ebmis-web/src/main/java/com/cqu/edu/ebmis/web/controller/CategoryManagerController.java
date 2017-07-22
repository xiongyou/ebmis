/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqu.edu.ebmis.domain.CategoryManagerDO;
import com.cqu.edu.ebmis.service.CategoryManagerService;

@Controller
@RequestMapping("/categoryManager")
public class CategoryManagerController extends SuperController {
	
	@Autowired
	private CategoryManagerService categoryManagerService;
	@RequestMapping("/manager")
	public String list(Model model) {
	
		return "/categoryManager/treeManager";
	}
	@ResponseBody
	@RequestMapping("/getToolId")
	public List<CategoryManagerDO> getToolId(Model model) {
		CategoryManagerDO categoryManager=new CategoryManagerDO();
		List<CategoryManagerDO> list=null;
		list=categoryManagerService.getByParentId(-1);
		if(list.size()<1){
			categoryManager.setCategoryName("根目录");
			categoryManager.setParentId(-1);
			categoryManager.setVisiable(1);
			categoryManagerService.save(categoryManager);
			list=categoryManagerService.getByParentId(-1);
		}
		return list;
	}
	@ResponseBody
	@RequestMapping("/getParentId")
	public List<CategoryManagerDO> getParentId(Model model) {
		List<CategoryManagerDO> list=null;
		String strParentId=request.getParameter("parentId");
		if(strParentId!=null&&!strParentId.equals("")&&strParentId.equals("null")){
			int parentId=Integer.parseInt(strParentId);
			list=categoryManagerService.getByParentId(parentId);
		}
		return list;
	}

}

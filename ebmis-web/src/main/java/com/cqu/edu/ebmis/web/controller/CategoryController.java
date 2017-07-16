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
import com.cqu.edu.ebmis.service.CategoryService;
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
@RequestMapping("/category")
public class CategoryController extends SuperController {
	
	/** 三级层级 */
	private final static int	THRID_LEVEL	= 2;
	
	@Autowired
	private CategoryService		categoryService;
	
	@RequestMapping("/list")
	public String list(Model model) {
	
		return "/category/list";
	}
	
	@ResponseBody
	@RequestMapping("/getCategoryList")
	public String getCategoryList() {
	
		Page<CategoryDO> page = getPage();
		
		categoryService.findByPage(page);
		return jsonPage(page);
	}
	
	@ResponseBody
	@RequestMapping("/getParentCategory/{parentCode}")
	public JSONObject getParentCategory(@PathVariable String parentCode) {
	
		List<CategoryDO> categorys = categoryService.findAll();
		
		List<CategoryNode> nodes = CategoryConvert.covert(categorys ,
				parentCode);
		
		return jsonList(nodes);
	}
	
	@RequestMapping("/edit")
	public String edit(Model model) {
	
		String code = request.getParameter("code");
		if (code != null) {
			CategoryDO category = categoryService.findByCode(code);
			model.addAttribute("category" , category);
			
			CategoryDO parent = categoryService.findByCode(category
					.getParentCode());
			
			if (parent != null)
				model.addAttribute("parentName" , parent.getName());
		}
		return "/category/edit";
	}
	
	@RequestMapping("/selectcategory")
	public String selectCategory(Model model) {
	
		return "category/selectcategory";
	}
	
	@ResponseBody
	@RequestMapping("/editCategory")
	public String editCategory(CategoryDO category) {
	
		JSONObject json = new JSONObject();
		
		try {
			if (category.getCode() == null) {
				
				String parentCode = category.getParentCode();
				
				String code = categoryService.constructCode(parentCode);
				
				category.setCode(code);
				
				int level = categoryService.findByCode(parentCode).getLevel() + 1;
				category.setLevel(level);
				
				if (level < THRID_LEVEL) {
					categoryService.save(category);
				}
				
				json.put("success" , true);
				json.put("data" , "添加成功");
			}
		} catch (Exception e) {
			json.put("success" , false);
			json.put("data" , "添加失败");
		}
		
		return json.toJSONString();
	}
	
	@ResponseBody
	@RequestMapping("/delCategory/{code}")
	public String delUser(@PathVariable String code) {
	
		categoryService.delete(code);
		return Boolean.TRUE.toString();
	}
}

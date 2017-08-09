/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cqu.edu.ebmis.domain.CategoryLogDO;
import com.cqu.edu.ebmis.service.CategoryLogService;
import com.cqu.edu.ebmis.service.page.Page;
import com.cqu.edu.ebmis.service.vo.User;

/**
 * 三级分类管理
 * 
 * @author mxl
 * @version $ CategoryController.java v1.0, 2017年5月5日 上午11:38:18 mxl Exp $
 */
@Controller
@RequestMapping("/categoryLog")
public class CategoryLogController extends SuperController {
	
	@Autowired
	private CategoryLogService	categoryLogService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		return "/categoryLog/list";
	}
	
	@ResponseBody
	@RequestMapping("/selectLatestLog")
	public CategoryLogDO selectLatestLog() {
		return categoryLogService.selectLatestLog();
	}
	@ResponseBody
	@RequestMapping("/getCategoryLogList")
	public String getCategoryLogList() {
		
		Page<CategoryLogDO> page = getPage();
		
		categoryLogService.findByPage(page);
		return jsonPage(page);
	}
	@ResponseBody
	@RequestMapping("/searchCategoryLogList")
	public String searchCategoryLogList() {
		String word="%";
		String word1=request.getParameter("word");
		word+=word1+"%";
		Page<CategoryLogDO> page = getPage();
		
		categoryLogService.searchByPage(page,word);
		return jsonPage(page);
	}
	
	
	
	
	@ResponseBody
	@RequestMapping("/insert")
	public String insert() {
		session=request.getSession();
		User user=(User) session.getAttribute("user");
		JSONObject json = new JSONObject();
		String content=request.getParameter("content");
		CategoryLogDO categoryLogDo=new CategoryLogDO();
		categoryLogDo.setContent(content);
		categoryLogDo.setLogTime(new Date());
		categoryLogDo.setUserId(user.getUserId());
		categoryLogDo.setUserName(user.getUserName());
		try {
		categoryLogService.insert(categoryLogDo);
		json.put("success" , true);
		json.put("data" , "日志记录成功");
		}catch (Exception e) {
			e.printStackTrace();
			json.put("success" , false);
			json.put("data" , "日志记录失败");
		}
		return json.toJSONString();
	}
	 
}

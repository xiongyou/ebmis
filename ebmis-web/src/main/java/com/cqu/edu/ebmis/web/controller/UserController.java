/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqu.edu.ebmis.service.UserService;
import com.cqu.edu.ebmis.service.page.Page;
import com.cqu.edu.ebmis.service.vo.User;

/**
 * 
 * @author mxl
 * @version $ UserController.java v1.0, 2017年4月25日 下午9:14:18 mxl Exp $
 */
@Controller
@RequestMapping("/perm/user")
public class UserController extends SuperController {
	
	@Resource
	private UserService	userService;
	
	@RequestMapping("/list")
	public String list(Model model) {
	
		return "/user/list";
	}
	
	@RequestMapping("/edit")
	public String edit(Model model) {
	
		String userId = request.getParameter("userId");
		if (userId != null) {
			User user = userService.findByID(userId);
			model.addAttribute("user" , user);
		}
		return "/user/edit";
	}
	
	@ResponseBody
	@RequestMapping("/getUserList")
	public String getUserList() {
	
		Page<User> page = getPage();
		
		userService.findByPage(page);
		return jsonPage(page);
	}
	
	@ResponseBody
	@RequestMapping("/delUser/{userId}")
	public String delUser(@PathVariable String userId) {
	
		userService.delete(userId);
		return Boolean.TRUE.toString();
	}
	
	@ResponseBody
	@RequestMapping("/{userId}")
	public User getUser(@PathVariable String userId) {
	
		return userService.findByID(userId);
	}
	
}

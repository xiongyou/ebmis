/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cqu.edu.ebmis.service.UserService;
import com.cqu.edu.ebmis.service.vo.User;
import com.cqu.edu.ebmis.utils.SaltEncoder;

/**
 * 账户控制器
 * 
 * @author mxl
 * @version $ AccountController.java v1.0, 2017年4月25日 下午7:49:39 mxl Exp $
 */
@Controller
@RequestMapping("/account")
public class AccountController extends SuperController {
	
	@Resource
	private UserService	userService;
	
	@RequestMapping("/login")
	public String login(Model model) {
	
		String errorMsg = "";
		if (isPost(request)) {
			
			errorMsg = "用户名或密码错误";
			
			String userName = request.getParameter("loginName");
			String password = request.getParameter("password");
			
			User user = userService.findByName(userName);
			
			if (user != null
					&& SaltEncoder.md5SaltValid(userName , user.getPassword() ,
							password)) {
				session.setAttribute("user" , user);
				
				return redirectTo("/index.html");
			}
		} else {
			
			errorMsg = "验证码错误";
			
		}
		
		model.addAttribute("errorMsg" , errorMsg);
		
		return "/login";
	}
	
	@RequestMapping("/lockscreen")
	public String logout() {
	
		session = request.getSession();
		
		session.setAttribute("user" , null);
		
		return redirectTo("/_login.html");
		
	}
	
}

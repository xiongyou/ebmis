/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cqu.edu.ebmis.domain.UserDO;
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
			String userName = request.getParameter("loginName");
			String password = request.getParameter("password");
			
			UserDO user1=new UserDO();
			user1.setUserName(userName);
			user1.setPassword(SaltEncoder.md5SaltEncode(userName ,password));
			UserDO user = userService.loginUser(user1);
			
			if (user != null) {
				session.setAttribute("user" , user);
				session.removeAttribute("errorMsg");
				return redirectTo("/index.html");
			}else {
				
				errorMsg = "用户名或密码错误";
				
			}
		} 
		session.setAttribute("errorMsg" , errorMsg);
		
		return redirectTo("/_login");
	}
	
	@RequestMapping("/lockscreen")
	public String logout() {
	
		session = request.getSession();
		
		session.setAttribute("user" , null);
		
		return redirectTo("/_login.html");
		
	}
	
	@RequestMapping("/tzPassWord")
	public String tzPassWord() {
		
		return "/editPassWord";
		
	}
	
	@RequestMapping("/updatePassWord")
	public String updatePassWord(Model model) {
		
		try {
			if (null != session.getAttribute("errorMsg") && !session.getAttribute("errorMsg").equals("")) {
				session.removeAttribute("errorMsg");
			} 
		} catch (NullPointerException e) {
			
		}
		String errorRegMsg = "";
		String strUrl="";
		String nickName = request.getParameter("nickName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		UserDO user2=new UserDO();
		user2.setNickName(nickName);
		user2.setUserName(userName);
		UserDO user1=userService.selectByUserName(user2);
		if(null==user1){
			errorRegMsg="用户名称或用户账号不存在";
			strUrl="/editPassWord";
		}else{
			UserDO user=new UserDO();
			user.setPassword(SaltEncoder.md5SaltEncode(userName ,password));
			user.setUserName(userName);
			user.setNickName(nickName);
			userService.update(user);
			strUrl="/editPassWordSuccess";
		}
		model.addAttribute("errorRegMsg" , errorRegMsg);
		return strUrl;
	}
	
	@RequestMapping("/register")
	public String register() {
		return "/register";
	}
	
	@RequestMapping("/registerAccount")
	public String addUser(Model model) {
		String errorRegMsg = "";
		String strUrl="";
		String userName = request.getParameter("userName");
		String nickName = request.getParameter("nickName");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		UserDO user1=userService.selectByUserAccount(userName);
		if(null!=user1){
			errorRegMsg="账号已存在";
			strUrl="/register";
		}else if(!password.equals(repassword)){
			errorRegMsg="密码输入错误";
			strUrl="/register";
		}else{
			UserDO user=new UserDO();
			user.setPassword(SaltEncoder.md5SaltEncode(userName ,
					password));
			user.setUserName(userName);
			user.setNickName(nickName);
			userService.insert(user);
			strUrl="/registerSuccess";
		}
		model.addAttribute("errorRegMsg" , errorRegMsg);
		return strUrl;
	}
	
	@RequestMapping("/editUser")
	public String editUser() {
		
		session=request.getSession();
		UserDO user=(UserDO) session.getAttribute("user");
		String password=request.getParameter("password");
		user.setPassword(SaltEncoder.md5SaltEncode(user.getUserName(),password));
		userService.editUser(user);
		return "/editPassWordSuccess";
		
	}
	
}

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
@RequestMapping("/DemoTest")
public class DemoTestController extends SuperController {
	@RequestMapping("/list")
	public String list(Model model) {
	
		return "/DemoTest/list";
	}
	
}

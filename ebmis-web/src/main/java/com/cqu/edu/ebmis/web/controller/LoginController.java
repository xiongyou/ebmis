/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登陆
 * 
 * @author mxl
 * @version $ LoginController.java v1.0, 2017年4月25日 下午6:19:54 mxl Exp $
 */
@Controller
public class LoginController {
	
	@RequestMapping("/_login")
	public String login(Model model) {
	
		return "/login";
	}
}

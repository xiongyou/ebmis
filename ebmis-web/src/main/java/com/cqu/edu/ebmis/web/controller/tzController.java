/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 账户控制器
 * 
 * @author mxl
 * @version $ AccountController.java v1.0, 2017年4月25日 下午7:49:39 mxl Exp $
 */
@Controller
@RequestMapping("/ymtz")
public class tzController extends SuperController {
	
	@RequestMapping("/sytz")
	public String sytz() {
		return redirectTo("/index.html");
	}
}

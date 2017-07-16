/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 * 
 * @author mxl
 * @version $ IndexController.java v1.0, 2017年4月25日 下午5:55:49 mxl Exp $
 */
@Controller
public class IndexController extends SuperController {
	
	@RequestMapping("/index")
	public String index(Model model) {
	
		return "/index";
	}
}

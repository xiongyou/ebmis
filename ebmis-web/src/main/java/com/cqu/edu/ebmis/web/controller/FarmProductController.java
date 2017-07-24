/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cqu.edu.ebmis.service.CategoryManagerService;

@Controller
@RequestMapping("/farmProduct")
public class FarmProductController extends SuperController {
	
	@Autowired
	private CategoryManagerService categoryManagerService;
	@RequestMapping("/farmProductCheck")
	public String list(Model model) {
	
		return "/farmProduct/farmProductCheck";
	}
	
}

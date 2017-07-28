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

import com.cqu.edu.ebmis.domain.ProductBaseInfoDO;
import com.cqu.edu.ebmis.domain.ThreeClassificationDo;
import com.cqu.edu.ebmis.service.ProductBaseInfoService;
import com.cqu.edu.ebmis.service.ThreeClassificationService;
import com.cqu.edu.ebmis.service.page.Page;

/**
 * 农产品基本信息管理
 * 
 * @author mxl
 * @version $ ProductController.java v1.0, 2017年5月5日 下午11:35:38 mxl Exp $
 */
@Controller
@RequestMapping("/threeClassification")
public class ThreeClassificationController extends SuperController {
	
	@Autowired
	private ProductBaseInfoService	productBaseInfoService;
	@Autowired
	private ThreeClassificationService	threeClassificationService;
	
	@RequestMapping("/list")
	public String list(Model model) {
	
		return "/product/list";
	}
	@ResponseBody
	@RequestMapping("/level0List")
	public List<ThreeClassificationDo> level0List(Model model) {
		
		return threeClassificationService.findLevel0();
	}
	@ResponseBody
	@RequestMapping("/level1List")
	public List<ThreeClassificationDo> level1List(Model model) {
		String levelName=request.getParameter("level0");
		return threeClassificationService.findLevel1(levelName);
	}
	
}

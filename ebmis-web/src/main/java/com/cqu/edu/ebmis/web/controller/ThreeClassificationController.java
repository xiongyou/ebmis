/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqu.edu.ebmis.domain.ThreeClassificationDo;
import com.cqu.edu.ebmis.service.ThreeClassificationService;

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
	@ResponseBody
	@RequestMapping("/allPlatform")
	public List<ThreeClassificationDo> allPlatform(Model model) {
		return threeClassificationService.allPlatform();
	}
	@ResponseBody
	@RequestMapping("/level2List")
	public List<ThreeClassificationDo> level2List(Model model) {
		String level0=request.getParameter("level0");
		String level1=request.getParameter("level1");
		ThreeClassificationDo threeClassificationDo=new ThreeClassificationDo();
		threeClassificationDo.setLevel0(level0);
		threeClassificationDo.setLevel1(level1);
		return threeClassificationService.findLevel2(threeClassificationDo);
	}
	@ResponseBody
	@RequestMapping("/level3List")
	public List<ThreeClassificationDo> level3List(Model model) {
		String level0=request.getParameter("level0");
		String level1=request.getParameter("level1");
		String level2=request.getParameter("level2");
		ThreeClassificationDo threeClassificationDo=new ThreeClassificationDo();
		threeClassificationDo.setLevel0(level0);
		threeClassificationDo.setLevel1(level1);
		threeClassificationDo.setLevel2(level2);
		return threeClassificationService.findLevel3(threeClassificationDo);
	}
	
}

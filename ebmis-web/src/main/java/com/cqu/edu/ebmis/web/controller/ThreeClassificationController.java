/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cqu.edu.ebmis.domain.CategoryDO;
import com.cqu.edu.ebmis.domain.ThreeClassificationDo;
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
	private ThreeClassificationService	threeClassificationService;
	
	@RequestMapping("/list")
	public String list(Model model) {
	
		return "/product/list";
	}
	@RequestMapping("/threeKeyWordlist")
	public String threeKeyWordlist(Model model) {
		
		return "/threeKeyWord/list";
	}
	@ResponseBody
	@RequestMapping("/getThreeKeyWordlist")
	public String getThreeKeyWordlist(Model model) {
		Page<ThreeClassificationDo> page = getPage();
		String word="%";
		String word1=request.getParameter("word");
		if(word1==null){
			word1="";
		}
		word+=word1+"%";
		String level2=request.getParameter("level2");
		threeClassificationService.findThreeKeyWordByPage(page, word, level2);
		return jsonPage(page);
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
	@RequestMapping("/threeLevel2List")
	public List<ThreeClassificationDo> threeLevel2List(Model model) {
		return threeClassificationService.allFindLevel2();
	}
	@ResponseBody
	@RequestMapping("/updateThreeKeyWord")
	public String updateThreeKeyWord(Model model) {
		JSONObject json = new JSONObject();
		HashMap map=new HashMap();
		String level3Name=request.getParameter("level3Name");
		String area=request.getParameter("area");
		String locFamous1=request.getParameter("locFamous");
		int locFamous=Integer.parseInt(locFamous1);
		String keyProduct1=request.getParameter("keyProduct");
		int keyProduct=Integer.parseInt(keyProduct1);
		map.put("level3", level3Name);
		map.put("area", area);
		map.put("locFamous", locFamous);
		map.put("keyProduct", keyProduct);
		threeClassificationService.updateThreeKeyWord(map);
		json.put("success" , true);
		json.put("data" , "修改成功");
		return json.toJSONString();
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

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
import com.cqu.edu.ebmis.service.page.Page;

/**
 * 农产品基本信息管理
 * 
 * @author mxl
 * @version $ ProductController.java v1.0, 2017年5月5日 下午11:35:38 mxl Exp $
 */
@Controller
@RequestMapping("/product")
public class ProductController extends SuperController {
	
	@Autowired
	private ProductBaseInfoService	productBaseInfoService;
	
	@RequestMapping("/list")
	public String list(Model model) {
	
		return "/product/list";
	}
	
	@ResponseBody
	@RequestMapping("/getProductList")
	public String getProductList() {
	
		Page<ProductBaseInfoDO> page = getPage();
		
		productBaseInfoService.findByPage(page);
		
		return jsonPage(page);
	}
	//全部搜索
	@ResponseBody
	@RequestMapping("/getProductSearchList")
	public String getProductSearchList() {
		String word="%";
		String word1=request.getParameter("word");
		word+=word1+"%";
		String checkedNum1=request.getParameter("checkedNum");
		Integer checkedNum=Integer.parseInt(checkedNum1);
		Page<ProductBaseInfoDO> page = getPage();
		
		productBaseInfoService.findBySearchPage(word, checkedNum, page);
		
		return jsonPage(page);
	}
	
	@ResponseBody
	@RequestMapping("/getProduct/{checked}")
	public String getProduct(@PathVariable int checked){
		Page<ProductBaseInfoDO> page=getPage();
		productBaseInfoService.findCheckedByPage(checked, page);
		return jsonPage(page);
	}
	
	@ResponseBody
	@RequestMapping("/auditProduct/{auditseq}")
	public String auditProduct(@PathVariable String auditseq) {
	
		String[] strs = auditseq.split(":");
		
		ProductBaseInfoDO product = productBaseInfoService.selectByInnerId(Long
				.parseLong(strs[0]));
		
		if (product != null) {
			productBaseInfoService.update(Long.parseLong(strs[0]) , 1 ,
					Integer.parseInt(strs[1]));
		}
		return Boolean.TRUE.toString();
	}
	/**
	 * 层级分页查找全部商品
	 */
	@ResponseBody
	@RequestMapping("/getLevelList")
	public String getLevelList() {
		String checkedNum1=request.getParameter("checkedNum");
		String platform=request.getParameter("platform");
		String level0=request.getParameter("level0");
		String level1=request.getParameter("level1");
		String level2=request.getParameter("level2");
		String level3=request.getParameter("level3");
		Integer checkedNum=Integer.parseInt(checkedNum1);
		Page<ProductBaseInfoDO> page = getPage();
		productBaseInfoService.getLevelList(platform,checkedNum, level0, level1, level2, level3, page);
		return jsonPage(page);
	}
	/**
	 * 层级分页搜索查找全部商品
	 */
	@ResponseBody
	@RequestMapping("/getLevelSearchProduct")
	public String getLevelSearchProduct() {
		String word="%";
		String word1=request.getParameter("word");
		word+=word1+"%";
		String checkedNum1=request.getParameter("checkedNum");
		String platform=request.getParameter("platform");
		String level0=request.getParameter("level0");
		String level1=request.getParameter("level1");
		String level2=request.getParameter("level2");
		String level3=request.getParameter("level3");
		Integer checkedNum=Integer.parseInt(checkedNum1);
		Page<ProductBaseInfoDO> page = getPage();
		productBaseInfoService.getLevelSearchProduct(word,platform,checkedNum, level0, level1, level2, level3, page);
		return jsonPage(page);
	}
}

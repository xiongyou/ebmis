/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cqu.edu.ebmis.domain.ProductBaseInfoDO;
import com.cqu.edu.ebmis.domain.ThreeClassificationDo;
import com.cqu.edu.ebmis.domain.UserDO;
import com.cqu.edu.ebmis.service.ProductBaseInfoService;
import com.cqu.edu.ebmis.service.page.Page;
import com.cqu.edu.ebmis.service.vo.User;

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
	
	//清理负面清单
	@ResponseBody
	@RequestMapping(value="/isNotUpdateProduct",produces="html/text;charset=UTF-8")
	public String isNotUpdateProduct(Model model) {
		JSONObject json = new JSONObject();
		String success1="";
		try {
			String cp11111=request.getSession().getServletContext().getRealPath("/");
			File file=new File(cp11111+"static/isNotUpdateProduct.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String str="";
			while((str=br.readLine())!=null){
				String[] arrStr=str.split(" ");
				Long productInnerId=Long.parseLong(arrStr[0]);
				ProductBaseInfoDO productBaseInfoDO=new ProductBaseInfoDO();
				productBaseInfoDO.setProductInnerId(productInnerId);
				productBaseInfoService.isNotUpdateProduct(productBaseInfoDO);
			}
			success1="清理负面产品成功";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			success1="清理负面产品失败";
		}
		json.put("data" , success1);
		return json.toJSONString();
	
	}
	
	//产品基本数据复核 修改关键词
	@ResponseBody
	@RequestMapping("/updateKeyWord")
	public String updateKeyWord(Model model) {
		JSONObject json = new JSONObject();
		String success1="";
		String keyProductId=request.getParameter("keyProductId");
		Long productInnerId=Long.parseLong(keyProductId);
		String keyWord=request.getParameter("productKeyWord");
		ProductBaseInfoDO productBaseInfoDO=new ProductBaseInfoDO();
		productBaseInfoDO.setProductInnerId(productInnerId);
		productBaseInfoDO.setKeyword(keyWord);
		try {
			productBaseInfoService.updateKeyWord(productBaseInfoDO);
			success1="修改成功";
			json.put("success" , true);
			json.put("data" , success1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			success1="修改失败";
			json.put("success" , false);
			json.put("data" , success1);
		}
		return json.toJSONString();
	}
	@RequestMapping("/list")
	public String list(Model model) {
	
		return "/product/list";
	}
	@RequestMapping("/recheckPersonList")
	public String recheckPersonList(Model model) {
		
		return "/product/recheckPersonList";
	}
	@ResponseBody
	@RequestMapping("/getUserName")
	public String getUserName(Model model) {
		session=request.getSession();
		User user=(User) session.getAttribute("user");
		String userName=user.getUserName();
		return userName;
	}
	@ResponseBody
	@RequestMapping("/recheckPersonDate")
	public String recheckPersonDate(Model model) {
		
		Page<ProductBaseInfoDO> page = getPage();
		
		productBaseInfoService.findRecheckPersonNumByPage(page);
		
		return jsonPage(page);
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
		session=request.getSession();
		User user=(User) session.getAttribute("user");
		String userName=user.getUserName();
		Date date=new Date();
		if (product != null) {
			productBaseInfoService.update(Long.parseLong(strs[0]) , 1 ,
					Integer.parseInt(strs[1]),userName,date);
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

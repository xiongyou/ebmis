/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cqu.edu.ebmis.common.QueryDto;
import com.cqu.edu.ebmis.domain.CategoryDO;
import com.cqu.edu.ebmis.domain.KeyWordDO;
import com.cqu.edu.ebmis.service.CategoryService;
import com.cqu.edu.ebmis.service.KeyWordService;
import com.cqu.edu.ebmis.service.page.Page;

/**
 * 关键字管理
 * 
 * @author mxl
 * @version $ KeyWordController.java v1.0, 2017年5月7日 下午12:33:36 mxl Exp $
 */
@Controller
@RequestMapping("/keyword")
public class KeyWordController extends SuperController {
	
	private Logger			LOGGER	= Logger.getLogger(KeyWordController.class);
	
	@Autowired
	private KeyWordService	keyWordService;
	
	@Autowired
	private CategoryService	categoryService;
	
	@RequestMapping("/list")
	public String list(Model model) {
	
		return "/keyword/list";
	}
	
	@ResponseBody
	@RequestMapping("/getKeyWordList")
	public String getKeyWordList() {
	
		Page<KeyWordDO> page = getPage();
		
		keyWordService.findByPage(page);
		
		return jsonPage(page);
	}
	@ResponseBody
	@RequestMapping("/getKeyWordList/{keyword}")
	public String getKeyWordList(@PathVariable String keyword) {
	
		Page<KeyWordDO> page = getPage();
		
		keyWordService.findByParam(keyword, page);
		
		return jsonPage(page);
	}
	
	@RequestMapping("/edit")
	public String edit(Model model) {
	
		String id = request.getParameter("id");
		if (id != null) {
			KeyWordDO keyWord = keyWordService.findByID(Long.parseLong(id));
			model.addAttribute("keyWord" , keyWord);
			
			//如果关键字没有分配类别，将会抛出异常，所以需要对没有查找到的类别的关键字情况做处理
			if(keyWord.getCategoryCode()!=null&&!keyWord.getCategoryCode().equals("")){
				CategoryDO category = categoryService.findByCode(keyWord
						.getCategoryCode());
				model.addAttribute("categoryName" , category.getName());
			}
			
		}
		
		return "/keyword/edit";
	}
	
	@ResponseBody
	@RequestMapping("/editKeyWord")
	public String editKeyWord(KeyWordDO keyWord) {
	
		JSONObject json = new JSONObject();
		
		try {
			
			KeyWordDO key = keyWordService.findByID(keyWord.getId());
			if (key != null) {
				keyWord.setKeyword(keyWord.getKeyword());
				keyWordService.update(keyWord);
				json.put("success" , true);
				json.put("data" , "更新成功");
				
			} else {
				keyWordService.save(keyWord);
				json.put("success" , true);
				json.put("data" , "添加成功");
			}
		} catch (Exception e) {
			
			LOGGER.error("更新关键字失败");
			json.put("success" , false);
			json.put("data" , "更新失败");
		}
		
		return json.toJSONString();
	}
	
	@ResponseBody
	@RequestMapping("/delKeyWord/{id}")
	public String delKeyWord(@PathVariable long id) {
	
		try {
			
			keyWordService.delete(id);
			return Boolean.TRUE.toString();
		} catch (Exception e) {
			
			LOGGER.error("删除失败");
			return Boolean.FALSE.toString();
		}
	}
}

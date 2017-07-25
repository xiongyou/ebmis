/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.cqu.edu.ebmis.service.ReportService;

@Controller
@RequestMapping("/allReport")
public class AllReportController extends SuperController {
	/**
	 *原始数据报表
	 */
	@Autowired
	private ReportService reportService;
	@RequestMapping("/originDataReportList")
	public String list(Model model) {
		return "/allReport/originDataReportList";
	}
	@ResponseBody
	@RequestMapping("/originDataReport")
	public String originDataReport(Model model, HttpServletResponse response) {
		HashMap map=new HashMap();
    	map.put("size", 1);
    	map.put("offset", 10);
    	List<Map<String, Object>> originDataReportList=reportService.getOriginData(map);
    	String str="{"+"\"total\":"+originDataReportList.size()+","+"\"rows\":[";
    	for(Map<String, Object> oneMap:originDataReportList){
    		str+="{";
    		Set<String> setstr=oneMap.keySet();
    		for(String keyStr:setstr){
    			str+="\""+keyStr+"\":"+"\""+oneMap.get(keyStr)+"\",";
    		}
    		str=str.substring(0, str.lastIndexOf(","));  
    		str+="},";
    	}
    	str=str.substring(0, str.lastIndexOf(","));  
    	str+="]}";
    	System.out.println(str);
    	/*JSONArray jsonArr=JSONArray.parseArray(str);*/
    	return str;
	}

	
}

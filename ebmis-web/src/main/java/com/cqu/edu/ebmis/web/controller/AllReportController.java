/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String originDataReportList(Model model) {
		return "/allReport/originDataReportList";
	}
	@ResponseBody
	@RequestMapping("/originDataReport")
	public String originDataReport(Model model) {
		HashMap map=new HashMap();
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
    	map.put("size", size);
    	map.put("offset", index);
    	List<Map<String, Object>> originDataReportList=reportService.getOriginData(map);
    	int allCount=reportService.getOriginDataCount();
    	String str="{"+"\"total\":"+allCount+","+"\"rows\":[";
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
    	/*JSONArray jsonArr=JSONArray.parseArray(str);*/
    	return str;
	}
	@RequestMapping("/CQLocalStoreList")
	public String CQLocalStoreList(Model model) {
		return "/allReport/CQLocalStoreList";
	}
	@ResponseBody
	@RequestMapping("/CQLocalStoreReport")
	public String CQLocalStoreReport(Model model) {
		HashMap map=new HashMap();
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> originDataReportList=reportService.getCQLocalStore(map);
		int allCount=reportService.getCQLocalStoreCount();
		String str="{"+"\"total\":"+allCount+","+"\"rows\":[";
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
		return str;
	}
	@RequestMapping("/AliClassifyList")
	public String AliClassifyList(Model model) {
		return "/allReport/AliClassifyList";
	}
	@ResponseBody
	@RequestMapping("/AliClassifyReport")
	public String AliClassifyReport(Model model) {
		HashMap map=new HashMap();
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> originDataReportList=reportService.AliClassifyData(map);
		int allCount=reportService.AliClassifyCount();
		String str="{"+"\"total\":"+allCount+","+"\"rows\":[";
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
		return str;
	}
	@RequestMapping("/TmMonthProductList")
	public String TmMonthProductList(Model model) {
		return "/allReport/TmMonthProductList";
	}
	@ResponseBody
	@RequestMapping("/TmMonthProductReport")
	public String TmMonthProductReport(Model model) {
		HashMap map=new HashMap();
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> originDataReportList=reportService.TmMonthProductData(map);
		String str="{"+"\"total\":"+20+","+"\"rows\":[";
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
		return str;
	}
	@RequestMapping("/TbMonthProductList")
	public String TbMonthProductList(Model model) {
		return "/allReport/TbMonthProductList";
	}
	@ResponseBody
	@RequestMapping("/TbMonthProductReport")
	public String TbMonthProductReport(Model model) {
		HashMap map=new HashMap();
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> TbMonthProductList=reportService.TbMonthProductData(map);
		String str="{"+"\"total\":"+20+","+"\"rows\":[";
		for(Map<String, Object> oneMap:TbMonthProductList){
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
		return str;
	}

	
}

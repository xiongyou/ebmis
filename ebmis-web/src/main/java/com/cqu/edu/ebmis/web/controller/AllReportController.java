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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqu.edu.ebmis.domain.ProductBaseInfoDO;
import com.cqu.edu.ebmis.service.ReportService;
import com.cqu.edu.ebmis.service.vo.User;

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
	@RequestMapping("/auditProduct/{auditseq}")
	public String auditProduct(@PathVariable String auditseq) {
	
		String[] strs = auditseq.split(":");
		
		session=request.getSession();
		User user=(User) session.getAttribute("user");
		String userName=user.getUserName();
		HashMap map=new HashMap();
		map.put("userName", userName);
		map.put("dataID", strs[0]);
		map.put("isValid", strs[1]);
		reportService.updateOriginData(map);
		return Boolean.TRUE.toString();
	}
	
	@ResponseBody
	@RequestMapping("/originDataReport")
	public String originDataReport(Model model) {
		HashMap map=new HashMap();
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		String word="%";
		String word1=request.getParameter("word");
		if(word1==null){
			word1="";
		}
		word+=word1+"%";
		String checkedNum1=request.getParameter("checkedNum");
		String platform=request.getParameter("platform");
		String level0=request.getParameter("level0");
		String level1=request.getParameter("level1");
		String level2=request.getParameter("level2");
		String level3=request.getParameter("level3");
		Integer checkedNum=Integer.parseInt(checkedNum1);
    	map.put("size", size);
    	map.put("offset", index);
    	map.put("word", word);
    	map.put("platform", platform);
    	map.put("level0", level0);
    	map.put("level1", level1);
    	map.put("level2", level2);
    	map.put("level3", level3);
    	map.put("checkedNum", checkedNum);
    	List<Map<String, Object>> originDataReportList=reportService.getOriginData(map);
    	int allCount=reportService.getOriginDataCount(map);
    	String str="";
    	if(allCount==0){
    		str="{"+"\"total\":"+allCount+","+"\"rows\":[]}";
    	}else{
    		str="{"+"\"total\":"+allCount+","+"\"rows\":[";
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
    	}
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
		String productYear=request.getParameter("ExcelYear");
		String productMonth=request.getParameter("ExcelMonth");
		String productQuarter=request.getParameter("ExcelQuarter");
		if(productYear.equals("请选择")){
			productYear=null;
		}
		if(productMonth.equals("请选择")){
			productMonth=null;
		}
		if(productQuarter.equals("请选择")){
			productQuarter=null;
		}else if(productQuarter.equals("一")){
			productQuarter="一季度";
			int firstMonth=1;
			int endMonth=3;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}else if(productQuarter.equals("二")){
			productQuarter="二季度";
			int firstMonth=4;
			int endMonth=6;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}
		map.put("productYear", productYear);
		map.put("productMonth", productMonth);
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> CQLocalStoreList=reportService.getCQLocalStore(map);
		int allCount=reportService.getCQLocalStoreCount(map);
		String str="";
		if(allCount==0){
    		str="{"+"\"total\":"+allCount+","+"\"rows\":[]}";
    	}else{
    		str="{"+"\"total\":"+allCount+","+"\"rows\":[";
		for(Map<String, Object> oneMap:CQLocalStoreList){
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
    	}
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
		String productYear=request.getParameter("ExcelYear");
		String productMonth=request.getParameter("ExcelMonth");
		String productQuarter=request.getParameter("ExcelQuarter");
		if(productYear.equals("请选择")){
			productYear=null;
		}
		if(productMonth.equals("请选择")){
			productMonth=null;
		}
		if(productQuarter.equals("请选择")){
			productQuarter=null;
		}else if(productQuarter.equals("一")){
			productQuarter="一季度";
			int firstMonth=1;
			int endMonth=3;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}else if(productQuarter.equals("二")){
			productQuarter="二季度";
			int firstMonth=4;
			int endMonth=6;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}
		map.put("productYear", productYear);
		map.put("productMonth", productMonth);
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> AliClassifyReportList=reportService.AliClassifyData(map);
		int allCount=reportService.AliClassifyCount(map);
		String str="";
		if(allCount==0){
    		str="{"+"\"total\":"+allCount+","+"\"rows\":[]}";
    	}else{
    		str="{"+"\"total\":"+allCount+","+"\"rows\":[";
		for(Map<String, Object> oneMap:AliClassifyReportList){
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
    	}
		return str;
	}
	@RequestMapping("/CQFarmNetMarketClassifyList")
	public String CQFarmNetMarketClassifyList(Model model) {
		return "/allReport/CQFarmNetMarketClassifyList";
	}
	@ResponseBody
	@RequestMapping("/CQFarmNetMarketClassifyReport")
	public String CQFarmNetMarketClassifyReport(Model model) {
		HashMap map=new HashMap();
		String productYear=request.getParameter("ExcelYear");
		String productMonth=request.getParameter("ExcelMonth");
		String productQuarter=request.getParameter("ExcelQuarter");
		if(productYear.equals("请选择")){
			productYear=null;
		}
		if(productMonth.equals("请选择")){
			productMonth=null;
		}
		if(productQuarter.equals("请选择")){
			productQuarter=null;
		}else if(productQuarter.equals("一")){
			productQuarter="一季度";
			int firstMonth=1;
			int endMonth=3;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}else if(productQuarter.equals("二")){
			productQuarter="二季度";
			int firstMonth=4;
			int endMonth=6;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}
		map.put("productYear", productYear);
		map.put("productMonth", productMonth);
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> CQFarmNetMarketClassifyList=reportService.CQFarmNetMarketClassifyData(map);
		int allCount=reportService.CQFarmNetMarketClassifyCount(map);
		String str="";
		if(allCount==0){
			str="{"+"\"total\":"+allCount+","+"\"rows\":[]}";
		}else{
			str="{"+"\"total\":"+allCount+","+"\"rows\":[";
			for(Map<String, Object> oneMap:CQFarmNetMarketClassifyList){
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
		}
		return str;
	}
	
	@RequestMapping("/ControlStatisticsTotalList")
	public String ControlStatisticsTotalList(Model model) {
		return "/allReport/ControlStatisticsTotalList";
	}
	@ResponseBody
	@RequestMapping("/ControlStatisticsTotalReport")
	public String ControlStatisticsTotalReport(Model model) {
		HashMap map=new HashMap();
		String productYear=request.getParameter("ExcelYear");
		String productMonth=request.getParameter("ExcelMonth");
		String productQuarter=request.getParameter("ExcelQuarter");
		if(productYear.equals("请选择")){
			productYear=null;
		}
		if(productMonth.equals("请选择")){
			productMonth=null;
		}
		if(productQuarter.equals("请选择")){
			productQuarter=null;
		}else if(productQuarter.equals("一")){
			productQuarter="一季度";
			int firstMonth=1;
			int endMonth=3;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}else if(productQuarter.equals("二")){
			productQuarter="二季度";
			int firstMonth=4;
			int endMonth=6;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}
		map.put("productYear", productYear);
		map.put("productMonth", productMonth);
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> ControlStatisticsTotalList=reportService.ControlStatisticsTotalData(map);
		int allCount=reportService.ControlStatisticsTotalCount(map);
		String str="";
		if(allCount==0){
			str="{"+"\"total\":"+allCount+","+"\"rows\":[]}";
		}else{
			str="{"+"\"total\":"+allCount+","+"\"rows\":[";
			for(Map<String, Object> oneMap:ControlStatisticsTotalList){
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
		}
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
		String productYear=request.getParameter("ExcelYear");
		String productMonth=request.getParameter("ExcelMonth");
		String productQuarter=request.getParameter("ExcelQuarter");
		if(productYear.equals("请选择")){
			productYear=null;
		}
		if(productMonth.equals("请选择")){
			productMonth=null;
		}
		if(productQuarter.equals("请选择")){
			productQuarter=null;
		}else if(productQuarter.equals("一")){
			productQuarter="一季度";
			int firstMonth=1;
			int endMonth=3;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}else if(productQuarter.equals("二")){
			productQuarter="二季度";
			int firstMonth=4;
			int endMonth=6;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}
		map.put("productYear", productYear);
		map.put("productMonth", productMonth);
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> TmMonthProductReportList=reportService.TmMonthProductData(map);
		String str="";
		if(TmMonthProductReportList.size()==0){
    		str="{\"total\":0,\"rows\":[]}";
    	}else{
    		str="{\"total\":20,\"rows\":[";
    		for(Map<String, Object> oneMap:TmMonthProductReportList){
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
    	}
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
		String productYear=request.getParameter("ExcelYear");
		String productMonth=request.getParameter("ExcelMonth");
		String productQuarter=request.getParameter("ExcelQuarter");
		if(productYear.equals("请选择")){
			productYear=null;
		}
		if(productMonth.equals("请选择")){
			productMonth=null;
		}
		if(productQuarter.equals("请选择")){
			productQuarter=null;
		}else if(productQuarter.equals("一")){
			productQuarter="一季度";
			int firstMonth=1;
			int endMonth=3;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}else if(productQuarter.equals("二")){
			productQuarter="二季度";
			int firstMonth=4;
			int endMonth=6;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}
		map.put("productYear", productYear);
		map.put("productMonth", productMonth);
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> TbMonthProductList=reportService.TbMonthProductData(map);
		String str="";
		if(TbMonthProductList.size()==0){
    		str="{\"total\":0,\"rows\":[]}";
    	}else{
    		str="{\"total\":20,\"rows\":[";
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
    	}
		return str;
	}
	@RequestMapping("/AllProductNumList")
	public String AllProductNumList(Model model) {
		return "/allReport/AllProductNumList";
	}
	@ResponseBody
	@RequestMapping("/AllProductNumReport")
	public String AllProductNumReport(Model model) {
		HashMap map=new HashMap();
		String productYear=request.getParameter("ExcelYear");
		String productMonth=request.getParameter("ExcelMonth");
		String productQuarter=request.getParameter("ExcelQuarter");
		if(productYear.equals("请选择")){
			productYear=null;
		}
		if(productMonth.equals("请选择")){
			productMonth=null;
		}
		if(productQuarter.equals("请选择")){
			productQuarter=null;
		}else if(productQuarter.equals("一")){
			productQuarter="一季度";
			int firstMonth=1;
			int endMonth=3;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}else if(productQuarter.equals("二")){
			productQuarter="二季度";
			int firstMonth=4;
			int endMonth=6;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		map.put("productYear", productYear);
		map.put("productMonth", productMonth);
		List<Map<String, Object>> originDataReportList=reportService.allProductNumData(map);
		int allCount=reportService.allProductNumCount(map);
		String str="";
		if(allCount==0){
    		str="{"+"\"total\":"+allCount+","+"\"rows\":[]}";
    	}else{
    		str="{"+"\"total\":"+allCount+","+"\"rows\":[";
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
    	}
		return str;
	}
	@RequestMapping("/CQFarmProductNumList")
	public String CQFarmProductNumList(Model model) {
		return "/allReport/CQFarmProductNumList";
	}
	@ResponseBody
	@RequestMapping("/CQFarmProductNumReport")
	public String CQFarmProductNumReport(Model model) {
		HashMap map=new HashMap();
		String productYear=request.getParameter("ExcelYear");
		String productMonth=request.getParameter("ExcelMonth");
		String productQuarter=request.getParameter("ExcelQuarter");
		if(productYear.equals("请选择")){
			productYear=null;
		}
		if(productMonth.equals("请选择")){
			productMonth=null;
		}
		if(productQuarter.equals("请选择")){
			productQuarter=null;
		}else if(productQuarter.equals("一")){
			productQuarter="一季度";
			int firstMonth=1;
			int endMonth=3;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}else if(productQuarter.equals("二")){
			productQuarter="二季度";
			int firstMonth=4;
			int endMonth=6;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		map.put("productYear", productYear);
		map.put("productMonth", productMonth);
		List<Map<String, Object>> originDataReportList=reportService.CQFarmProductNumData(map);
		int allCount=reportService.CQFarmProductNumCount(map);
		String str="";
		if(allCount==0){
    		str="{"+"\"total\":"+allCount+","+"\"rows\":[]}";
    	}else{
    		str="{"+"\"total\":"+allCount+","+"\"rows\":[";
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
    	}
		return str;
	}
	@RequestMapping("/CQFarmProductStoreNumList")
	public String CQFarmProductStoreNumList(Model model) {
		return "/allReport/CQFarmProductStoreNumList";
	}
	@ResponseBody
	@RequestMapping("/CQFarmProductStoreNumReport")
	public String CQFarmProductStoreNumReport(Model model) {
		HashMap map=new HashMap();
		String productYear=request.getParameter("ExcelYear");
		String productMonth=request.getParameter("ExcelMonth");
		String productQuarter=request.getParameter("ExcelQuarter");
		if(productYear.equals("请选择")){
			productYear=null;
		}
		if(productMonth.equals("请选择")){
			productMonth=null;
		}
		if(productQuarter.equals("请选择")){
			productQuarter=null;
		}else if(productQuarter.equals("一")){
			productQuarter="一季度";
			int firstMonth=1;
			int endMonth=3;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}else if(productQuarter.equals("二")){
			productQuarter="二季度";
			int firstMonth=4;
			int endMonth=6;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		map.put("productYear", productYear);
		map.put("productMonth", productMonth);
		List<Map<String, Object>> originDataReportList=reportService.CQFarmProductStoreNumData(map);
		int allCount=reportService.CQFarmProductStoreNumCount(map);
		String str="";
		if(allCount==0){
			str="{"+"\"total\":"+allCount+","+"\"rows\":[]}";
		}else{
			str="{"+"\"total\":"+allCount+","+"\"rows\":[";
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
		}
		return str;
	}
	@RequestMapping("/EveryCityFarmProductList")
	public String EveryCityFarmProductList(Model model) {
		return "/allReport/EveryCityFarmProductList";
	}
	@ResponseBody
	@RequestMapping("/EveryCityFarmProductNumReport")
	public String EveryCityFarmProductNumReport(Model model) {
		HashMap map=new HashMap();
		String productYear=request.getParameter("ExcelYear");
		String productMonth=request.getParameter("ExcelMonth");
		String productQuarter=request.getParameter("ExcelQuarter");
		if(productYear.equals("请选择")){
			productYear=null;
		}
		if(productMonth.equals("请选择")){
			productMonth=null;
		}
		if(productQuarter.equals("请选择")){
			productQuarter=null;
		}else if(productQuarter.equals("一")){
			productQuarter="一季度";
			int firstMonth=1;
			int endMonth=3;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}else if(productQuarter.equals("二")){
			productQuarter="二季度";
			int firstMonth=4;
			int endMonth=6;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		map.put("productYear", productYear);
		map.put("productMonth", productMonth);
		List<Map<String, Object>> originDataReportList=reportService.EveryCityFarmProductNumData(map);
		int allCount=reportService.EveryCityFarmProductNumCount(map);
		String str="";
		if(allCount==0){
			str="{"+"\"total\":"+allCount+","+"\"rows\":[]}";
		}else{
			str="{"+"\"total\":"+allCount+","+"\"rows\":[";
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
		}
		return str;
	}
	@RequestMapping("/PlatformStoreNumList")
	public String PlatformStoreNumList(Model model) {
		return "/allReport/PlatformStoreNumList";
	}
	@ResponseBody
	@RequestMapping("/PlatformStoreNumReport")
	public String PlatformStoreNumReport(Model model) {
		HashMap map=new HashMap();
		String productYear=request.getParameter("ExcelYear");
		String productMonth=request.getParameter("ExcelMonth");
		String productQuarter=request.getParameter("ExcelQuarter");
		if(productYear.equals("请选择")){
			productYear=null;
		}
		if(productMonth.equals("请选择")){
			productMonth=null;
		}
		if(productQuarter.equals("请选择")){
			productQuarter=null;
		}else if(productQuarter.equals("一")){
			productQuarter="一季度";
			int firstMonth=1;
			int endMonth=3;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}else if(productQuarter.equals("二")){
			productQuarter="二季度";
			int firstMonth=4;
			int endMonth=6;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		map.put("productYear", productYear);
		map.put("productMonth", productMonth);
		List<Map<String, Object>> originDataReportList=reportService.PlatformStoreNumData(map);
		int allCount=reportService.PlatformStoreNumCount(map);
		String str="";
		if(allCount==0){
    		str="{"+"\"total\":"+allCount+","+"\"rows\":[]}";
    	}else{
    		str="{"+"\"total\":"+allCount+","+"\"rows\":[";
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
    	}
		return str;
	}
	@RequestMapping("/ClassifySystemList")
	public String ClassifySystemList(Model model) {
		return "/allReport/ClassifySystemList";
	}
	@ResponseBody
	@RequestMapping("/ClassifySystemReport")
	public String ClassifySystemReport(Model model) {
		HashMap map=new HashMap();
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> originDataReportList=reportService.ClassifySystemData(map);
		int allCount=reportService.ClassifySystemCount();
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
	@RequestMapping("/EveryDayList")
	public String EveryDayList(Model model) {
		return "/allReport/EveryDayList";
	}
	@ResponseBody
	@RequestMapping("/EveryDayListReport")
	public String EveryDayListReport(Model model) {
		HashMap map=new HashMap();
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> originDataReportList=reportService.EveryDayListData(map);
		int allCount=reportService.EveryDayListCount();
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
	@RequestMapping("/OneClassifyList")
	public String OneClassifyList(Model model) {
		return "/allReport/OneClassifyList";
	}
	@ResponseBody
	@RequestMapping("/OneClassifyReport")
	public String OneClassifyReport(Model model) {
		HashMap map=new HashMap();
		String productYear=request.getParameter("ExcelYear");
		String productMonth=request.getParameter("ExcelMonth");
		String productQuarter=request.getParameter("ExcelQuarter");
		if(productYear.equals("请选择")){
			productYear=null;
		}
		if(productMonth.equals("请选择")){
			productMonth=null;
		}
		if(productQuarter.equals("请选择")){
			productQuarter=null;
		}else if(productQuarter.equals("一")){
			productQuarter="一季度";
			int firstMonth=1;
			int endMonth=3;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}else if(productQuarter.equals("二")){
			productQuarter="二季度";
			int firstMonth=4;
			int endMonth=6;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}
		map.put("productYear", productYear);
		map.put("productMonth", productMonth);
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> originDataReportList=reportService.OneClassifyData(map);
		int allCount=reportService.OneClassifyCount(map);
		String str="";
		if(allCount==0){
    		str="{"+"\"total\":"+allCount+","+"\"rows\":[]}";
    	}else{
    		str="{"+"\"total\":"+allCount+","+"\"rows\":[";
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
    	}
		return str;
	}
	@RequestMapping("/FreshClassifyList")
	public String FreshClassifyList(Model model) {
		return "/allReport/FreshClassifyList";
	}
	@ResponseBody
	@RequestMapping("/FreshClassifyReport")
	public String FreshClassifyReport(Model model) {
		HashMap map=new HashMap();
		String productYear=request.getParameter("ExcelYear");
		String productMonth=request.getParameter("ExcelMonth");
		String productQuarter=request.getParameter("ExcelQuarter");
		if(productYear.equals("请选择")){
			productYear=null;
		}
		if(productMonth.equals("请选择")){
			productMonth=null;
		}
		if(productQuarter.equals("请选择")){
			productQuarter=null;
		}else if(productQuarter.equals("一")){
			productQuarter="一季度";
			int firstMonth=1;
			int endMonth=3;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}else if(productQuarter.equals("二")){
			productQuarter="二季度";
			int firstMonth=4;
			int endMonth=6;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}
		map.put("productYear", productYear);
		map.put("productMonth", productMonth);
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> originDataReportList=reportService.FreshClassifyData(map);
		int allCount=reportService.FreshClassifyCount(map);
		String str="";
		if(allCount==0){
    		str="{"+"\"total\":"+allCount+","+"\"rows\":[]}";
    	}else{
    		str="{"+"\"total\":"+allCount+","+"\"rows\":[";
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
    	}
		return str;
	}
	@RequestMapping("/NoFreshClassifyList")
	public String NoFreshClassifyList(Model model) {
		return "/allReport/NoFreshClassifyList";
	}
	@ResponseBody
	@RequestMapping("/NoFreshClassifyReport")
	public String NoFreshClassifyReport(Model model) {
		HashMap map=new HashMap();
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		String productYear=request.getParameter("ExcelYear");
		String productMonth=request.getParameter("ExcelMonth");
		String productQuarter=request.getParameter("ExcelQuarter");
		if(productYear.equals("请选择")){
			productYear=null;
		}
		if(productMonth.equals("请选择")){
			productMonth=null;
		}
		if(productQuarter.equals("请选择")){
			productQuarter=null;
		}else if(productQuarter.equals("一")){
			productQuarter="一季度";
			int firstMonth=1;
			int endMonth=3;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}else if(productQuarter.equals("二")){
			productQuarter="二季度";
			int firstMonth=4;
			int endMonth=6;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}
		map.put("productYear", productYear);
		map.put("productMonth", productMonth);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> originDataReportList=reportService.NoFreshClassifyData(map);
		int allCount=reportService.NoFreshClassifyCount(map);
		String str="";
		if(allCount==0){
    		str="{"+"\"total\":"+allCount+","+"\"rows\":[]}";
    	}else{
    		str="{"+"\"total\":"+allCount+","+"\"rows\":[";
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
    	}
		return str;
	}
	@RequestMapping("/CQFarmProductEveryMarketList")
	public String CQFarmProductEveryMarketList(Model model) {
		return "/allReport/CQFarmProductEveryMarketList";
	}
	@ResponseBody
	@RequestMapping("/CQFarmProductEveryMarketReport")
	public String CQFarmProductEveryMarketReport(Model model) {
		HashMap map=new HashMap();
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		String productYear=request.getParameter("ExcelYear");
		String productMonth=request.getParameter("ExcelMonth");
		String productQuarter=request.getParameter("ExcelQuarter");
		if(productYear.equals("请选择")){
			productYear=null;
		}
		if(productMonth.equals("请选择")){
			productMonth=null;
		}
		if(productQuarter.equals("请选择")){
			productQuarter=null;
		}else if(productQuarter.equals("一")){
			productQuarter="一季度";
			int firstMonth=1;
			int endMonth=3;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}else if(productQuarter.equals("二")){
			productQuarter="二季度";
			int firstMonth=4;
			int endMonth=6;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}
		map.put("productYear", productYear);
		map.put("productMonth", productMonth);
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> originDataReportList=reportService.CQFarmProductEveryMarketData(map);
		int allCount=reportService.CQFarmProductEveryMarketCount(map);
		String str="";
		if(allCount==0){
    		str="{"+"\"total\":"+allCount+","+"\"rows\":[]}";
    	}else{
    		str="{"+"\"total\":"+allCount+","+"\"rows\":[";
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
    	}
		return str;
	}
	@RequestMapping("/CQFarmProductEveryStoreList")
	public String CQFarmProductEveryStoreList(Model model) {
		return "/allReport/CQFarmProductEveryStoreList";
	}
	@ResponseBody
	@RequestMapping("/CQFarmProductEveryStoreReport")
	public String CQFarmProductEveryStoreReport(Model model) {
		HashMap map=new HashMap();
		String productYear=request.getParameter("ExcelYear");
		String productMonth=request.getParameter("ExcelMonth");
		String productQuarter=request.getParameter("ExcelQuarter");
		if(productYear.equals("请选择")){
			productYear=null;
		}
		if(productMonth.equals("请选择")){
			productMonth=null;
		}
		if(productQuarter.equals("请选择")){
			productQuarter=null;
		}else if(productQuarter.equals("一")){
			productQuarter="一季度";
			int firstMonth=1;
			int endMonth=3;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}else if(productQuarter.equals("二")){
			productQuarter="二季度";
			int firstMonth=4;
			int endMonth=6;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}
		map.put("productYear", productYear);
		map.put("productMonth", productMonth);
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> originDataReportList=reportService.CQFarmProductEveryStoreData(map);
		int allCount=reportService.CQFarmProductEveryStoreCount(map);
		String str="";
		if(allCount==0){
    		str="{"+"\"total\":"+allCount+","+"\"rows\":[]}";
    	}else{
    		str="{"+"\"total\":"+allCount+","+"\"rows\":[";
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
    	}
		return str;
	}
	@RequestMapping("/MarketCQFarmProductStoreList")
	public String MarketCQFarmProductStoreList(Model model) {
		return "/allReport/MarketCQFarmProductStoreList";
	}
	@ResponseBody
	@RequestMapping("/MarketCQFarmProductStoreReport")
	public String MarketCQFarmProductStoreReport(Model model) {
		HashMap map=new HashMap();
		String productYear=request.getParameter("ExcelYear");
		String productMonth=request.getParameter("ExcelMonth");
		String productQuarter=request.getParameter("ExcelQuarter");
		if(productYear.equals("请选择")){
			productYear=null;
		}
		if(productMonth.equals("请选择")){
			productMonth=null;
		}
		if(productQuarter.equals("请选择")){
			productQuarter=null;
		}else if(productQuarter.equals("一")){
			productQuarter="一季度";
			int firstMonth=1;
			int endMonth=3;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}else if(productQuarter.equals("二")){
			productQuarter="二季度";
			int firstMonth=4;
			int endMonth=6;
			map.put("productQuarter", productQuarter);
			map.put("firstMonth", firstMonth);
			map.put("endMonth", endMonth);
		}
		map.put("productYear", productYear);
		map.put("productMonth", productMonth);
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> originDataReportList=reportService.MarketCQFarmProductStoreData(map);
		int allCount=reportService.MarketCQFarmProductStoreCount(map);
		String str="";
		if(allCount==0){
    		str="{"+"\"total\":"+allCount+","+"\"rows\":[]}";
    	}else{
    		str="{"+"\"total\":"+allCount+","+"\"rows\":[";
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
    	}
		return str;
	}
	@RequestMapping("/CQEveryCityStoreList")
	public String CQEveryCityStoreList(Model model) {
		return "/allReport/CQEveryCityStoreList";
	}
	@ResponseBody
	@RequestMapping("/CQEveryCityStoreReport")
	public String CQEveryCityStoreReport(Model model) {
		HashMap map=new HashMap();
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> originDataReportList=reportService.CQEveryCityStoreData(map);
		int allCount=reportService.CQEveryCityStoreCount();
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

	
}

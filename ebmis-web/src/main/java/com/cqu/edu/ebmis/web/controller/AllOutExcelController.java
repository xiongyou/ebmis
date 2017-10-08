/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.filechooser.FileSystemView;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cqu.edu.ebmis.service.ReportService;

@Controller
@RequestMapping("/outExcel")
public class AllOutExcelController extends SuperController {
	@Autowired
	private ReportService reportService;
	/**
	 *原始数据报表导出Excel
	 */
	@ResponseBody
	@RequestMapping(value="/originDataExcel",produces="html/text;charset=UTF-8")
	public String originDataReport(Model model) {
		JSONObject json = new JSONObject();
		String platName=request.getParameter("platName");
		Date date = new Date();  
	        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");   
	        String fileName =platName+sdf.format(date);  
	        //得到桌面路径  
	        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();  
	        String desktopPath = desktopDir.getAbsolutePath();  
	        String desktopDirPath = desktopPath.replace("\\","\\\\");  
	        String filePath = desktopDirPath + "\\\\" +fileName + ".xls";  
	        String[] titles = {"销售额","SKU","销量","平台","一级"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
			HashMap map=new HashMap();
			String size1=request.getParameter("_size");
			String index1=request.getParameter("_index");
			Integer size=Integer.parseInt(size1);
			Integer index=Integer.parseInt(index1);
			map.put("size", size);
			map.put("offset", index);
			List<Map<String, Object>> originDataReportList=reportService.getOriginData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("data" , "导出失败");
				}
		}else{
			HashMap map=new HashMap();
			Integer size=null;
			Integer index=null;
			map.put("size", size);
			map.put("offset", index);
			List<Map<String, Object>> originDataReportList=reportService.getOriginData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("success" , true);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("success" ,false);
					json.put("data" , "导出失败");
				}
		}
		return json.toJSONString();
	}
	@ResponseBody
	@RequestMapping(value="/CQLocalStoreExcel",produces="html/text;charset=UTF-8")
	public String CQLocalStoreExcel(Model model) {
		JSONObject json = new JSONObject();
		String platName=request.getParameter("platName");
		Date date = new Date();  
	        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");   
	        String fileName =platName+sdf.format(date);  
	        //得到桌面路径  
	        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();  
	        String desktopPath = desktopDir.getAbsolutePath();  
	        String desktopDirPath = desktopPath.replace("\\","\\\\");  
	        String filePath = desktopDirPath + "\\\\" +fileName + ".xls";  
	        String[] titles = {"店铺编号","店铺实际ID","时间","链接","公司","名称","销售额(万元)","SKU","销量","平台"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
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
			List<Map<String, Object>> originDataReportList=reportService.getCQLocalStore(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("data" , "导出失败");
				}
		}else{
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
			Integer size=null;
			Integer index=null;
			map.put("size", size);
			map.put("offset", index);
			List<Map<String, Object>> originDataReportList=reportService.getCQLocalStore(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("success" , true);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("success" ,false);
					json.put("data" , "导出失败");
				}
		}
		return json.toJSONString();
	}
	@ResponseBody
	@RequestMapping(value="/EveryCityFarmProductExcel",produces="html/text;charset=UTF-8")
	public String EveryCityFarmProductExcel(Model model) {
		JSONObject json = new JSONObject();
		String platName=request.getParameter("platName");
		Date date = new Date();  
		DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");   
		String fileName =platName+sdf.format(date);  
		//得到桌面路径  
		File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();  
		String desktopPath = desktopDir.getAbsolutePath();  
		String desktopDirPath = desktopPath.replace("\\","\\\\");  
		String filePath = desktopDirPath + "\\\\" +fileName + ".xls";  
		String[] titles = {"区县","网店数","SKU数","时间","销售额"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
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
			List<Map<String, Object>> originDataReportList=reportService.EveryCityFarmProductNumData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
			try {
				writeExcel(filePath, titles, lists);
				json.put("data" , "导出成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				json.put("data" , "导出失败");
			}
		}else{
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
			Integer size=null;
			Integer index=null;
			map.put("size", size);
			map.put("offset", index);
			List<Map<String, Object>> originDataReportList=reportService.EveryCityFarmProductNumData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
			try {
				writeExcel(filePath, titles, lists);
				json.put("success" , true);
				json.put("data" , "导出成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				json.put("success" ,false);
				json.put("data" , "导出失败");
			}
		}
		return json.toJSONString();
	}
	@ResponseBody
	@RequestMapping(value="/AliClassifyExcel",produces="html/text;charset=UTF-8")
	public String AliClassifyExcel(Model model) {
		JSONObject json = new JSONObject();
		String platName=request.getParameter("platName");
		Date date = new Date();  
	        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");   
	        String fileName =platName+sdf.format(date);  
	        //得到桌面路径  
	        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();  
	        String desktopPath = desktopDir.getAbsolutePath();  
	        String desktopDirPath = desktopPath.replace("\\","\\\\");  
	        String filePath = desktopDirPath + "\\\\" +fileName + ".xls";  
	        String[] titles = {"时间","销售额","SKU","平台","一级","销售额占比","SKU占比"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
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
			List<Map<String, Object>> originDataReportList=reportService.AliClassifyData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("data" , "导出失败");
				}
		}else{
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
			Integer size=null;
			Integer index=null;
			map.put("size", size);
			map.put("offset", index);
			List<Map<String, Object>> originDataReportList=reportService.AliClassifyData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("success" , true);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("success" ,false);
					json.put("data" , "导出失败");
				}
		}
		return json.toJSONString();
		
	}
	@ResponseBody
	@RequestMapping(value="/CQFarmNetMarketClassifyExcel",produces="html/text;charset=UTF-8")
	public String CQFarmNetMarketClassifyExcel(Model model) {
		JSONObject json = new JSONObject();
		String platName=request.getParameter("platName");
		Date date = new Date();  
		DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");   
		String fileName =platName+sdf.format(date);  
		//得到桌面路径  
		File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();  
		String desktopPath = desktopDir.getAbsolutePath();  
		String desktopDirPath = desktopPath.replace("\\","\\\\");  
		String filePath = desktopDirPath + "\\\\" +fileName + ".xls";  
		String[] titles = {"生鲜单品数","时间","销售额","生鲜品类数","品类数","单品数（SKU）","平台","生鲜销售额"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
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
			List<Map<String, Object>> originDataReportList=reportService.CQFarmNetMarketClassifyData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
			try {
				writeExcel(filePath, titles, lists);
				json.put("data" , "导出成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				json.put("data" , "导出失败");
			}
		}else{
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
			Integer size=null;
			Integer index=null;
			map.put("size", size);
			map.put("offset", index);
			List<Map<String, Object>> originDataReportList=reportService.CQFarmNetMarketClassifyData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
			try {
				writeExcel(filePath, titles, lists);
				json.put("success" , true);
				json.put("data" , "导出成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				json.put("success" ,false);
				json.put("data" , "导出失败");
			}
		}
		return json.toJSONString();
		
	}
	
	@ResponseBody
	@RequestMapping(value="/ControlStatisticsTotalExcel",produces="html/text;charset=UTF-8")
	public String ControlStatisticsTotalExcel(Model model) {
		JSONObject json = new JSONObject();
		String platName=request.getParameter("platName");
		Date date = new Date();  
		DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");   
		String fileName =platName+sdf.format(date);  
		//得到桌面路径  
		File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();  
		String desktopPath = desktopDir.getAbsolutePath();  
		String desktopDirPath = desktopPath.replace("\\","\\\\");  
		String filePath = desktopDirPath + "\\\\" +fileName + ".xls";  
		String[] titles = {"数值","时间","指标"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
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
			List<Map<String, Object>> originDataReportList=reportService.ControlStatisticsTotalData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
			try {
				writeExcel(filePath, titles, lists);
				json.put("data" , "导出成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				json.put("data" , "导出失败");
			}
		}else{
			HashMap map=new HashMap();
			String productYear=request.getParameter("ExcelYear");
			if(productYear.equals("请选择")){
				productYear=null;
			}
			String productMonth=request.getParameter("ExcelMonth");
			if(productMonth.equals("请选择")){
				productMonth=null;
			}
			String productQuarter=request.getParameter("ExcelQuarter");
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
			Integer size=null;
			Integer index=null;
			map.put("size", size);
			map.put("offset", index);
			List<Map<String, Object>> originDataReportList=reportService.ControlStatisticsTotalData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
			try {
				writeExcel(filePath, titles, lists);
				json.put("success" , true);
				json.put("data" , "导出成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				json.put("success" ,false);
				json.put("data" , "导出失败");
			}
		}
		return json.toJSONString();
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/TmMonthProductExcel",produces="html/text;charset=UTF-8")
	public String TmMonthProductExcel(Model model) {
		JSONObject json = new JSONObject();
		String platName=request.getParameter("platName");
		Date date = new Date();  
	        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");   
	        String fileName =platName+sdf.format(date);  
	        //得到桌面路径  
	        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();  
	        String desktopPath = desktopDir.getAbsolutePath();  
	        String desktopDirPath = desktopPath.replace("\\","\\\\");  
	        String filePath = desktopDirPath + "\\\\" +fileName + ".xls";  
	        String[] titles = {"所属店铺","产品名称","产品类别","时间","商品编号","销售额","销售量","价格"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
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
			List<Map<String, Object>> originDataReportList=reportService.TmMonthProductData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("data" , "导出失败");
				}
		}else{
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
			Integer size=20;
			Integer index=1;
			map.put("size", size);
			map.put("offset", index);
			List<Map<String, Object>> originDataReportList=reportService.TmMonthProductData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("success" , true);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("success" ,false);
					json.put("data" , "导出失败");
				}
		}
		return json.toJSONString();
	}
	@ResponseBody
	@RequestMapping(value="/TbMonthProductExcel",produces="html/text;charset=UTF-8")
	public String TbMonthProductExcel(Model model) {
		JSONObject json = new JSONObject();
		String platName=request.getParameter("platName");
		Date date = new Date();  
	        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");   
	        String fileName =platName+sdf.format(date);  
	        //得到桌面路径  
	        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();  
	        String desktopPath = desktopDir.getAbsolutePath();  
	        String desktopDirPath = desktopPath.replace("\\","\\\\");  
	        String filePath = desktopDirPath + "\\\\" +fileName + ".xls";  
	        String[] titles = {"所属店铺","产品名称","产品类别","时间","商品编号","销售额","销售量","价格"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
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
			List<Map<String, Object>> originDataReportList=reportService.TbMonthProductData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("data" , "导出失败");
				}
		}else{
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
			Integer size=20;
			Integer index=1;
			map.put("size", size);
			map.put("offset", index);
			List<Map<String, Object>> originDataReportList=reportService.TbMonthProductData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("success" , true);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("success" ,false);
					json.put("data" , "导出失败");
				}
		}
		return json.toJSONString();
	}
	@ResponseBody
	@RequestMapping(value="/AllProductNumExcel",produces="html/text;charset=UTF-8")
	public String AllProductNumExcel(Model model) {
		JSONObject json = new JSONObject();
		String platName=request.getParameter("platName");
		Date date = new Date();  
	        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");   
	        String fileName =platName+sdf.format(date);  
	        //得到桌面路径  
	        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();  
	        String desktopPath = desktopDir.getAbsolutePath();  
	        String desktopDirPath = desktopPath.replace("\\","\\\\");  
	        String filePath = desktopDirPath + "\\\\" +fileName + ".xls";  
	        String[] titles = {"SKU","时间","平台"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
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
			List<Map<String, Object>> originDataReportList=reportService.allProductNumData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("data" , "导出失败");
				}
		}else{
			HashMap map=new HashMap();
			Integer size=null;
			Integer index=null;
			map.put("size", size);
			map.put("offset", index);
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
			List<Map<String, Object>> originDataReportList=reportService.allProductNumData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("success" , true);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("success" ,false);
					json.put("data" , "导出失败");
				}
		}
		return json.toJSONString();
	}
	@ResponseBody
	@RequestMapping(value="/CQFarmProductNumExcel",produces="html/text;charset=UTF-8")
	public String CQFarmProductNumExcel(Model model) {
		JSONObject json = new JSONObject();
		String platName=request.getParameter("platName");
		Date date = new Date();  
	        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");   
	        String fileName =platName+sdf.format(date);  
	        //得到桌面路径  
	        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();  
	        String desktopPath = desktopDir.getAbsolutePath();  
	        String desktopDirPath = desktopPath.replace("\\","\\\\");  
	        String filePath = desktopDirPath + "\\\\" +fileName + ".xls";  
	        String[] titles = {"SKU","时间","平台"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
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
			List<Map<String, Object>> originDataReportList=reportService.CQFarmProductNumData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("data" , "导出失败");
				}
		}else{
			HashMap map=new HashMap();
			Integer size=null;
			Integer index=null;
			map.put("size", size);
			map.put("offset", index);
			String productYear=request.getParameter("ExcelYear");
			if(productYear.equals("请选择")){
				productYear=null;
			}
			String productMonth=request.getParameter("ExcelMonth");
			if(productMonth.equals("请选择")){
				productMonth=null;
			}
			map.put("productYear", productYear);
			map.put("productMonth", productMonth);
			List<Map<String, Object>> originDataReportList=reportService.CQFarmProductNumData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("success" , true);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("success" ,false);
					json.put("data" , "导出失败");
				}
		}
		return json.toJSONString();
	}
	@ResponseBody
	@RequestMapping(value="/CQFarmProductStoreNumExcel",produces="html/text;charset=UTF-8")
	public String CQFarmProductStoreNumExcel(Model model) {
		JSONObject json = new JSONObject();
		String platName=request.getParameter("platName");
		Date date = new Date();  
		DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");   
		String fileName =platName+sdf.format(date);  
		//得到桌面路径  
		File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();  
		String desktopPath = desktopDir.getAbsolutePath();  
		String desktopDirPath = desktopPath.replace("\\","\\\\");  
		String filePath = desktopDirPath + "\\\\" +fileName + ".xls";  
		String[] titles = {"个体网店数","合作社网店数","时间","注册地在重庆的农产品网店数","企业网店数","平台"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
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
			List<Map<String, Object>> originDataReportList=reportService.CQFarmProductStoreNumData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
			try {
				writeExcel(filePath, titles, lists);
				json.put("data" , "导出成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				json.put("data" , "导出失败");
			}
		}else{
			HashMap map=new HashMap();
			Integer size=null;
			Integer index=null;
			map.put("size", size);
			map.put("offset", index);
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
			List<Map<String, Object>> originDataReportList=reportService.CQFarmProductStoreNumData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
			try {
				writeExcel(filePath, titles, lists);
				json.put("success" , true);
				json.put("data" , "导出成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				json.put("success" ,false);
				json.put("data" , "导出失败");
			}
		}
		return json.toJSONString();
	}
	
	@ResponseBody
	@RequestMapping(value="/PlatformStoreNumExcel",produces="html/text;charset=UTF-8")
	public String PlatformStoreNumExcel(Model model) {
		JSONObject json = new JSONObject();
		String platName=request.getParameter("platName");
		Date date = new Date();  
	        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");   
	        String fileName =platName+sdf.format(date);  
	        //得到桌面路径  
	        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();  
	        String desktopPath = desktopDir.getAbsolutePath();  
	        String desktopDirPath = desktopPath.replace("\\","\\\\");  
	        String filePath = desktopDirPath + "\\\\" +fileName + ".xls";  
	        String[] titles = {"数量","时间","平台"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
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
			List<Map<String, Object>> originDataReportList=reportService.PlatformStoreNumData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("data" , "导出失败");
				}
		}else{
			HashMap map=new HashMap();
			Integer size=null;
			Integer index=null;
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
			List<Map<String, Object>> originDataReportList=reportService.PlatformStoreNumData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("success" , true);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("success" ,false);
					json.put("data" , "导出失败");
				}
		}
		return json.toJSONString();
	}
	@ResponseBody
	@RequestMapping(value="/ClassifySystemExcel",produces="html/text;charset=UTF-8")
	public String ClassifySystemExcel(Model model) {
		JSONObject json = new JSONObject();
		String platName=request.getParameter("platName");
		Date date = new Date();  
	        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");   
	        String fileName =platName+sdf.format(date);  
	        //得到桌面路径  
	        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();  
	        String desktopPath = desktopDir.getAbsolutePath();  
	        String desktopDirPath = desktopPath.replace("\\","\\\\");  
	        String filePath = desktopDirPath + "\\\\" +fileName + ".xls";  
	        String[] titles = {"二级","零级","三级","一级"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
			HashMap map=new HashMap();
			String size1=request.getParameter("_size");
			String index1=request.getParameter("_index");
			Integer size=Integer.parseInt(size1);
			Integer index=Integer.parseInt(index1);
			map.put("size", size);
			map.put("offset", index);
			List<Map<String, Object>> originDataReportList=reportService.ClassifySystemData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("data" , "导出失败");
				}
		}else{
			HashMap map=new HashMap();
			Integer size=null;
			Integer index=null;
			map.put("size", size);
			map.put("offset", index);
			List<Map<String, Object>> originDataReportList=reportService.ClassifySystemData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("success" , true);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("success" ,false);
					json.put("data" , "导出失败");
				}
		}
		return json.toJSONString();
	}
	@ResponseBody
	@RequestMapping(value="/OneClassifyExcel",produces="html/text;charset=UTF-8")
	public String OneClassifyExcel(Model model) {
		JSONObject json = new JSONObject();
		String platName=request.getParameter("platName");
		Date date = new Date();  
	        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");   
	        String fileName =platName+sdf.format(date);  
	        //得到桌面路径  
	        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();  
	        String desktopPath = desktopDir.getAbsolutePath();  
	        String desktopDirPath = desktopPath.replace("\\","\\\\");  
	        String filePath = desktopDirPath + "\\\\" +fileName + ".xls";  
	        String[] titles = {"时间","销售额(万元)","SKU","销量","一级"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
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
			List<Map<String, Object>> originDataReportList=reportService.OneClassifyData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("data" , "导出失败");
				}
		}else{
			HashMap map=new HashMap();
			Integer size=null;
			Integer index=null;
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
			List<Map<String, Object>> originDataReportList=reportService.OneClassifyData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("success" , true);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("success" ,false);
					json.put("data" , "导出失败");
				}
		}
		return json.toJSONString();
	}
	@ResponseBody
	@RequestMapping(value="/FreshClassifyExcel",produces="html/text;charset=UTF-8")
	public String FreshClassifyExcel(Model model) {
		JSONObject json = new JSONObject();
		String platName=request.getParameter("platName");
		Date date = new Date();  
	        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");   
	        String fileName =platName+sdf.format(date);  
	        //得到桌面路径  
	        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();  
	        String desktopPath = desktopDir.getAbsolutePath();  
	        String desktopDirPath = desktopPath.replace("\\","\\\\");  
	        String filePath = desktopDirPath + "\\\\" +fileName + ".xls";  
	        String[] titles = {"时间","SKU","销售额(万元)","销量","一级"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
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
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("data" , "导出失败");
				}
		}else{
			HashMap map=new HashMap();
			Integer size=null;
			Integer index=null;
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
			List<Map<String, Object>> originDataReportList=reportService.FreshClassifyData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("success" , true);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("success" ,false);
					json.put("data" , "导出失败");
				}
		}
		return json.toJSONString();
	}
	@ResponseBody
	@RequestMapping(value="/NoFreshClassifyExcel",produces="html/text;charset=UTF-8")
	public String NoFreshClassifyExcel(Model model) {
		JSONObject json = new JSONObject();
		String platName=request.getParameter("platName");
		Date date = new Date();  
	        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");   
	        String fileName =platName+sdf.format(date);  
	        //得到桌面路径  
	        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();  
	        String desktopPath = desktopDir.getAbsolutePath();  
	        String desktopDirPath = desktopPath.replace("\\","\\\\");  
	        String filePath = desktopDirPath + "\\\\" +fileName + ".xls";  
	        String[] titles = {"时间","SKU","销售额(万元)","销量","一级"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
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
			List<Map<String, Object>> originDataReportList=reportService.NoFreshClassifyData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("data" , "导出失败");
				}
		}else{
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
			Integer size=null;
			Integer index=null;
			map.put("size", size);
			map.put("offset", index);
			List<Map<String, Object>> originDataReportList=reportService.NoFreshClassifyData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("success" , true);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("success" ,false);
					json.put("data" , "导出失败");
				}
		}
		return json.toJSONString();
	}
	@ResponseBody
	@RequestMapping(value="/CQFarmProductEveryMarketExcel",produces="html/text;charset=UTF-8")
	public String CQFarmProductEveryMarketExcel(Model model) {
		JSONObject json = new JSONObject();
		String platName=request.getParameter("platName");
		Date date = new Date();  
	        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");   
	        String fileName =platName+sdf.format(date);  
	        //得到桌面路径  
	        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();  
	        String desktopPath = desktopDir.getAbsolutePath();  
	        String desktopDirPath = desktopPath.replace("\\","\\\\");  
	        String filePath = desktopDirPath + "\\\\" +fileName + ".xls";  
	        String[] titles = {"省份","时间","销售额（万元）","销量"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
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
			List<Map<String, Object>> originDataReportList=reportService.CQFarmProductEveryMarketData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("data" , "导出失败");
				}
		}else{
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
			Integer size=null;
			Integer index=null;
			map.put("size", size);
			map.put("offset", index);
			List<Map<String, Object>> originDataReportList=reportService.CQFarmProductEveryMarketData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("success" , true);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("success" ,false);
					json.put("data" , "导出失败");
				}
		}
		return json.toJSONString();
	}
	@ResponseBody
	@RequestMapping(value="/CQFarmProductEveryStoreExcel",produces="html/text;charset=UTF-8")
	public String CQFarmProductEveryStoreExcel(Model model) {
		JSONObject json = new JSONObject();
		String platName=request.getParameter("platName");
		Date date = new Date();  
	        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");   
	        String fileName =platName+sdf.format(date);  
	        //得到桌面路径  
	        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();  
	        String desktopPath = desktopDir.getAbsolutePath();  
	        String desktopDirPath = desktopPath.replace("\\","\\\\");  
	        String filePath = desktopDirPath + "\\\\" +fileName + ".xls";  
	        String[] titles = {"数量","省份","时间"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
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
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("data" , "导出失败");
				}
		}else{
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
			Integer size=null;
			Integer index=null;
			map.put("size", size);
			map.put("offset", index);
			List<Map<String, Object>> originDataReportList=reportService.CQFarmProductEveryStoreData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("success" , true);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("success" ,false);
					json.put("data" , "导出失败");
				}
		}
		return json.toJSONString();
	}
	@ResponseBody
	@RequestMapping(value="/MarketCQFarmProductStoreExcel",produces="html/text;charset=UTF-8")
	public String MarketCQFarmProductStoreExcel(Model model) {
		JSONObject json = new JSONObject();
		String platName=request.getParameter("platName");
		Date date = new Date();  
	        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");   
	        String fileName =platName+sdf.format(date);  
	        //得到桌面路径  
	        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();  
	        String desktopPath = desktopDir.getAbsolutePath();  
	        String desktopDirPath = desktopPath.replace("\\","\\\\");  
	        String filePath = desktopDirPath + "\\\\" +fileName + ".xls";  
	        String[] titles = {"城市","店铺编号","省份","时间","掌柜","公司名称","店铺名称","平台"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
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
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
						String valueStr=oneMap.get(keyStr).toString();
						paramsLists.put(num, valueStr);
					    num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("data" , "导出失败");
				}
		}else{
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
			Integer size=null;
			Integer index=null;
			map.put("size", size);
			map.put("offset", index);
			List<Map<String, Object>> originDataReportList=reportService.MarketCQFarmProductStoreData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("success" , true);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("success" ,false);
					json.put("data" , "导出失败");
				}
		}
		return json.toJSONString();
	}
	@ResponseBody
	@RequestMapping(value="/CQEveryCityStoreExcel",produces="html/text;charset=UTF-8")
	public String CQEveryCityStoreExcel(Model model) {
		JSONObject json = new JSONObject();
		String platName=request.getParameter("platName");
		Date date = new Date();  
	        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");   
	        String fileName =platName+sdf.format(date);  
	        //得到桌面路径  
	        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();  
	        String desktopPath = desktopDir.getAbsolutePath();  
	        String desktopDirPath = desktopPath.replace("\\","\\\\");  
	        String filePath = desktopDirPath + "\\\\" +fileName + ".xls";  
	        String[] titles = {"区县","数量"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
			HashMap map=new HashMap();
			String size1=request.getParameter("_size");
			String index1=request.getParameter("_index");
			Integer size=Integer.parseInt(size1);
			Integer index=Integer.parseInt(index1);
			map.put("size", size);
			map.put("offset", index);
			List<Map<String, Object>> originDataReportList=reportService.CQEveryCityStoreData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
						String valueStr=oneMap.get(keyStr).toString();
						paramsLists.put(num, valueStr);
					    num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("data" , "导出失败");
				}
		}else{
			HashMap map=new HashMap();
			Integer size=null;
			Integer index=null;
			map.put("size", size);
			map.put("offset", index);
			List<Map<String, Object>> originDataReportList=reportService.CQEveryCityStoreData(map);
			List<Map<Integer, String>> lists = new ArrayList<Map<Integer,String>>();  
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=oneMap.get(keyStr).toString();
					paramsLists.put(num, valueStr);
					num++;
				}
				lists.add(paramsLists);
				
			}
				try {
					writeExcel(filePath, titles, lists);
					json.put("success" , true);
					json.put("data" , "导出成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					json.put("success" ,false);
					json.put("data" , "导出失败");
				}
		}
		return json.toJSONString();
	}
	//Excel的工具方法
	/** 
     * @info 写出Excel标题内容 
     * @param fos 
     * @return 
     */  
    public static void writeExcel(String filePath, String[] titles,  
            List<Map<Integer, String>> lists) throws IOException {  
        OutputStream fos = new FileOutputStream(filePath);  
        HSSFWorkbook xls = new HSSFWorkbook();  
        HSSFSheet sheet = xls.createSheet();  
        HSSFRow row = sheet.createRow(0);// 第一行  
  
        for (int i = 0; i < titles.length; i++) {  
            row.createCell((short) i).setCellValue(titles[i]);  
        }  
        // 内容  
        int rowNum = 1;  
        for (Map<Integer, String> map : lists) {  
            HSSFRow rowTmp = sheet.createRow(rowNum);  
            int cols = map.size();  
            for (int i = 0; i < cols; i++) {  
                rowTmp.createCell((short) i).setCellValue(map.get(i));  
            }  
            rowNum++;  
        }  
        xls.write(fos);  
        fos.close();  
    }  
	
}

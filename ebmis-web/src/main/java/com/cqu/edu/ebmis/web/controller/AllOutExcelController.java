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
	        String[] titles = {"平台","销量","店铺编号","链接","公司","名称","店铺实际ID","SKU","销售额"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
			HashMap map=new HashMap();
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
	        String[] titles = {"月销量","商品编号","店铺编号","店铺所在地","店铺名称","关键词","链接","商品实际编号","平台","销售额"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
			HashMap map=new HashMap();
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
	        String[] titles = {"月销量","商品编号","店铺编号","店铺所在地","店铺名称","关键词","链接","商品实际编号","平台","销售额"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
			HashMap map=new HashMap();
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
	        String[] titles = {"数量","时间","平台"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
			HashMap map=new HashMap();
			String size1=request.getParameter("_size");
			String index1=request.getParameter("_index");
			String productYear=request.getParameter("ExcelYear");
			if(productYear.equals("请选择")){
				productYear=null;
			}
			String productMonth=request.getParameter("ExcelMonth");
			if(productMonth.equals("请选择")){
				productMonth=null;
			}
			String productDay=request.getParameter("ExcelDay");
			if(productDay.equals("请选择")){
				productDay=null;		
			}
			map.put("productYear", productYear);
			map.put("productMonth", productMonth);
			map.put("productDay", productDay);
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
			if(productYear.equals("请选择")){
				productYear=null;
			}
			String productMonth=request.getParameter("ExcelMonth");
			if(productMonth.equals("请选择")){
				productMonth=null;
			}
			String productDay=request.getParameter("ExcelDay");
			if(productDay.equals("请选择")){
				productDay=null;		
			}
			map.put("productYear", productYear);
			map.put("productMonth", productMonth);
			map.put("productDay", productDay);
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
	        String[] titles = {"数量","平台"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
			HashMap map=new HashMap();
			String size1=request.getParameter("_size");
			String index1=request.getParameter("_index");
			Integer size=Integer.parseInt(size1);
			Integer index=Integer.parseInt(index1);
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
	        String[] titles = {"数量","平台"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
			HashMap map=new HashMap();
			String size1=request.getParameter("_size");
			String index1=request.getParameter("_index");
			Integer size=Integer.parseInt(size1);
			Integer index=Integer.parseInt(index1);
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
	        String[] titles = {"销售额","SKU","销量","一级"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
			HashMap map=new HashMap();
			String size1=request.getParameter("_size");
			String index1=request.getParameter("_index");
			Integer size=Integer.parseInt(size1);
			Integer index=Integer.parseInt(index1);
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
	        String[] titles = {"商品数量","销售额","销量","一级"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
			HashMap map=new HashMap();
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
	        String[] titles = {"商品数量","销售额","销量","一级"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
			HashMap map=new HashMap();
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
	        String[] titles = {"销售额","省份","销量"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
			HashMap map=new HashMap();
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
	        String[] titles = {"省份","店铺数量"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
			HashMap map=new HashMap();
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
	        String[] titles = {"城市","店铺编号","掌柜","省份","公司名称","店铺名称"};
		String excelValue=request.getParameter("ExcelValue");
		if(excelValue.equals("1")){
			HashMap map=new HashMap();
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

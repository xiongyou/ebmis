/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.controller;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.filechooser.FileSystemView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqu.edu.ebmis.service.ReportService;

@Controller
@RequestMapping("/outExcel")
public class AllOutExcelController extends SuperController {
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
	@ResponseBody
	@RequestMapping("/AliClassifyExcel")
	public String AliClassifyReport(Model model) {
		String platName=request.getParameter("platName");
		 Date date = new Date();  
	        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");   
	        String fileName =platName+sdf.format(date);  
	        //得到桌面路径  
	        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();  
	        String desktopPath = desktopDir.getAbsolutePath();  
	        String desktopDirPath = desktopPath.replace("\\","\\\\");  
	        String filePath = desktopDirPath + "\\\\" +fileName + ".xls";  
	        System.out.println(filePath);
	        String[] titles = {"平台","一级","销售额","销量","SKU"};
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
			String str="{";
			for(Map<String, Object> oneMap:originDataReportList){
				int num=0;
				Set<String> setstr=oneMap.keySet();
				Map<Integer, String> paramsLists = new HashMap<Integer, String>();
				for(String keyStr:setstr){
					String valueStr=(String)oneMap.get(keyStr);
					paramsLists.put(num, valueStr);
					num++;
					lists.add(paramsLists);
				}
				
			}
			/*ExcelUtil.writeExcel(filePath, titles, lists);*/
		}else{
			
		}
		return excelValue;
		
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
	@RequestMapping("/AllProductNumList")
	public String AllProductNumList(Model model) {
		return "/allReport/AllProductNumList";
	}
	@ResponseBody
	@RequestMapping("/AllProductNumReport")
	public String AllProductNumReport(Model model) {
		HashMap map=new HashMap();
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> originDataReportList=reportService.allProductNumData(map);
		int allCount=reportService.allProductNumCount();
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
		System.out.println(str);
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
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> originDataReportList=reportService.CQFarmProductNumData(map);
		int allCount=reportService.CQFarmProductNumCount();
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
		System.out.println(str);
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
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> originDataReportList=reportService.PlatformStoreNumData(map);
		int allCount=reportService.PlatformStoreNumCount();
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
		System.out.println(str);
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
		System.out.println(str);
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
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> originDataReportList=reportService.OneClassifyData(map);
		int allCount=reportService.OneClassifyCount();
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
		System.out.println(str);
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
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> originDataReportList=reportService.FreshClassifyData(map);
		int allCount=reportService.FreshClassifyCount();
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
		System.out.println(str);
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
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> originDataReportList=reportService.NoFreshClassifyData(map);
		int allCount=reportService.NoFreshClassifyCount();
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
		System.out.println(str);
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
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> originDataReportList=reportService.CQFarmProductEveryMarketData(map);
		int allCount=reportService.CQFarmProductEveryMarketCount();
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
		System.out.println(str);
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
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> originDataReportList=reportService.CQFarmProductEveryStoreData(map);
		int allCount=reportService.CQFarmProductEveryStoreCount();
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
		System.out.println(str);
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
		String size1=request.getParameter("_size");
		String index1=request.getParameter("_index");
		Integer size=Integer.parseInt(size1);
		Integer index=Integer.parseInt(index1);
		map.put("size", size);
		map.put("offset", index);
		List<Map<String, Object>> originDataReportList=reportService.MarketCQFarmProductStoreData(map);
		int allCount=reportService.MarketCQFarmProductStoreCount();
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
		System.out.println(str);
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
		System.out.println(str);
		return str;
	}
	//Excel的工具方法
	/*public static byte[] writeExcel(String[] titles,  
        List<Map<Integer, String>> lists) throws IOException {  
        HSSFWorkbook xls = new HSSFWorkbook();  
        HSSFSheet sheet = xls.createSheet();  
        HSSFRow row = sheet.createRow(0);// 第一行  
  
        for (int i = 0; i < titles.length; i++) {  
            row.createCell(i).setCellValue(titles[i]);  
        }  
        // 内容  
        int rowNum = 1;  
        for (Map<Integer, String> map : lists) {  
            HSSFRow rowTmp = sheet.createRow(rowNum);  
            int cols = map.size();  
            for (int i = 0; i < cols; i++) {  
                rowTmp.createCell(i).setCellValue(map.get(i));  
            }  
            rowNum++;  
        }  
        ByteArrayOutputStream fos = new ByteArrayOutputStream();  
        xls.write(fos);  
        byte[] buf = fos.toByteArray();// 获取内存缓冲区中的数据  
        fos.close();  
        return buf;  
    }*/
	
}

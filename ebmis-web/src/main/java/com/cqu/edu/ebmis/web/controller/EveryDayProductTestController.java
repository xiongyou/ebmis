/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cqu.edu.ebmis.domain.CategoryLogDO;
import com.cqu.edu.ebmis.domain.EveryDayProductDO;
import com.cqu.edu.ebmis.service.CategoryLogService;
import com.cqu.edu.ebmis.service.EveryDayProductService;
import com.cqu.edu.ebmis.service.page.Page;
import com.cqu.edu.ebmis.service.vo.User;

@Controller
@RequestMapping("/everyDayProductTest")
public class EveryDayProductTestController extends SuperController {
	
	@Autowired
	private EveryDayProductService	everyDayProductService;
	private ArrayList<String> filelist = new ArrayList<String>();
	@RequestMapping("/insert")
	public void insert(Model model) {
		String filePath = "C:\\Users\\Administrator\\Desktop\\everydaydate";
	    getFiles(filePath);
	}
	
	 
	/*  通过递归得到某一路径下所有的目录及其文件*/
	  
	void getFiles(String filePath){
	  File root = new File(filePath);
	    File[] files = root.listFiles();
	    for(File file:files){     
	     if(file.isDirectory()){
	      getFiles(file.getAbsolutePath());
	      filelist.add(file.getAbsolutePath());
	     }else if(file.getAbsolutePath().indexOf("err.txt")==-1){
	      StringBuilder result = new StringBuilder();
	      File file1=new File(file.getAbsolutePath());
	        try{
	            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
	            String str = null;
	            while((str = br.readLine())!=null){//使用readLine方法，一次读一行
	            	EveryDayProductDO everyDayProductDO=new EveryDayProductDO();
	            	String[] strList=str.split("\\s+");
	            	System.out.println(strList.length);
	            	if(strList.length==12){
	            		String extracttime1=strList[10]+" "+strList[11];
	            		String productPrice=strList[3]+strList[4]+strList[5];
	            		Date extracttime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(extracttime1);
	            		everyDayProductDO.setKeyWord(strList[1]);
	            		everyDayProductDO.setProductActualId(strList[2]);
	            		everyDayProductDO.setProductPrice(productPrice);
	            		everyDayProductDO.setProductPromPrice(strList[6]);
	            		everyDayProductDO.setMonthsalecount(strList[7]);
	            		everyDayProductDO.setCommentcount(strList[8]);
	            		everyDayProductDO.setProducturl(strList[9]);
	            		everyDayProductDO.setExtracttime(extracttime);
	            	}else if(strList.length==11){
	            		String extracttime1=strList[9]+" "+strList[10];
	            		String productPrice=strList[3]+strList[4]+strList[5];
	            		Date extracttime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(extracttime1);
	            		everyDayProductDO.setKeyWord(strList[1]);
	            		everyDayProductDO.setProductActualId(strList[2]);
	            		everyDayProductDO.setProductPrice(productPrice);
	            		everyDayProductDO.setMonthsalecount(strList[6]);
	            		everyDayProductDO.setCommentcount(strList[7]);
	            		everyDayProductDO.setProducturl(strList[8]);
	            		everyDayProductDO.setExtracttime(extracttime);
	            	}else if(strList.length==10){
            			String extracttime1=strList[8]+" "+strList[9];
            			Date extracttime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(extracttime1);
            			everyDayProductDO.setKeyWord(strList[1]);
            			everyDayProductDO.setProductActualId(strList[2]);
            			everyDayProductDO.setProductPrice(strList[3]);
            			everyDayProductDO.setProductPromPrice(strList[4]);
            			everyDayProductDO.setMonthsalecount(strList[5]);
            			everyDayProductDO.setCommentcount(strList[6]);
            			everyDayProductDO.setProducturl(strList[7]);
            			everyDayProductDO.setExtracttime(extracttime);
	            	}else if(strList.length==9){
            			String extracttime1=strList[7]+" "+strList[8];
            			Date extracttime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(extracttime1);
            			everyDayProductDO.setKeyWord(strList[1]);
            			everyDayProductDO.setProductActualId(strList[2]);
            			everyDayProductDO.setProductPrice(strList[3]);
            			everyDayProductDO.setMonthsalecount(strList[4]);
            			everyDayProductDO.setCommentcount(strList[5]);
            			everyDayProductDO.setProducturl(strList[6]);
            			everyDayProductDO.setExtracttime(extracttime);
	            	}else if(strList.length==8){
            			String extracttime1=strList[6]+" "+strList[7];
            			Date extracttime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(extracttime1);
            			everyDayProductDO.setKeyWord(strList[1]);
            			everyDayProductDO.setProductActualId(strList[2]);
            			everyDayProductDO.setProductPrice(strList[3]);
            			everyDayProductDO.setCommentcount(strList[4]);
            			everyDayProductDO.setProducturl(strList[5]);
            			everyDayProductDO.setExtracttime(extracttime);
	            	}
	            	everyDayProductService.insert(everyDayProductDO);
	            	
	            }
	            br.close();    
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	     }     
	    }
	 }	 
}

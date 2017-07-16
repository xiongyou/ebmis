package com.cqu.edu.ebmis.service.convert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import com.cqu.edu.ebmis.domain.FileInfo;

/**
 * 读取文件，并将里面的行转换成一条条的任务
 * @author xiongyou1701
 *
 */
public class FileOperation {

	public List<FileInfo> readFile(String filepath){
		List<FileInfo>  fileInfos = null;
		File file = new File(filepath);
	    BufferedReader reader = null;
	    InputStreamReader input = null;
	    try{
	    	fileInfos = new ArrayList<FileInfo>();
	    	input = new InputStreamReader(new FileInputStream(file),"utf-8");
	    	reader = new BufferedReader(input);
	    	String tmp = null;
	    	while((tmp=reader.readLine())!=null){
	    		
	    		String[] info = tmp.split("\t");
	    		//System.out.println("当前info的大小为："+info.length);
	    		FileInfo fileInfo = new FileInfo();
	    		if(info.length<3){
	    			fileInfo.setUrl(info[0]);
		    		fileInfo.setWebsite(info[1]);
	    		}else {
	    			fileInfo.setUrl(info[0]);
		    		fileInfo.setWebsite(info[1]);
		    		fileInfo.setKeyword(info[2]);
				}
	    		
	    		fileInfos.add(fileInfo);
	    	}
	    	reader.close();
	    	return fileInfos;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    return fileInfos;
	}
}

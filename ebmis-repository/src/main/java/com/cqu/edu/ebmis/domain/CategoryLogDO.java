/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author mxl
 * @version $ CategoryDO.java v1.0, 2017年5月5日 上午10:50:06 mxl Exp $
 */
public class CategoryLogDO {
	
	private int logId;
	private String userId;
	private String userName;
	private String content;
	private Date logTime;
	private String logTime1;
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getLogTime() {
		return logTime;
	}
	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}
	public String getLogTime1() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.logTime);
	}
	
}

package com.cqu.edu.ebmis.domain;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class ProjectDO {

	private Integer projectID;

	private Integer ExecutePeriod;
	
	private String objName;
	
	private String startTime1;
	
	private Date startTime;
	
	private String endedTime1;
	
	private Date endedTime;
	
	private String keyWord;
	
	private double price;
	
	private String projectDescription;
	
	private String projectName;

	private Integer maxExecutingTime;

	public Integer getProjectID() {
		return projectID;
	}

	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}

	public Integer getExecutePeriod() {
		return ExecutePeriod;
	}

	public void setExecutePeriod(Integer executePeriod) {
		ExecutePeriod = executePeriod;
	}

	public String getObjName() {
		return objName;
	}

	public void setObjName(String objName) {
		this.objName = objName;
	}

	public String getStartTime1() {
		return startTime1;
	}

	public void setStartTime1(String startTime1) {
		this.startTime1 = startTime1;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getEndedTime1() {
		return endedTime1;
	}

	public void setEndedTime1(String endedTime1) {
		this.endedTime1 = endedTime1;
	}

	public Date getEndedTime() {
		
		return endedTime;
	}

	public void setEndedTime(Date endedTime) {
		this.endedTime = endedTime;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getMaxExecutingTime() {
		return maxExecutingTime;
	}

	public void setMaxExecutingTime(Integer maxExecutingTime) {
		this.maxExecutingTime = maxExecutingTime;
	}

	
}

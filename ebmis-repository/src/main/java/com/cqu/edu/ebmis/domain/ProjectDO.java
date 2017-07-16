package com.cqu.edu.ebmis.domain;
import java.util.Date;



public class ProjectDO {

	private int projectID;

	private int ExecutePeriod;
	
	private String objName;
	
	private Date startTime;
	
	private Date endedTime;
	
	private String keyWord;
	
	private double price;
	
	private String projectDescription;
	
	private String projectName;

	private int maxExecutingTime;
	
	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndedTime() {
		return endedTime;
	}

	public void setEndedTime(Date endedTime) {
		this.endedTime = endedTime;
	}

	public int getMaxExecutingTime() {
		return maxExecutingTime;
	}

	public void setMaxExecutingTime(int maxExecutingTime) {
		this.maxExecutingTime = maxExecutingTime;
	}

	public int getExecutePeriod() {
		return ExecutePeriod;
	}

	public void setExecutePeriod(int executePeriod) {
		ExecutePeriod = executePeriod;
	}

	public String getObjName() {
		return objName;
	}

	public void setObjName(String objName) {
		this.objName = objName;
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
	

	
}

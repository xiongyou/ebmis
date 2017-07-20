package com.cqu.edu.ebmis.domain;
import java.util.Date;
public class TaskInfoDO {

	private Integer taskInfoID;
	
	private Integer status;
	
	private Integer projectID;
	
	private String clientID;
	
	private Date distributedTime;
	
	private Date finishedTime;
	
	private String distributedTime1;
	
	private String finishedTime1;
	
	private Integer projectExcitedPeriod;
	
	private Integer projectTaskID;
	
	private Integer awaitTaskNumber;
	
	private Integer executedTaskNumber;
	
	private Integer executingTaskNumber;
	
	private Integer allExecutTaskNum;
	public Integer getTaskInfoID() {
		return taskInfoID;
	}

	public void setTaskInfoID(Integer taskInfoID) {
		this.taskInfoID = taskInfoID;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	public Integer getProjectID() {
		return projectID;
	}

	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public Date getDistributedTime() {
		return distributedTime;
	}

	public void setDistributedTime(Date distributedTime) {
		this.distributedTime = distributedTime;
	}

	public Date getFinishedTime() {
		return finishedTime;
	}

	public void setFinishedTime(Date finishedTime) {
		this.finishedTime = finishedTime;
	}

	public Integer getProjectTaskID() {
		return projectTaskID;
	}

	public void setProjectTaskID(Integer projectTaskID) {
		this.projectTaskID = projectTaskID;
	}

	public Integer getAwaitTaskNumber() {
		return awaitTaskNumber;
	}

	public void setAwaitTaskNumber(Integer awaitTaskNumber) {
		this.awaitTaskNumber = awaitTaskNumber;
	}

	public Integer getExecutedTaskNumber() {
		return executedTaskNumber;
	}

	public void setExecutedTaskNumber(Integer executedTaskNumber) {
		this.executedTaskNumber = executedTaskNumber;
	}

	public Integer getExecutingTaskNumber() {
		return executingTaskNumber;
	}

	public void setExecutingTaskNumber(Integer executingTaskNumber) {
		this.executingTaskNumber = executingTaskNumber;
	}

	public Integer getAllExecutTaskNum() {
		return allExecutTaskNum;
	}

	public void setAllExecutTaskNum(Integer allExecutTaskNum) {
		this.allExecutTaskNum = allExecutTaskNum;
	}

	public Integer getProjectExcitedPeriod() {
		return projectExcitedPeriod;
	}

	public void setProjectExcitedPeriod(Integer projectExcitedPeriod) {
		this.projectExcitedPeriod = projectExcitedPeriod;
	}

	public String getDistributedTime1() {
		return distributedTime1;
	}

	public void setDistributedTime1(String distributedTime1) {
		this.distributedTime1 = distributedTime1;
	}

	public String getFinishedTime1() {
		return finishedTime1;
	}

	public void setFinishedTime1(String finishedTime1) {
		this.finishedTime1 = finishedTime1;
	}
	
	
}

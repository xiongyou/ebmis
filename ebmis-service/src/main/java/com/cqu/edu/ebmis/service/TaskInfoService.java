package com.cqu.edu.ebmis.service;

import java.util.Date;

import com.cqu.edu.ebmis.domain.TaskInfoDO;

/**
 * 
 * @author Administrator
 *
 */
public interface TaskInfoService {
	/**
	 * 查询待执行任务数
	 * @param projectID
	 * @return
	 */
	int findAwaitTaskNum(TaskInfoDO taskIfoDO);
	/**
	 * 查询已执行任务数
	 * @param projectID
	 * @return
	 */
	int findExecutedTaskNum(TaskInfoDO taskIfoDO);
	/**
	 * 查询正在执行任务数
	 * @param projectID
	 * @return
	 */
	int findExecutingTaskNum(TaskInfoDO taskIfoDO);
	/**
	 * 默认查询待执行任务数
	 * @param projectID
	 * @return
	 */
	int findDefultAwaitTaskNum(TaskInfoDO taskIfoDO);
	/**
	 * 默认查询已执行任务数
	 * @param projectID
	 * @return
	 */
	int findDefultExecutedTaskNum(TaskInfoDO taskIfoDO);
	/**
	 * 默认查询正在执行任务数
	 * @param projectID
	 * @return
	 */
	int findDefultExecutingTaskNum(TaskInfoDO taskIfoDO);
	/**
	 * 查询总执行任务数
	 * @param projectID
	 * @return
	 */
	int findAllExecutTaskNum(TaskInfoDO taskIfoDO);
	/**
	 * 默认查询总执行任务数
	 * @param projectID
	 * @return
	 */
	int findDefultAllExecutTaskNum(TaskInfoDO taskIfoDO);
	/**
	 * 查询项目的执行周期
	 * @param projectID
	 * @return
	 */
	int findProjectExecutPeriod(Integer projectID);	
}

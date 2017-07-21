package com.cqu.edu.ebmis.repository;

import java.util.Date;
import java.util.List;

import com.cqu.edu.ebmis.domain.TaskInfoDO;

public interface TaskInfoRepository {

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
	/**
	 * 默认查询项目的每人完成任务的数量
	 * @param projectID
	 * @return
	 */
	List<TaskInfoDO> findDefultUserTaskNum(TaskInfoDO taskIfoDO);
	/**
	 * 查询项目的每人完成任务的数量
	 * @param projectID
	 * @return
	 */
	List<TaskInfoDO> findUserTaskNum(TaskInfoDO taskIfoDO);
	/**
	 * 默认查询总项目待执行任务数
	 * @param projectID
	 * @return
	 */
	int findDefultAllAwaitTaskNum();
	/**
	 * 默认查询总项目已执行任务数
	 * @param projectID
	 * @return
	 */
	int findDefultAllExecutedTaskNum();
	/**
	 * 默认查询总项目正在执行任务数
	 * @param projectID
	 * @return
	 */
	int findDefultAllExecutingTaskNum();
	/**
	 * 默认查询总项目总执行任务数
	 * @param projectID
	 * @return
	 */
	int findDefultAllProjectExecutTaskNum();
	/**
	 * 默认查询总项目的每人完成任务的数量
	 * @param projectID
	 * @return
	 */
	List<TaskInfoDO> findDefultAllUserTaskNum();
	/**
	 * 查询总项目待执行任务数
	 * @param projectID
	 * @return
	 */
	int findAllAwaitTaskNum(TaskInfoDO taskIfoDO);
	/**
	 * 查询总项目已执行任务数
	 * @param projectID
	 * @return
	 */
	int findAllExecutedTaskNum(TaskInfoDO taskIfoDO);
	/**
	 * 查询总项目正在执行任务数
	 * @param projectID
	 * @return
	 */
	int findAllExecutingTaskNum(TaskInfoDO taskIfoDO);
	/**
	 * 查询总项目总执行任务数
	 * @param projectID
	 * @return
	 */
	int findAllProjectExecutTaskNum(TaskInfoDO taskIfoDO);
	/**
	 * 查询总项目的每人完成任务的数量
	 * @param projectID
	 * @return
	 */
	List<TaskInfoDO> findAllUserTaskNum(TaskInfoDO taskIfoDO);
	
	
}

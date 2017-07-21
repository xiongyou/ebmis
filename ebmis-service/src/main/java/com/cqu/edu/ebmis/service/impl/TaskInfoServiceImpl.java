package com.cqu.edu.ebmis.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqu.edu.ebmis.domain.TaskInfoDO;
import com.cqu.edu.ebmis.repository.TaskInfoRepository;
import com.cqu.edu.ebmis.service.TaskInfoService;

@Service
public class TaskInfoServiceImpl implements TaskInfoService {
	@Resource
	private TaskInfoRepository taskInfoRepository;

	public int findAwaitTaskNum(TaskInfoDO taskIfoDO) {
		// TODO Auto-generated method stub
		return taskInfoRepository.findAwaitTaskNum(taskIfoDO);
	}

	public int findExecutedTaskNum(TaskInfoDO taskIfoDO) {
		// TODO Auto-generated method stub
		return taskInfoRepository.findExecutedTaskNum(taskIfoDO);
	}

	public int findExecutingTaskNum(TaskInfoDO taskIfoDO) {
		// TODO Auto-generated method stub
		return taskInfoRepository.findExecutingTaskNum(taskIfoDO);
	}

	public int findDefultAwaitTaskNum(TaskInfoDO taskIfoDO) {
		// TODO Auto-generated method stub
		return taskInfoRepository.findDefultAwaitTaskNum(taskIfoDO);
	}

	public int findDefultExecutedTaskNum(TaskInfoDO taskIfoDO) {
		// TODO Auto-generated method stub
		return taskInfoRepository.findDefultExecutedTaskNum(taskIfoDO);
	}

	public int findDefultExecutingTaskNum(TaskInfoDO taskIfoDO) {
		// TODO Auto-generated method stub
		return taskInfoRepository.findDefultExecutingTaskNum(taskIfoDO);
	}

	public int findAllExecutTaskNum(TaskInfoDO taskIfoDO) {
		// TODO Auto-generated method stub
		return taskInfoRepository.findAllExecutTaskNum(taskIfoDO);
	}

	public int findDefultAllExecutTaskNum(TaskInfoDO taskIfoDO) {
		// TODO Auto-generated method stub
		return taskInfoRepository.findDefultAllExecutTaskNum(taskIfoDO);
	}

	public int findProjectExecutPeriod(Integer projectID) {
		// TODO Auto-generated method stub
		return taskInfoRepository.findProjectExecutPeriod(projectID);
	}

	public List<TaskInfoDO> findDefultUserTaskNum(TaskInfoDO taskIfoDO) {
		// TODO Auto-generated method stub
		return taskInfoRepository.findDefultUserTaskNum(taskIfoDO);
	}

	public List<TaskInfoDO> findUserTaskNum(TaskInfoDO taskIfoDO) {
		// TODO Auto-generated method stub
		return taskInfoRepository.findUserTaskNum(taskIfoDO);
	}

	public int findDefultAllAwaitTaskNum() {
		// TODO Auto-generated method stub
		return taskInfoRepository.findDefultAllAwaitTaskNum();
	}

	public int findDefultAllExecutedTaskNum() {
		// TODO Auto-generated method stub
		return taskInfoRepository.findDefultAllExecutedTaskNum();
	}

	public int findDefultAllExecutingTaskNum() {
		// TODO Auto-generated method stub
		return taskInfoRepository.findDefultAllExecutingTaskNum();
	}

	public int findDefultAllProjectExecutTaskNum() {
		// TODO Auto-generated method stub
		return taskInfoRepository.findDefultAllProjectExecutTaskNum();
	}

	public List<TaskInfoDO> findDefultAllUserTaskNum() {
		// TODO Auto-generated method stub
		return taskInfoRepository.findDefultAllUserTaskNum();
	}

	public int findAllAwaitTaskNum(TaskInfoDO taskIfoDO) {
		// TODO Auto-generated method stub
		return taskInfoRepository.findAllAwaitTaskNum(taskIfoDO);
	}

	public int findAllExecutedTaskNum(TaskInfoDO taskIfoDO) {
		// TODO Auto-generated method stub
		return taskInfoRepository.findAllExecutedTaskNum(taskIfoDO);
	}

	public int findAllExecutingTaskNum(TaskInfoDO taskIfoDO) {
		// TODO Auto-generated method stub
		return taskInfoRepository.findAllExecutingTaskNum(taskIfoDO);
	}

	public int findAllProjectExecutTaskNum(TaskInfoDO taskIfoDO) {
		// TODO Auto-generated method stub
		return taskInfoRepository.findAllProjectExecutTaskNum(taskIfoDO);
	}

	public List<TaskInfoDO> findAllUserTaskNum(TaskInfoDO taskIfoDO) {
		// TODO Auto-generated method stub
		return taskInfoRepository.findAllUserTaskNum(taskIfoDO);
	}



}

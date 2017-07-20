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



}

package com.cqu.edu.ebmis.repository.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.cqu.edu.ebmis.domain.TaskInfoDO;
import com.cqu.edu.ebmis.mapper.TaskInfoMapper;
import com.cqu.edu.ebmis.repository.TaskInfoRepository;

@Repository
public class TaskInfoRepositoryImpl  implements TaskInfoRepository {
	@Resource
	private TaskInfoMapper taskInfoMapper;

	@Override
	public int findAwaitTaskNum(TaskInfoDO taskIfoDO) {
		// TODO Auto-generated method stub
		return taskInfoMapper.findAwaitTaskNum(taskIfoDO);
	}

	@Override
	public int findExecutedTaskNum(TaskInfoDO taskIfoDO) {
		// TODO Auto-generated method stub
		return taskInfoMapper.findExecutedTaskNum(taskIfoDO);
	}

	@Override
	public int findExecutingTaskNum(TaskInfoDO taskIfoDO) {
		// TODO Auto-generated method stub
		return taskInfoMapper.findExecutingTaskNum(taskIfoDO);
	}

	@Override
	public int findDefultAwaitTaskNum(TaskInfoDO taskIfoDO) {
		// TODO Auto-generated method stub
		return taskInfoMapper.findDefultAwaitTaskNum(taskIfoDO);
	}

	@Override
	public int findDefultExecutedTaskNum(TaskInfoDO taskIfoDO) {
		// TODO Auto-generated method stub
		return taskInfoMapper.findDefultExecutedTaskNum(taskIfoDO);
	}

	@Override
	public int findDefultExecutingTaskNum(TaskInfoDO taskIfoDO) {
		// TODO Auto-generated method stub
		return taskInfoMapper.findDefultExecutingTaskNum(taskIfoDO);
	}

	@Override
	public int findAllExecutTaskNum(TaskInfoDO taskIfoDO) {
		// TODO Auto-generated method stub
		return taskInfoMapper.findAllExecutTaskNum(taskIfoDO);
	}

	@Override
	public int findDefultAllExecutTaskNum(TaskInfoDO taskIfoDO) {
		// TODO Auto-generated method stub
		return taskInfoMapper.findDefultAllExecutTaskNum(taskIfoDO);
	}

	@Override
	public int findProjectExecutPeriod(Integer projectID) {
		// TODO Auto-generated method stub
		return taskInfoMapper.findProjectExecutPeriod(projectID);
	}

	
	

	
}

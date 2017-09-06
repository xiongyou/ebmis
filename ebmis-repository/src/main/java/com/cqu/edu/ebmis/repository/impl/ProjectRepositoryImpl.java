/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.repository.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.cqu.edu.ebmis.domain.ProjectDO;
import com.cqu.edu.ebmis.mapper.ProjectMapper;
import com.cqu.edu.ebmis.repository.ProjectRepository;

/**
 * 项目管理仓储实现
 * 
 * @author mxl
 * @version $ CategoryRepositoryImpl.java v1.0, 2017年5月5日 上午11:05:44 mxl Exp $
 */
@Repository
public class ProjectRepositoryImpl implements ProjectRepository {
	
	@Resource
	private ProjectMapper	projectMapper;

	@Override
	public int insertProject(ProjectDO project) {
		return projectMapper.insertProject(project);
	}

	@Override
	public List<ProjectDO> findAllProject() {
		return projectMapper.findAllProject();
	}

	@Override
	public ProjectDO findProjectById(int projectID) {
		return projectMapper.findProjectById(projectID);
	}

	@Override
	public List<ProjectDO> findProjectByName(String projectName) {
		return projectMapper.findProjectByName(projectName);
	}

	@Override
	public void updateProject(ProjectDO project) {
		projectMapper.updateProject(project);
	}

	@Override
	public int deleteProject(int projectId) {
		return projectMapper.deleteProject(projectId);
	}

	@Override
	public List<ProjectDO> selectByPage(int offset, int size) {
		return projectMapper.selectByPage(offset, size);
	}

	@Override
	public int selectAllCount() {
		return projectMapper.selectAllCount();
	}

	@Override
	public List<ProjectDO> selectByPageField(int size, int offset, String field) {
		// TODO Auto-generated method stub
		return projectMapper.selectByPageField(size, offset, field);
	}

	@Override
	public int selectAllCountField(String field) {
		// TODO Auto-generated method stub
		return projectMapper.selectAllCountField(field);
	}

	@Override
	public int deleteProjectTask(int projectId) {
		// TODO Auto-generated method stub
		return projectMapper.deleteProjectTask(projectId);
	}
	
	
	
}

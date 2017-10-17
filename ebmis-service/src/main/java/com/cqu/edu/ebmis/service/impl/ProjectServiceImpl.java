package com.cqu.edu.ebmis.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqu.edu.ebmis.domain.ProjectDO;
import com.cqu.edu.ebmis.repository.ProjectRepository;
import com.cqu.edu.ebmis.service.ProjectService;
import com.cqu.edu.ebmis.service.page.Page;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Resource
	private ProjectRepository	projectRepository;
	public int save(ProjectDO project) {
		// TODO Auto-generated method stub
		return projectRepository.insertProject(project);
	}

	public int delete(int code) {
		return projectRepository.deleteProject(code);
	}

	public void  update(ProjectDO project) {
		 projectRepository.updateProject(project);
	}

	public boolean isExist(ProjectDO project) {
		if(project==null){
			return false;
		}
		if(projectRepository.findProjectById(project.getProjectID())!=null){
			return true;
		}
		
		return false;
	}

	public ProjectDO findById(int projectId){
		return projectRepository.findProjectById(projectId);
	}
	public List<ProjectDO> findByName(String name) {
		return projectRepository.findProjectByName(name);
	}

	public List<ProjectDO> findAll() {
		return projectRepository.findAllProject();
	}

	public Page<ProjectDO> findByPage(Page<ProjectDO> page) {
		List<ProjectDO> projects = projectRepository.selectByPage(
				page.getLimit() , page.getOffset());
		page.setTotal(projectRepository.selectAllCount());
		
		page.setRecords(projects);
		return page;
	}

	public Page<ProjectDO> findByPageField(Page<ProjectDO> page, String field) {
		List<ProjectDO> projects = projectRepository.selectByPageField(
				page.getLimit() , page.getOffset(),field);
		page.setTotal(projectRepository.selectAllCountField(field));
		
		page.setRecords(projects);
		return page;
	}

	public int deleteProjectTask(int projectId) {
		// TODO Auto-generated method stub
		return projectRepository.deleteProjectTask(projectId);
	}

	public void updateProjectTaskPriority(ProjectDO project) {
		// TODO Auto-generated method stub
		projectRepository.updateProjectTaskPriority(project);
	}

	public void updateProjectTaskInfoPriority(ProjectDO project) {
		// TODO Auto-generated method stub
		projectRepository.updateProjectTaskInfoPriority(project);
	}


}

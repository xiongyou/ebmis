package com.cqu.edu.ebmis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cqu.edu.ebmis.domain.ProjectDO;

public interface ProjectRepository {
	/**插入项目
	 * @param project
	 * @return
	 * @throws Exception
	 */
	public int insertProject(ProjectDO project);
	
	
	/**查找所有的项目
	 * @return
	 */
	public List<ProjectDO> findAllProject();
	
	/**根据ProjectID查找(主键)
	 * @param projectID
	 * @return
	 */
	public ProjectDO findProjectById(int projectID);
	
	/**
	 * 根据项目名称查找
	 * 
	 * @param projectName
	 * @return
	 */
	public List<ProjectDO> findProjectByName(String projectName);
	
	/**模糊查找，通过项目名称或Id
	 * @param searchContent
	 * @return
	 */
	//public List<Project> findProjectVague(String searchContent);
	
	/**
	 * 判断项目是否存在
	 * 
	 * @param project
	 * @return
	 */
	//public boolean isExist(Project project) ;
	
	/**更新项目信息
	 * @param project
	 */
	public void updateProject(ProjectDO project);
	/**更新项目的任务里面项目优先级信息
	 * @param product
	 */
	public void updateProjectTaskPriority(ProjectDO project);
	/**更新任务信息表中项目优先级信息
	 * @param product
	 */
	public void updateProjectTaskInfoPriority(ProjectDO project);

	/**删除项目
	 * @param project
	 */
	public int deleteProject(int projectId);
	/**删除项目下所有的任务
	 * @param product
	 */
	public int deleteProjectTask(int projectId);
	
	/**
	 * 分页查找
	 * @param offset
	 * @param size
	 * @return
	 */
	public List<ProjectDO> selectByPage(int offset,int size);
	
	/**
	 * 所有的数量
	 * @return
	 */
	public int selectAllCount();
	/**分页字段查找
	 * @param searchContent
	 * @return
	 */
	public List<ProjectDO> selectByPageField(int size,
			int offset,String field);
	
	/**
	 * 该字段所有的数量
	 * @return
	 */
	public int selectAllCountField(String field); 
}

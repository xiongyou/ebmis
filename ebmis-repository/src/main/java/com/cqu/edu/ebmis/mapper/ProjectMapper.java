package com.cqu.edu.ebmis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cqu.edu.ebmis.domain.ProjectDO;

public interface ProjectMapper {

	/**插入项目
	 * @param product
	 * @return
	 * @throws Exception
	 */
	public int insertProject(ProjectDO project);
	
	
	/**查找所有的项目
	 * @return
	 */
	public List<ProjectDO> findAllProject();
	
	/**根据ProjectID查找(主键)
	 * @param productID
	 * @return
	 */
	public ProjectDO findProjectById(int projectID);
	
	/**
	 * 根据项目名称查找
	 * 
	 * @param productURL
	 * @return
	 */
	public List<ProjectDO> findProjectByName(String projectName);
	
	/**模糊查找，通过项目名称或Id
	 * @param searchContent
	 * @return
	 */
	//public List<Project> findProjectVague(String searchContent);
	
	/**
	 * 根据项目是否存在
	 * 
	 * @param product
	 * @return
	 */
	//public boolean isExist(Project project) ;
	
	/**更新项目信息
	 * @param product
	 */
	public void updateProject(ProjectDO project);

	/**删除项目
	 * @param product
	 */
	public int deleteProject(int projectId);
	
	/**分页查找
	 * @param searchContent
	 * @return
	 */
	public List<ProjectDO> selectByPage(@Param("size") int size,
			@Param("offset") int offset);
	
	/**
	 * 所有的数量
	 * @return
	 */
	public int selectAllCount();
	/**分页字段查找
	 * @param searchContent
	 * @return
	 */
	public List<ProjectDO> selectByPageField(@Param("size") int size,
			@Param("offset") int offset,@Param("field") String field);
	
	/**
	 * 该字段所有的数量
	 * @return
	 */
	public int selectAllCountField(@Param("field") String field);
}

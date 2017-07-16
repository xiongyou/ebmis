package com.cqu.edu.ebmis.service;

import java.util.List;

import com.cqu.edu.ebmis.domain.ProjectDO;
import com.cqu.edu.ebmis.service.page.Page;
/**
 * 项目管理服务
 * 
 * @author mxl
 * @version $ CategoryService.java v1.0, 2017年5月5日 上午11:31:27 mxl Exp $
 */
public interface ProjectService {
	/**
	 * 存储操作
	 * 
	 * @param category
	 * @return
	 */
	int save(ProjectDO project);
	
	/**
	 * 删除操作
	 * 
	 * @param code
	 * @return
	 */
	int delete(int code);
	
	/**
	 * 更新操作
	 * 
	 * @param project
	 * @return
	 */
	void update(ProjectDO project);
	
	/**
	 * 判断项目是否存在
	 * 
	 * @param project
	 * @return
	 */
	 boolean isExist(ProjectDO project) ;
	
	/**
	 * 按照项目名称查找
	 * 
	 * @param name
	 * @return
	 */
	 List<ProjectDO> findByName(String name);
	
	
	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<ProjectDO> findAll();
	
	/**
	 * 分页查询
	 * 
	 * @param size
	 * @param offset
	 * @return
	 */
	Page<ProjectDO> findByPage(Page<ProjectDO> page);
	
}

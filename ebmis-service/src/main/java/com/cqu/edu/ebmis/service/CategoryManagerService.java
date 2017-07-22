/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.service;

import java.util.List;

import com.cqu.edu.ebmis.domain.CategoryDO;
import com.cqu.edu.ebmis.domain.CategoryManagerDO;
import com.cqu.edu.ebmis.service.page.Page;

/**
 * 类型树
 * 
 * @author mxl
 */
public interface CategoryManagerService {
	/**
	 * 添加类型节点
	 * @param categoryManager
	 */
	void save(CategoryManagerDO categoryManager);
	/**
	 * 修改类型节点
	 * @param categoryManager
	 */
	void update(CategoryManagerDO categoryManager);
	/**
	 * 删除类型节点
	 * @param categoryManager
	 */
	void del(int categoryId);
	/**
	 * 查询子级集合
	 * @param parentId
	 * @return
	 */
	List<CategoryManagerDO> getByParentId(int parentId);
}

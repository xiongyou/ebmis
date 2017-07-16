/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cqu.edu.ebmis.domain.CategoryDO;

/**
 * 三级分类仓储
 * 
 * @author mxl
 * @version $ CategoryRepository.java v1.0, 2017年5月5日 上午11:01:10 mxl Exp $
 */
public interface CategoryRepository {
	
	/**
	 * 插入
	 * 
	 * @param category
	 * @return
	 */
	int insert(CategoryDO category);
	
	/**
	 * 删除
	 * 
	 * @param code
	 * @return
	 */
	int deleteByPrimaryKey(String code);
	
	/**
	 * 按主键查找
	 * 
	 * @param code
	 * @return
	 */
	CategoryDO selectByPrimaryKey(String code);
	
	/**
	 * 按照关键字名称查找
	 * 
	 * @param name
	 * @return
	 */
	CategoryDO selectByName(@Param("name") String name);
	
	/**
	 * 更新记录
	 * 
	 * @param category
	 * @return
	 */
	CategoryDO update(CategoryDO category);
	
	/**
	 * 查找所有记录
	 * 
	 * @return
	 */
	List<CategoryDO> selectAllCategory();
	
	/**
	 * 按照节点级别查询
	 * 
	 * @param level
	 * @return
	 */
	List<CategoryDO> selectByParentCode(String parentCode);
	
	/**
	 * 查询分页
	 * 
	 * @param size
	 *            页大小
	 * @param offset
	 *            偏移量
	 * @return
	 */
	List<CategoryDO> selectByPage(int size, int offset);
	
	/**
	 * 
	 * @return
	 */
	int selectCount();
}

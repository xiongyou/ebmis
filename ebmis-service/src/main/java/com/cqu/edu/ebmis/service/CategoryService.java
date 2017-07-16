/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.service;

import java.util.List;

import com.cqu.edu.ebmis.domain.CategoryDO;
import com.cqu.edu.ebmis.service.page.Page;

/**
 * 三级分类处理服务
 * 
 * @author mxl
 * @version $ CategoryService.java v1.0, 2017年5月5日 上午11:31:27 mxl Exp $
 */
public interface CategoryService {
	
	/**
	 * 存储操作
	 * 
	 * @param category
	 * @return
	 */
	int save(CategoryDO category);
	
	/**
	 * 删除操作
	 * 
	 * @param code
	 * @return
	 */
	int delete(String code);
	
	/**
	 * 更新操作
	 * 
	 * @param category
	 * @return
	 */
	CategoryDO update(CategoryDO category);
	
	/**
	 * 按照关键字名称查找
	 * 
	 * @param name
	 * @return
	 */
	CategoryDO findByName(String name);
	
	/**
	 * 按照关键字编码查找
	 * 
	 * @param code
	 * @return
	 */
	CategoryDO findByCode(String code);
	
	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<CategoryDO> findAll();
	
	/**
	 * 按照父节点编码查询分类
	 * 
	 * @return
	 */
	List<CategoryDO> queryCategoryByParentCode(String parentCode);
	
	/**
	 * 按照父级编码构造编码
	 * 
	 * @param parentCode
	 * @return
	 */
	String constructCode(String parentCode);
	
	/**
	 * 分页查询
	 * 
	 * @param size
	 * @param offset
	 * @return
	 */
	Page<CategoryDO> findByPage(Page<CategoryDO> page);
}

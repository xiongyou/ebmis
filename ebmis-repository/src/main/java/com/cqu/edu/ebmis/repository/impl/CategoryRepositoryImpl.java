/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.repository.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.cqu.edu.ebmis.domain.CategoryDO;
import com.cqu.edu.ebmis.mapper.CategoryMapper;
import com.cqu.edu.ebmis.repository.CategoryRepository;

/**
 * 三级分类仓储实现
 * 
 * @author mxl
 * @version $ CategoryRepositoryImpl.java v1.0, 2017年5月5日 上午11:05:44 mxl Exp $
 */
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
	
	@Resource
	private CategoryMapper	categoryMapper;
	
	/**
	 * @see com.cqu.edu.ebmis.repository.CategoryRepository#insert(com.cqu.edu.ebmis.domain.CategoryDO)
	 */
	@Override
	public int insert(CategoryDO category) {
	
		return categoryMapper.insert(category);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.CategoryRepository#deleteByPrimaryKey(java.lang.String)
	 */
	@Override
	public int deleteByPrimaryKey(String code) {
	
		return categoryMapper.deleteByPrimaryKey(code);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.CategoryRepository#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public CategoryDO selectByPrimaryKey(String code) {
	
		return categoryMapper.selectByPrimaryKey(code);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.CategoryRepository#selectByName(java.lang.String)
	 */
	@Override
	public CategoryDO selectByName(String name) {
	
		return categoryMapper.selectByName(name);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.CategoryRepository#update(com.cqu.edu.ebmis.domain.CategoryDO)
	 */
	@Override
	public CategoryDO update(CategoryDO category) {
	
		return categoryMapper.update(category);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.CategoryRepository#selectAllCategory()
	 */
	@Override
	public List<CategoryDO> selectAllCategory() {
	
		return categoryMapper.selectAllCatetory();
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.CategoryRepository#selectByParentCode(java.lang.String)
	 */
	@Override
	public List<CategoryDO> selectByParentCode(String parentCode) {
	
		return categoryMapper.selectByParentCode(parentCode);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.CategoryRepository#selectByPage(int,
	 *      int)
	 */
	@Override
	public List<CategoryDO> selectByPage(int size, int offset) {
	
		return categoryMapper.selectByPage(size , offset);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.CategoryRepository#selectCount()
	 */
	@Override
	public int selectCount() {
	
		return categoryMapper.selectAllCount();
	}
	
}

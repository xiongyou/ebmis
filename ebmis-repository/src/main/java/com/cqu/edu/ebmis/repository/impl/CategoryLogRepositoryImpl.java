/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.repository.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.cqu.edu.ebmis.domain.CategoryDO;
import com.cqu.edu.ebmis.domain.CategoryLogDO;
import com.cqu.edu.ebmis.mapper.CategoryLogMapper;
import com.cqu.edu.ebmis.mapper.CategoryMapper;
import com.cqu.edu.ebmis.repository.CategoryLogRepository;
import com.cqu.edu.ebmis.repository.CategoryRepository;

/**
 * 三级分类仓储实现
 * 
 * @author mxl
 * @version $ CategoryRepositoryImpl.java v1.0, 2017年5月5日 上午11:05:44 mxl Exp $
 */
@Repository
public class CategoryLogRepositoryImpl implements CategoryLogRepository {
	
	@Resource
	private CategoryLogMapper	categoryLogMapper;
	
	/**
	 * @see com.cqu.edu.ebmis.repository.CategoryRepository#insert(com.cqu.edu.ebmis.domain.CategoryDO)
	 */
	@Override
	public int insert(CategoryLogDO categoryLogDO) {
	
		return categoryLogMapper.insert(categoryLogDO);
	}

	@Override
	public List<CategoryLogDO> selectByPage(int size, int offset) {
		// TODO Auto-generated method stub
		return categoryLogMapper.selectByPage(size, offset);
	}

	@Override
	public int selectAllCount() {
		// TODO Auto-generated method stub
		return categoryLogMapper.selectAllCount();
	}

	@Override
	public CategoryLogDO selectLatestLog() {
		// TODO Auto-generated method stub
		return categoryLogMapper.selectLatestLog();
	}
	
	
}

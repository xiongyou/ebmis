/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.repository.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.cqu.edu.ebmis.domain.CategoryDO;
import com.cqu.edu.ebmis.domain.CategoryManagerDO;
import com.cqu.edu.ebmis.mapper.CategoryManagerMapper;
import com.cqu.edu.ebmis.mapper.CategoryMapper;
import com.cqu.edu.ebmis.repository.CategoryManagerRepository;
import com.cqu.edu.ebmis.repository.CategoryRepository;

@Repository
public class CategoryManagerRepositoryImpl implements CategoryManagerRepository {
	@Resource
	private CategoryManagerMapper categoryManagerMapper;

	@Override
	public void save(CategoryManagerDO categoryManager) {
		// TODO Auto-generated method stub
		categoryManagerMapper.save(categoryManager);
		
	}

	@Override
	public void update(CategoryManagerDO categoryManager) {
		// TODO Auto-generated method stub
		categoryManagerMapper.update(categoryManager);
	}

	@Override
	public void del(int categoryId) {
		// TODO Auto-generated method stub
		categoryManagerMapper.del(categoryId);
	}

	@Override
	public List<CategoryManagerDO> getByParentId(int parentId) {
		// TODO Auto-generated method stub
		return categoryManagerMapper.getByParentId(parentId);
	}
	
	
}

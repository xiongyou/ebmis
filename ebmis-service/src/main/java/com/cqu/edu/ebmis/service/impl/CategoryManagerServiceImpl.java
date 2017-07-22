/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqu.edu.ebmis.domain.CategoryManagerDO;
import com.cqu.edu.ebmis.repository.CategoryManagerRepository;
import com.cqu.edu.ebmis.service.CategoryManagerService;

@Service
public class CategoryManagerServiceImpl implements CategoryManagerService {
	
	
	@Resource
	private CategoryManagerRepository catetoryManagerRepository;

	public void save(CategoryManagerDO categoryManager) {
		// TODO Auto-generated method stub
		catetoryManagerRepository.save(categoryManager);
	}

	public void update(CategoryManagerDO categoryManager) {
		// TODO Auto-generated method stub
		catetoryManagerRepository.update(categoryManager);
	}

	public void del(int categoryId) {
		// TODO Auto-generated method stub
		catetoryManagerRepository.del(categoryId);
	}

	public List<CategoryManagerDO> getByParentId(int parentId) {
		// TODO Auto-generated method stub
		return catetoryManagerRepository.getByParentId(parentId);
	}

	
}

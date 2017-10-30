/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
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

	@Override
	public CategoryManagerDO getById(int categoryId) {
		// TODO Auto-generated method stub
		return categoryManagerMapper.getById(categoryId);
	}

	@Override
	public void updateById(CategoryManagerDO categoryManager) {
		// TODO Auto-generated method stub
		categoryManagerMapper.updateById(categoryManager);
	}

	@Override
	public void transformTable() {
		// TODO Auto-generated method stub
		categoryManagerMapper.transformTable();
	}

	@Override
	public void transformTableDate() {
		// TODO Auto-generated method stub
		categoryManagerMapper.transformTableDate();
	}

	@Override
	public void copyTruncateTable() {
		// TODO Auto-generated method stub
		categoryManagerMapper.copyTruncateTable();
	}

	@Override
	public void copyTableDate() {
		// TODO Auto-generated method stub
		categoryManagerMapper.copyTableDate();
	}

	@Override
	public void restoreTableDate() {
		// TODO Auto-generated method stub
		categoryManagerMapper.restoreTableDate();
	}

	@Override
	public List<CategoryManagerDO> getNewKeyWordDate(int size,int offset,String word) {
		// TODO Auto-generated method stub
		return categoryManagerMapper.getNewKeyWordDate(size,offset,word);
	}

	@Override
	public int getNewKeyWordNum(int size,int offset,String word) {
		// TODO Auto-generated method stub
		return categoryManagerMapper.getNewKeyWordNum(size,offset,word);
	}

	@Override
	public void saveNewKeyWord(CategoryManagerDO categoryManager) {
		// TODO Auto-generated method stub
		categoryManagerMapper.saveNewKeyWord(categoryManager);
	}

	@Override
	public void updateNewKeyWord(HashMap map) {
		// TODO Auto-generated method stub
		categoryManagerMapper.updateNewKeyWord(map);
	}

	@Override
	public List<CategoryManagerDO> allLevel2Date() {
		// TODO Auto-generated method stub
		return categoryManagerMapper.allLevel2Date();
	}

	@Override
	public void editLinkNewKeyWord(CategoryManagerDO categoryManager) {
		// TODO Auto-generated method stub
		categoryManagerMapper.editLinkNewKeyWord(categoryManager);
	}

	@Override
	public void delNewKeyWord(int categoryId) {
		// TODO Auto-generated method stub
		categoryManagerMapper.delNewKeyWord(categoryId);
	}

	@Override
	public List<CategoryManagerDO> allLevel3Date() {
		// TODO Auto-generated method stub
		return categoryManagerMapper.allLevel3Date();
	}

	@Override
	public CategoryManagerDO level3findId(Map map) {
		// TODO Auto-generated method stub
		return categoryManagerMapper.level3findId(map);
	}

	@Override
	public List<CategoryManagerDO> allLevel0Date() {
		// TODO Auto-generated method stub
		return categoryManagerMapper.allLevel0Date();
	}

	@Override
	public List<CategoryManagerDO> getAllNewKeyWordDate() {
		// TODO Auto-generated method stub
		return categoryManagerMapper.getAllNewKeyWordDate();
	}

	
}

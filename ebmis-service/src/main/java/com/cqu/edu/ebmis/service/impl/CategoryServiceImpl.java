/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqu.edu.ebmis.domain.CategoryDO;
import com.cqu.edu.ebmis.repository.CategoryRepository;
import com.cqu.edu.ebmis.service.CategoryService;
import com.cqu.edu.ebmis.service.page.Page;

/**
 * 三级分类处理服务实现
 * 
 * @author mxl
 * @version $ CategoryServiceImpl.java v1.0, 2017年5月5日 上午11:35:34 mxl Exp $
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	
	/** 二级编码长度 */
	private final static int	SECOND_LEVEL_LENGTH	= 3;
	
	/** 三级编码长度 */
	private final static int	THRID_LEVEL_LENGTH	= 4;
	
	@Resource
	private CategoryRepository	catetoryRepository;
	
	/**
	 * @see com.cqu.edu.ebmis.service.CategoryService#save(com.cqu.edu.ebmis.domain.CategoryDO)
	 */
	public int save(CategoryDO category) {
	
		return catetoryRepository.insert(category);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.service.CategoryService#delete(java.lang.String)
	 */
	public int delete(String code) {
	
		return catetoryRepository.deleteByPrimaryKey(code);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.service.CategoryService#update(com.cqu.edu.ebmis.domain.CategoryDO)
	 */
	public CategoryDO update(CategoryDO category) {
	
		return catetoryRepository.update(category);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.service.CategoryService#findByName(java.lang.String)
	 */
	public CategoryDO findByName(String name) {
	
		return catetoryRepository.selectByName(name);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.service.CategoryService#findByCode(java.lang.String)
	 */
	public CategoryDO findByCode(String code) {
	
		return catetoryRepository.selectByPrimaryKey(code);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.service.CategoryService#findAll()
	 */
	public List<CategoryDO> findAll() {
	
		return catetoryRepository.selectAllCategory();
	}
	
	/**
	 * @see com.cqu.edu.ebmis.service.CategoryService#queryCategoryByParentCode(java.lang.String)
	 */
	public List<CategoryDO> queryCategoryByParentCode(String parentCode) {
	
		List<CategoryDO> roots = catetoryRepository
				.selectByParentCode(parentCode);
		
		if (roots == null) {
			
			return new ArrayList<CategoryDO>();
		}
		
		return roots;
	}
	
	/**
	 * @see com.cqu.edu.ebmis.service.CategoryService#constructCode(java.lang.String)
	 */
	public String constructCode(String parentCode) {
	
		List<CategoryDO> category = queryCategoryByParentCode(parentCode);
		
		if (category != null && category.size() > 0) {
			return parentCode
					+ getLevelCode(category.size() , category.get(0).getLevel());
		} else {
			return parentCode
					+ getLevelCode(0 , findByCode(parentCode).getLevel() + 1);
		}
		
	}
	
	/**
	 * 构造层级编码
	 * 
	 * @param size
	 * @return
	 */
	private String getLevelCode(int size, int level) {
	
		String tmp = (++size) + "";
		
		int codeLenth = 0;
		
		if (level == 1) {
			codeLenth = SECOND_LEVEL_LENGTH;
		} else if (level == 2) {
			codeLenth = THRID_LEVEL_LENGTH;
		}
		if (tmp.length() < codeLenth) {
			int z_length = codeLenth - tmp.length();
			for (int i = 0; i < z_length; i++) {
				tmp = "0" + tmp;
			}
			
		}
		return tmp;
		
	}
	
	/**
	 * @see com.cqu.edu.ebmis.service.CategoryService#findByPage(com.cqu.edu.ebmis.service.page.Page)
	 */
	public Page<CategoryDO> findByPage(Page<CategoryDO> page) {
	
		List<CategoryDO> keyWords = catetoryRepository.selectByPage(
				page.getLimit() , page.getOffset());
		page.setTotal(catetoryRepository.selectCount());
		
		page.setRecords(keyWords);
		return page;
	}
}

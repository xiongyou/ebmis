/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqu.edu.ebmis.domain.CategoryDO;
import com.cqu.edu.ebmis.domain.CategoryLogDO;
import com.cqu.edu.ebmis.repository.CategoryLogRepository;
import com.cqu.edu.ebmis.repository.CategoryRepository;
import com.cqu.edu.ebmis.service.CategoryLogService;
import com.cqu.edu.ebmis.service.CategoryService;
import com.cqu.edu.ebmis.service.page.Page;
/**
 * 日志管理
 * @author Administrator
 *
 */
@Service
public class CategoryLogServiceImpl implements CategoryLogService {
	
	@Resource
	private CategoryLogRepository	catetoryLogRepository;
	
	
	/**
	 * @see com.cqu.edu.ebmis.service.CategoryService#findByPage(com.cqu.edu.ebmis.service.page.Page)
	 */
	public Page<CategoryLogDO> findByPage(Page<CategoryLogDO> page) {
	
		List<CategoryLogDO> keyWords = catetoryLogRepository.selectByPage(
				page.getLimit() , page.getOffset());
		page.setTotal(catetoryLogRepository.selectAllCount());
		
		page.setRecords(keyWords);
		return page;
	}


	public int insert(CategoryLogDO categoryLogDo) {
		// TODO Auto-generated method stub
		return catetoryLogRepository.insert(categoryLogDo);
	}


	public CategoryLogDO selectLatestLog() {
		// TODO Auto-generated method stub
		return catetoryLogRepository.selectLatestLog();
	}


}

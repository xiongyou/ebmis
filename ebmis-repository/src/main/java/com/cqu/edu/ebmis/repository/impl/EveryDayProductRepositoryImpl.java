/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.repository.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.cqu.edu.ebmis.domain.CategoryDO;
import com.cqu.edu.ebmis.domain.CategoryLogDO;
import com.cqu.edu.ebmis.domain.EveryDayProductDO;
import com.cqu.edu.ebmis.mapper.CategoryLogMapper;
import com.cqu.edu.ebmis.mapper.CategoryMapper;
import com.cqu.edu.ebmis.mapper.EveryDayProductMapper;
import com.cqu.edu.ebmis.repository.CategoryLogRepository;
import com.cqu.edu.ebmis.repository.CategoryRepository;
import com.cqu.edu.ebmis.repository.EveryDayProductRepository;

/**
 * 三级分类仓储实现
 * 
 * @author mxl
 * @version $ CategoryRepositoryImpl.java v1.0, 2017年5月5日 上午11:05:44 mxl Exp $
 */
@Repository
public class EveryDayProductRepositoryImpl implements EveryDayProductRepository {
	
	@Resource
	private EveryDayProductMapper	everyDayProductMapper;

	@Override
	public int insert(EveryDayProductDO everyDayProductDO) {
		// TODO Auto-generated method stub
		return everyDayProductMapper.insert(everyDayProductDO);
	}

	
	
	
	
}

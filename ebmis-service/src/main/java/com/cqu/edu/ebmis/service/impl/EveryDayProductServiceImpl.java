/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqu.edu.ebmis.domain.EveryDayProductDO;
import com.cqu.edu.ebmis.repository.EveryDayProductRepository;
import com.cqu.edu.ebmis.service.EveryDayProductService;
/**
 * 日志管理
 * @author Administrator
 *
 */
@Service
public class EveryDayProductServiceImpl implements EveryDayProductService {
	
	@Resource
	private EveryDayProductRepository	everyDayProductRepository;

	public int insert(EveryDayProductDO everyDayProductDO) {
		// TODO Auto-generated method stub
		return everyDayProductRepository.insert(everyDayProductDO);
	}
	

}

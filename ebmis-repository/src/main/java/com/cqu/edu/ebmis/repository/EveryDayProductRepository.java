/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.repository;

import com.cqu.edu.ebmis.domain.EveryDayProductDO;


public interface EveryDayProductRepository {
	/**
	 * 将文件中的信息添加到表中
	 * @param categoryLogDo
	 * @return
	 */
	int insert(EveryDayProductDO everyDayProductDO);
}

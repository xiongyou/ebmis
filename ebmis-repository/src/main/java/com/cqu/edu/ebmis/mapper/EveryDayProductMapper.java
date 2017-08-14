/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.mapper;


import com.cqu.edu.ebmis.domain.EveryDayProductDO;

/**
 * 
 * @author mxl
 * @version $ CategoryMapper.java v1.0, 2017年5月5日 上午10:51:42 mxl Exp $
 */
public interface EveryDayProductMapper {
	/**
	 * 将文件中的信息添加到表中
	 * @param categoryLogDo
	 * @return
	 */
	int insert(EveryDayProductDO everyDayProductDO);
	
}

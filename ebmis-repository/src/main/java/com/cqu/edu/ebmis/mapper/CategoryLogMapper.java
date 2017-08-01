/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cqu.edu.ebmis.domain.CategoryDO;
import com.cqu.edu.ebmis.domain.CategoryLogDO;

/**
 * 
 * @author mxl
 * @version $ CategoryMapper.java v1.0, 2017年5月5日 上午10:51:42 mxl Exp $
 */
public interface CategoryLogMapper {
	/**
	 * 添加日志
	 * @param categoryLogDo
	 * @return
	 */
	int insert(CategoryLogDO categoryLogDo);
	/**
	 * 查询最近一次日志记录
	 * @param categoryLogDo
	 * @return
	 */
	CategoryLogDO selectLatestLog();
	/**
	 * 查询日志
	 * @param size
	 * @param offset
	 * @return
	 */
	List<CategoryLogDO> selectByPage(@Param("size") int size,
			@Param("offset") int offset);
	
	int selectAllCount();
}

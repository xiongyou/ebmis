/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cqu.edu.ebmis.domain.CategoryDO;
import com.cqu.edu.ebmis.domain.CategoryLogDO;


public interface CategoryLogRepository {
	
	/**
	 * 添加日志
	 * @param categoryLogDo
	 * @return
	 */
	int insert(CategoryLogDO categoryLogDO);
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
	/**
	 * 搜索查询日志
	 * @param size
	 * @param offset
	 * @return
	 */
	List<CategoryLogDO> searchByPage(@Param("size") int size,
			@Param("offset") int offset,@Param("word") String word);
	/**
	 * 搜索查询日志总数
	 * @param size
	 * @param offset
	 * @return
	 */
	int searchAllCount(@Param("word") String word);
}

/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.service;

import java.util.List;

import com.cqu.edu.ebmis.domain.CategoryDO;
import com.cqu.edu.ebmis.domain.CategoryLogDO;
import com.cqu.edu.ebmis.service.page.Page;

/**
 * 三级分类处理服务
 * 
 * @author mxl
 * @version $ CategoryService.java v1.0, 2017年5月5日 上午11:31:27 mxl Exp $
 */
public interface CategoryLogService {
	
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
	 * 分页查询
	 * 
	 * @param size
	 * @param offset
	 * @return
	 */
	Page<CategoryLogDO> findByPage(Page<CategoryLogDO> page);
	/**
	 * 分页模糊查询
	 * 
	 * @param size
	 * @param offset
	 * @return
	 */
	Page<CategoryLogDO> searchByPage(Page<CategoryLogDO> page,String word);
}

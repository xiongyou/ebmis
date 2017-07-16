/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cqu.edu.ebmis.domain.CategoryDO;

/**
 * 
 * @author mxl
 * @version $ CategoryMapper.java v1.0, 2017年5月5日 上午10:51:42 mxl Exp $
 */
public interface CategoryMapper {
	
	int insert(CategoryDO category);
	
	int deleteByPrimaryKey(@Param("code") String code);
	
	CategoryDO selectByPrimaryKey(@Param("code") String code);
	
	CategoryDO selectByName(String name);
	
	CategoryDO update(CategoryDO category);
	
	List<CategoryDO> selectAllCatetory();
	
	List<CategoryDO> selectByParentCode(String parentCode);
	
	List<CategoryDO> selectByPage(@Param("size") int size,
			@Param("offset") int offset);
	
	int selectAllCount();
}

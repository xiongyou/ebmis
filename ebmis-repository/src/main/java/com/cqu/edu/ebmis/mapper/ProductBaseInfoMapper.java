/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cqu.edu.ebmis.domain.ProductBaseInfoDO;

/**
 * 
 * @author mxl
 * @version $ ProductBaseInfoMapper.java v1.0, 2017年5月5日 下午10:28:01 mxl Exp $
 */
public interface ProductBaseInfoMapper {
	
	int deleteByPrimaryKey(@Param("productInnerId") long productInnerId);
	
	ProductBaseInfoDO selectByPrimaryKey(
			@Param("productInnerId") long productInnerId);
	
	int update(ProductBaseInfoDO product);
	
	List<ProductBaseInfoDO> selectAllProduct();
	
	List<ProductBaseInfoDO> selectByPage(@Param("size") int size,
			@Param("offset") int offset);
	
	
	int selectAllCount();

	List<ProductBaseInfoDO> selectCheckedByPage(@Param("checked") int checked,@Param("size") int size,
			@Param("offset") int offset);
	
	int selectCheckedCount(@Param("checked") int checked);
}

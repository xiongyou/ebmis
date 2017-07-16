/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cqu.edu.ebmis.domain.KeyWordDO;

/**
 * 
 * @author mxl
 * @version $ KeyWordMapper.java v1.0, 2017年5月7日 下午12:18:41 mxl Exp $
 */
public interface KeyWordMapper {
	
	int insert(KeyWordDO keyword);
	
	int deleteByPrimaryKey(@Param("id") long id);
	
	KeyWordDO selectByPrimaryKey(@Param("id") long id);
	
	KeyWordDO selectByKeyWord(String keyword);
	
	int update(KeyWordDO keyword);
	
	List<KeyWordDO> selectByParam(@Param("keyword") String keyword,@Param("size") int size,
			@Param("offset") int offset);
	
	List<KeyWordDO> selectAllKeyWord();
	
	
	
	List<KeyWordDO> selectByPage(@Param("size") int size,
			@Param("offset") int offset);
	
	int selectAllCount();
}

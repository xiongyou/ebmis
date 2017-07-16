/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cqu.edu.ebmis.domain.UserDO;

/**
 * 
 * @author mxl
 * @version $ UserMapper.java v1.0, 2017年4月25日 下午4:53:03 mxl Exp $
 */
public interface UserMapper {
	
	int insert(UserDO user);
	
	int deleteByPrimaryKey(@Param("userId") String userId);
	
	UserDO selectByPrimaryKey(@Param("userId") String userId);
	
	UserDO selectByUserName(String userName);
	
	UserDO update(UserDO user);
	
	List<UserDO> selectAllUser();
	
	List<UserDO> selectByPage(@Param("size") int size,
			@Param("offset") int offset);
	
	int selectAllCount();
	
}

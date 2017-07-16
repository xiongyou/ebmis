/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.repository.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.cqu.edu.ebmis.domain.UserDO;
import com.cqu.edu.ebmis.mapper.UserMapper;
import com.cqu.edu.ebmis.repository.UserRepository;

/**
 * 用户仓储实现
 * 
 * @author mxl
 * @version $ UserRepositoryImpl.java v1.0, 2017年4月25日 下午5:24:57 mxl Exp $
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@Resource
	private UserMapper	userMapper;
	
	/**
	 * @see com.cqu.edu.ebmis.repository.UserRepository#insert(com.cqu.edu.ebmis.domain.UserDO)
	 */
	@Override
	public int insert(UserDO user) {
	
		return userMapper.insert(user);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.UserRepository#deleteByPrimaryKey(java.lang.String)
	 */
	@Override
	public int deleteByPrimaryKey(String userId) {
	
		return userMapper.deleteByPrimaryKey(userId);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.UserRepository#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public UserDO selectByPrimaryKey(String userId) {
	
		return userMapper.selectByPrimaryKey(userId);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.UserRepository#selectByUserName(java.lang.String)
	 */
	@Override
	public UserDO selectByUserName(String userName) {
	
		return userMapper.selectByUserName(userName);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.UserRepository#update(com.cqu.edu.ebmis.domain.UserDO)
	 */
	@Override
	public int update(UserDO user) {
	
		userMapper.update(user);
		return 1;
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.UserRepository#selectAllUser()
	 */
	@Override
	public List<UserDO> selectAllUser() {
	
		return userMapper.selectAllUser();
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.UserRepository#selectByPage(int, int)
	 */
	@Override
	public List<UserDO> selectByPage(int size, int offset) {
	
		return userMapper.selectByPage(size , offset);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.UserRepository#selectCount()
	 */
	@Override
	public int selectCount() {
	
		return userMapper.selectAllCount();
	}
	
}

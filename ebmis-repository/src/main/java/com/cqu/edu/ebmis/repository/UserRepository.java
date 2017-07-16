/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cqu.edu.ebmis.domain.UserDO;

/**
 * 用户仓储
 * 
 * @author mxl
 * @version $ UserRepository.java v1.0, 2017年4月25日 下午5:24:20 mxl Exp $
 */
public interface UserRepository {
	
	/**
	 * 插入数据
	 * 
	 * @param user
	 * @return
	 */
	int insert(UserDO user);
	
	/**
	 * 删除
	 * 
	 * @param userId
	 * @return
	 */
	int deleteByPrimaryKey(String userId);
	
	/**
	 * 按主键查找
	 * 
	 * @param userId
	 * @return
	 */
	UserDO selectByPrimaryKey(String userId);
	
	/**
	 * 按用户名查找
	 * 
	 * @param userName
	 * @return
	 */
	UserDO selectByUserName(@Param("userName") String userName);
	
	/**
	 * 更新数据
	 * 
	 * @param user
	 * @return
	 */
	int update(UserDO user);
	
	/**
	 * 
	 * @return
	 */
	List<UserDO> selectAllUser();
	
	/**
	 * 查询分页
	 * 
	 * @param size
	 *            页大小
	 * @param offset
	 *            偏移量
	 * @return
	 */
	List<UserDO> selectByPage(int size, int offset);
	
	/**
	 * 
	 * @return
	 */
	int selectCount();
}

/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cqu.edu.ebmis.domain.UserDO;
import com.cqu.edu.ebmis.service.page.Page;
import com.cqu.edu.ebmis.service.vo.User;

/**
 * 用户服务
 * 
 * @author mxl
 * @version $ IUserService.java v1.0, 2017年4月25日 下午8:14:42 mxl Exp $
 */
public interface UserService {
	
	/**
	 * 存储操作
	 * 
	 * @param user
	 * @return
	 */
	void insert(UserDO user);
	
	/**
	 * 登陆
	 */
	UserDO loginUser(UserDO user);
	
	
	/**
	 * 根据用户昵称和用户名查找账号
	 */
	UserDO selectByUserName(UserDO user);
	
	/**
	 * 删除操作
	 * 
	 * @param user
	 * @return
	 */
	int delete(String userId);
	
	/**
	 * 更新操作
	 * 
	 * @param user
	 * @return
	 */
	void update(UserDO user);
	
	/**
	 * 按照用户名查找
	 * 
	 * @param userName
	 * @return
	 */
	User findByName(String userName);
	
	/**
	 * 按照用户名查找
	 * 
	 * @param userName
	 * @return
	 */
	User findByID(String userID);
	
	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	List<User> findAll();
	
	/**
	 * 分页查询
	 * 
	 * @param size
	 * @param offset
	 * @return
	 */
	Page<User> findByPage(Page<User> page);
	
	UserDO selectByUserAccount(String userName);
	
	void editUser(UserDO user);
}

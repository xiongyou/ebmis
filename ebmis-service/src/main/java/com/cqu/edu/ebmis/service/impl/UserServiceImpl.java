/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqu.edu.ebmis.domain.UserDO;
import com.cqu.edu.ebmis.repository.UserRepository;
import com.cqu.edu.ebmis.service.UserService;
import com.cqu.edu.ebmis.service.convert.UserConvert;
import com.cqu.edu.ebmis.service.page.Page;
import com.cqu.edu.ebmis.service.vo.User;

/**
 * 
 * @author mxl
 * @version $ IUserServiceImpl.java v1.0, 2017年4月25日 下午8:27:44 mxl Exp $
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserRepository	userRepository;
	
	/**
	 * @see com.cqu.edu.ebmis.service.UserService#save(com.cqu.edu.ebmis.service.vo.User)
	 */
	public int save(User user) {
	
		UserDO userDO = UserConvert.vo2DO(user);
		return userRepository.insert(userDO);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.service.UserService#delete(java.lang.String)
	 */
	public int delete(String userId) {
	
		return userRepository.deleteByPrimaryKey(userId);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.service.UserService#update(com.cqu.edu.ebmis.service.vo.User)
	 */
	public int update(User user) {
	
		UserDO userDO = UserConvert.vo2DO(user);
		
		return userRepository.update(userDO);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.service.UserService#findByName(java.lang.String)
	 */
	public User findByName(String userName) {
	
		UserDO userDO = userRepository.selectByUserName(userName);
		
		return UserConvert.do2VO(userDO);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.service.UserService#findAll()
	 */
	public List<User> findAll() {
	
		List<UserDO> doList = userRepository.selectAllUser();
		
		return UserConvert.doList2VOList(doList);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.service.UserService#findByID(java.lang.String)
	 */
	public User findByID(String userID) {
	
		UserDO userDO = userRepository.selectByPrimaryKey(userID);
		return UserConvert.do2VO(userDO);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.service.UserService#findByPage(com.cqu.edu.ebmis.service.page.Page)
	 */
	public Page<User> findByPage(Page<User> page) {
	
		List<UserDO> keyWords = userRepository.selectByPage(page.getLimit() ,
				page.getOffset());
		page.setTotal(userRepository.selectCount());
		
		page.setRecords(UserConvert.doList2VOList(keyWords));
		return page;
	}
	
}

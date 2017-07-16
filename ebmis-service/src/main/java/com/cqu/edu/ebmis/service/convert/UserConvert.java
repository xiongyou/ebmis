/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.service.convert;

import java.util.ArrayList;
import java.util.List;

import com.cqu.edu.ebmis.domain.UserDO;
import com.cqu.edu.ebmis.service.vo.User;

/**
 * 用户对象转换器
 * 
 * @author mxl
 * @version $ UserConvert.java v1.0, 2017年4月25日 下午8:30:01 mxl Exp $
 */
public class UserConvert {
	
	/**
	 * DO对象转换VO对象
	 * 
	 * @param userDO
	 * @return
	 */
	public static User do2VO(UserDO userDO) {
	
		if (userDO == null) {
			return null;
		}
		
		User user = new User();
		
		user.setUserId(userDO.getUserId());
		user.setUserName(userDO.getUserName());
		user.setNickName(userDO.getNickName());
		user.setPassword(userDO.getPassword());
		user.setCreateTime(userDO.getCreateTime());
		user.setModifyTime(userDO.getModifyTime());
		
		return user;
	}
	
	/**
	 * DO列表转换VO列表
	 * 
	 * @param doList
	 * @return
	 */
	public static List<User> doList2VOList(List<UserDO> doList) {
	
		if (doList == null || doList.size() == 0) {
			return null;
		}
		
		List<User> userList = new ArrayList<User>();
		
		for (UserDO userDO : doList) {
			
			userList.add(do2VO(userDO));
		}
		
		return userList;
	}
	
	/**
	 * VO对象转换DO对象
	 * 
	 * @param userDO
	 * @return
	 */
	public static UserDO vo2DO(User user) {
	
		if (user == null) {
			return null;
		}
		
		UserDO userDO = new UserDO();
		
		userDO.setUserId(user.getUserId());
		userDO.setUserName(user.getUserName());
		userDO.setNickName(user.getNickName());
		userDO.setPassword(user.getPassword());
		userDO.setCreateTime(user.getCreateTime());
		userDO.setModifyTime(user.getModifyTime());
		
		return userDO;
	}
}

/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.domain;

import java.util.Date;

/**
 * 用户
 * 
 * @author mxl
 * @version $ UserDO.java v1.0, 2017年4月25日 下午4:51:29 mxl Exp $
 */
public class UserDO {
	
	/** id */
	private long	id;
	
	/** 用户id */
	private String	userId;
	
	/** 用户名 */
	private String	userName;
	
	/** 昵称 */
	private String	nickName;
	
	/** 密码 */
	private String	password;
	
	/** 创建时间 */
	private Date	createTime;
	
	/** 更新时间 */
	private Date	modifyTime;
	
	/**
	 * @return the id
	 */
	public long getId() {
	
		return id;
	}
	
	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
	
		this.id = id;
	}
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
	
		return userId;
	}
	
	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
	
		this.userId = userId;
	}
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
	
		return userName;
	}
	
	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
	
		this.userName = userName;
	}
	
	/**
	 * @return the nickName
	 */
	public String getNickName() {
	
		return nickName;
	}
	
	/**
	 * @param nickName
	 *            the nickName to set
	 */
	public void setNickName(String nickName) {
	
		this.nickName = nickName;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
	
		return password;
	}
	
	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
	
		this.password = password;
	}
	
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
	
		return createTime;
	}
	
	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(Date createTime) {
	
		this.createTime = createTime;
	}
	
	/**
	 * @return the modifyTime
	 */
	public Date getModifyTime() {
	
		return modifyTime;
	}
	
	/**
	 * @param modifyTime
	 *            the modifyTime to set
	 */
	public void setModifyTime(Date modifyTime) {
	
		this.modifyTime = modifyTime;
	}
	
}

/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.domain;

import java.util.Date;
import java.util.List;

public class CategoryManagerDO {
	
	private Integer	categoryId;
	
	private String	categoryName;
	/**
	 * 父节点ID
	 */
	private Integer	parentId;
	/**
	 * 是否是父节点
	 */
	private String isParent;
	/**
	 * 是否显示
	 */
	private Integer visiable;
	private Integer isLeaf;
	private String userName;
	private Date addTime;
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getIsParent() {
		return isParent;
	}
	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}
	public Integer getVisiable() {
		return visiable;
	}
	public void setVisiable(Integer visiable) {
		this.visiable = visiable;
	}
	public Integer getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(Integer isLeaf) {
		this.isLeaf = isLeaf;
		if(isLeaf==0){
			this.isParent="false";
		}else{
			this.isParent="true";
		}
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
	
}

/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.domain;


public class CategoryManagerDO {
	
	private Integer	categoryId;
	
	private String	categoryName;
	/**
	 * 父节点ID
	 */
	private int	parentId;
	/**
	 * 是否是父节点
	 */
	private int	 isParent;
	/**
	 * 是否显示
	 */
	private Integer visiable;
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
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getIsParent() {
		return isParent;
	}
	public void setIsParent(int isParent) {
		this.isParent = isParent;
	}
	public Integer getVisiable() {
		return visiable;
	}
	public void setVisiable(Integer visiable) {
		this.visiable = visiable;
	}
	
	
	
}

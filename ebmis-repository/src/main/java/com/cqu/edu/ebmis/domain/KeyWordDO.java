/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.domain;

/**
 * 
 * @author mxl
 * @version $ KeyWordDO.java v1.0, 2017年5月7日 上午11:43:59 mxl Exp $
 */
public class KeyWordDO {
	
	private long	id;
	
	private String	keyword;
	
	private String	categoryCode;
	
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
	 * @return the keyword
	 */
	public String getKeyword() {
	
		return keyword;
	}
	
	/**
	 * @param keyword
	 *            the keyword to set
	 */
	public void setKeyword(String keyword) {
	
		this.keyword = keyword;
	}
	
	/**
	 * @return the categoryCode
	 */
	public String getCategoryCode() {
	
		return categoryCode;
	}
	
	/**
	 * @param categoryCode
	 *            the categoryCode to set
	 */
	public void setCategoryCode(String categoryCode) {
	
		this.categoryCode = categoryCode;
	}
	
}

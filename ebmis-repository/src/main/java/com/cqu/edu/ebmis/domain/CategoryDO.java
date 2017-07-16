/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.domain;

/**
 * 
 * @author mxl
 * @version $ CategoryDO.java v1.0, 2017年5月5日 上午10:50:06 mxl Exp $
 */
public class CategoryDO {
	
	private String	code;
	
	private String	name;
	
	private int		level;
	
	private String	parentCode;
	
	/**
	 * @return the code
	 */
	public String getCode() {
	
		return code;
	}
	
	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
	
		this.code = code;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
	
		return name;
	}
	
	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
	
		this.name = name;
	}
	
	/**
	 * @return the level
	 */
	public int getLevel() {
	
		return level;
	}
	
	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(int level) {
	
		this.level = level;
	}
	
	/**
	 * @return the parentCode
	 */
	public String getParentCode() {
	
		return parentCode;
	}
	
	/**
	 * @param parentCode
	 *            the parentCode to set
	 */
	public void setParentCode(String parentCode) {
	
		this.parentCode = parentCode;
	}
	
}

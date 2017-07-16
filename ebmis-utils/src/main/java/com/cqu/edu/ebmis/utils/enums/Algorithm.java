/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.utils.enums;

/**
 * <p>
 * 算法类型枚举类
 * </p>
 * 
 * @author mxl
 * @version $ Algorithm.java v1.0, 2017年4月26日 下午5:19:46 mxl Exp $
 */
public enum Algorithm {
	
	/** MD5 */
	MD5("MD5", "md5 encrypt"),
	
	/** SHA */
	SHA("SHA", "has encrypt"),
	
	/** AES */
	AES("AES", "aes encrypt");
	
	/** 主键 */
	private final String	key;
	
	/** 描述 */
	private final String	desc;
	
	Algorithm(final String key, final String desc) {
	
		this.key = key;
		this.desc = desc;
	}
	
	public String getKey() {
	
		return this.key;
	}
	
	public String getDesc() {
	
		return this.desc;
	}
}

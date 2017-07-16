/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.service.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * @author mxl
 * @version $ ToString.java v1.0, 2017年4月25日 下午8:17:27 mxl Exp $
 */
public class ToString implements Serializable {
	
	/** serialVersionUID */
	private static final long	serialVersionUID	= -8430158114125721933L;
	
	/**
	 * toString方法
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	
		return ToStringBuilder.reflectionToString(this ,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

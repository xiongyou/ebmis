/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.domain;

import java.util.Date;

/**
 * 
 * @author mxl
 * @version $ ProductBaseInfoDO.java v1.0, 2017年5月5日 下午10:26:07 mxl Exp $
 */
public class ProductBaseInfoDO {
	
	private long	productInnerId;
	
	private String	productName;

	
	private String	productURL;
	
	
	private String platform;
	
	private String keyword;
	private String categoryCode;
	
	private int		isValid;
	
	private int		checked;
	private String userName;
	private Date recheckPersonTime;
	private int recheckPersonNum;
	private double monthSaleCount;
	
	/**
	 * @return the productInnerId
	 */
	public long getProductInnerId() {
	
		return productInnerId;
	}
	
	/**
	 * @param productInnerId
	 *            the productInnerId to set
	 */
	public void setProductInnerId(long productInnerId) {
	
		this.productInnerId = productInnerId;
	}
	
	/**
	 * @return the productName
	 */
	public String getProductName() {
	
		return productName;
	}
	
	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
	
		this.productName = productName;
	}
	
	/**
	 * @return the productURL
	 */
	public String getProductURL() {
	
		return productURL;
	}
	
	/**
	 * @param productURL
	 *            the productURL to set
	 */
	public void setProductURL(String productURL) {
	
		this.productURL = productURL;
	}


	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	/**
	 * @return the isValid
	 */
	public int getIsValid() {
	
		return isValid;
	}
	
	/**
	 * @param isValid
	 *            the isValid to set
	 */
	public void setIsValid(int isValid) {
	
		this.isValid = isValid;
	}
	
	/**
	 * @return the checked
	 */
	public int getChecked() {
	
		return checked;
	}
	
	/**
	 * @param checked
	 *            the checked to set
	 */
	public void setChecked(int checked) {
	
		this.checked = checked;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getRecheckPersonTime() {
		return recheckPersonTime;
	}

	public void setRecheckPersonTime(Date recheckPersonTime) {
		this.recheckPersonTime = recheckPersonTime;
	}

	public int getRecheckPersonNum() {
		return recheckPersonNum;
	}

	public void setRecheckPersonNum(int recheckPersonNum) {
		this.recheckPersonNum = recheckPersonNum;
	}

	public double getMonthSaleCount() {
		return monthSaleCount;
	}

	public void setMonthSaleCount(double monthSaleCount) {
		this.monthSaleCount = monthSaleCount;
	}

	
	
}

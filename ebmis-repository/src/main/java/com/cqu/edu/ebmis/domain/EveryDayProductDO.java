/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.domain;

import java.util.Date;

public class EveryDayProductDO {
	
	private Long productInnerId;
	private String keyWord;
	private String productActualId;
	private String productPrice;
	private String productPromPrice;
	private String monthsalecount;
	private String producturl;
	private Date extracttime;
	private String commentcount;
	public Long getProductInnerId() {
		return productInnerId;
	}
	public void setProductInnerId(Long productInnerId) {
		this.productInnerId = productInnerId;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getProductActualId() {
		return productActualId;
	}
	public void setProductActualId(String productActualId) {
		this.productActualId = productActualId;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductPromPrice() {
		return productPromPrice;
	}
	public void setProductPromPrice(String productPromPrice) {
		this.productPromPrice = productPromPrice;
	}
	public String getMonthsalecount() {
		return monthsalecount;
	}
	public void setMonthsalecount(String monthsalecount) {
		this.monthsalecount = monthsalecount;
	}
	public String getProducturl() {
		return producturl;
	}
	public void setProducturl(String producturl) {
		this.producturl = producturl;
	}
	public Date getExtracttime() {
		return extracttime;
	}
	public void setExtracttime(Date extracttime) {
		this.extracttime = extracttime;
	}
	public String getCommentcount() {
		return commentcount;
	}
	public void setCommentcount(String commentcount) {
		this.commentcount = commentcount;
	}
	
}

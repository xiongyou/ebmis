package com.cqu.edu.ebmis.domain;
import java.util.Date;


public class UrlDO {

	private int productInnerId;
	
	private String productURL;
		
	private Date getURLTime;
		
	private String platform;
		
	private Byte status;
		
	private String keyWord;
		
	
	private String md;
	
	private int relativeInnerId;
		
	public int getProductInnerId() {
		return productInnerId;
	}
	public void setProductInnerId(int productInnerId) {
		this.productInnerId = productInnerId;
	}
	public String getProductURL() {
		return productURL;
	}
	public void setProductURL(String productURL) {
		this.productURL = productURL;
	}
	public Date getGetURLTime() {
		return getURLTime;
	}
	public void setGetURLTime(Date getURLTime) {
		this.getURLTime = getURLTime;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}	
	
	
	 public int rotatingHash(String key) {  
	        int n = key.length();  
	        int hash = n;  
	        for (int i = 0; i < n; i++)  
	            hash = (hash << 4) ^ (hash >> 28) ^ key.charAt(i);  
	        return (hash & 0x7FFFFFFF);  
	    }
	public String getMd() {
		return md;
	}
	public void setMd(String md) {
		this.md = md;
	}
	public int getRelativeInnerId() {
		return relativeInnerId;
	}
	public void setRelativeInnerId(int relativeInnerId) {
		this.relativeInnerId = relativeInnerId;
	}  
}

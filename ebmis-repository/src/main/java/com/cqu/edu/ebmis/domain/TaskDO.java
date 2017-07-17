package com.cqu.edu.ebmis.domain;
import java.security.MessageDigest;
public class TaskDO {

	private Integer taskId;
	
	private String url;
	
	private Integer productInnerId;
	
	private String dataObj;
	
	private Integer projectId;
	
	private String website;
	
	private String keyword;
	private String md;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getProductInnerId() {
		return productInnerId;
	}

	public void setProductInnerId(Integer productInnerId) {
		this.productInnerId = productInnerId;
	}

	public String getDataObj() {
		return dataObj;
	}

	public void setDataObj(String dataObj) {
		this.dataObj = dataObj;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

//	public int getUrlHashForm() {
//		return urlHashForm;
//	}
//
//	public void setUrlHashForm(int urlHashForm) {
//		this.urlHashForm = urlHashForm;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	 public int rotatingHash(String key) {  
	        int n = key.length();  
	        int hash = n;  
	        for (int i = 0; i < n; i++)  
	            hash = (hash << 4) ^ (hash >> 28) ^ key.charAt(i);  
	        return (hash & 0x7FFFFFFF);  
	    }  
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskDO other = (TaskDO) obj;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	public String getMd() {
		return md;
	}

	public void setMd(String md) {
		this.md = md;
	}
	
	
	
	
}

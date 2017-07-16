package com.cqu.edu.ebmis.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 查询dto对象
 * @author xy
 *
 */
public class QueryDto {

	private String iDisplayStart;
	private String iDisplayLength;
	private String sEcho;
	
	
	private Map<String,Object> params = new HashMap<String, Object>();

	public String getIDisplayStart() {
		return iDisplayStart;
	}

	public void setIDisplayStart(String iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}

	public String getIDisplayLength() {
		return iDisplayLength;
	}

	public void setIDisplayLength(String iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}

	public String getSEcho() {
		return sEcho;
	}

	public void setSEcho(String sEcho) {
		this.sEcho = sEcho;
	}


	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	
	public Map<String, Object> getClientParams(){
		Map<String, Object> map = new HashMap<String, Object>(params.size());
		for (String param:params.keySet()) {
			String key = "params["+param+"]";
			map.put(key, params.get(param));
		}
		return map;
	}
}

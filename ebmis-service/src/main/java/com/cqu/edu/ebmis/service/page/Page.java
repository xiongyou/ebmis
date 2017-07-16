package com.cqu.edu.ebmis.service.page;

import java.util.Collections;
import java.util.List;

/**
 * 
 * @author mxl
 * @version $ Page.java v1.0, 2017年4月25日 下午9:24:44 mxl Exp $
 */
public class Page<T> extends Pagination {
	
	private static final long	serialVersionUID	= 1L;
	
	/**
	 * 查询数据列表
	 */
	private List<T>				records				= Collections.emptyList();
	
	protected Page() {
	
		/* 保护 */
	}
	
	public Page(int current, int size) {
	
		super(current , size);
	}
	
	public List<T> getRecords() {
	
		return records;
	}
	
	public void setRecords(List<T> records) {
	
		this.records = records;
	}
	
	@Override
	public String toString() {
	
		StringBuffer pg = new StringBuffer();
		pg.append(" Page:{ [").append(super.toString()).append("], ");
		if (records != null) {
			pg.append("records-size:").append(records.size());
		} else {
			pg.append("records is null");
		}
		return pg.append(" }").toString();
	}
}

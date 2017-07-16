/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.service.page;

import java.io.Serializable;

import org.apache.ibatis.session.RowBounds;

/**
 * 
 * @author mxl
 * @version $ Pagination.java v1.0, 2017年4月25日 下午9:24:13 mxl Exp $
 */
public class Pagination extends RowBounds implements Serializable {
	
	private static final long	serialVersionUID	= 1L;
	
	/* 总数 */
	private int					total;
	
	/* 每页显示条数 */
	private int					size;
	
	/* 总页数 */
	private int					pages;
	
	/* 当前页 */
	private int					current				= 1;
	
	public Pagination() {
	
		super();
	}
	
	/**
	 * <p>
	 * 分页构造函数
	 * </p>
	 * 
	 * @param current
	 *            当前页
	 * @param size
	 *            每页显示条数
	 */
	public Pagination(int current, int size) {
	
		super(offsetCurrent(current , size) , size);
		if (current > 1) {
			this.current = current;
		}
		this.size = size;
	}
	
	protected static int offsetCurrent(int current, int size) {
	
		if (current > 0) {
			return (current - 1) * size;
		}
		return 0;
	}
	
	public int getOffsetCurrent() {
	
		return offsetCurrent(this.current , this.size);
	}
	
	public boolean hasPrevious() {
	
		return this.current > 1;
	}
	
	public boolean hasNext() {
	
		return this.current < this.pages;
	}
	
	public int getTotal() {
	
		return total;
	}
	
	public void setTotal(int total) {
	
		this.total = total;
		this.pages = this.total / this.size;
		if (this.total % this.size != 0) {
			this.pages++;
		}
		if (this.current > this.pages) {
			/**
			 * 当前页大于总页数，当前页设置为第一页
			 */
			this.current = 1;
		}
	}
	
	public int getSize() {
	
		return size;
	}
	
	public int getPages() {
	
		return pages;
	}
	
	public int getCurrent() {
	
		return current;
	}
	
	@Override
	public String toString() {
	
		return "Pagination { total=" + total + " ,size=" + size + " ,pages="
				+ pages + " ,current=" + current + " }";
	}
}
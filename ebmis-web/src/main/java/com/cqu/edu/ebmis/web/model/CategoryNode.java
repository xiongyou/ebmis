/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.model;

import java.io.Serializable;
import java.util.List;

/**
 * 类别节点模型
 * 
 * @author mxl
 * @version $ CategoryNode.java v1.0, 2017年5月10日 下午7:55:14 mxl Exp $
 */
public class CategoryNode implements Serializable {
	
	/** serialVersionUID */
	private static final long	serialVersionUID	= -1549585935218478510L;
	
	private String				text;
	
	private String				code;
	
	private List<CategoryNode>	nodes;
	
	/**
	 * @return the text
	 */
	public String getText() {
	
		return text;
	}
	
	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
	
		this.text = text;
	}
	
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
	 * @return the nodes
	 */
	public List<CategoryNode> getNodes() {
	
		return nodes;
	}
	
	/**
	 * @param nodes
	 *            the nodes to set
	 */
	public void setNodes(List<CategoryNode> nodes) {
	
		this.nodes = nodes;
	}
	
}

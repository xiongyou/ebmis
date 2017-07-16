/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.convert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cqu.edu.ebmis.domain.CategoryDO;
import com.cqu.edu.ebmis.web.model.CategoryNode;

/**
 * 
 * @author mxl
 * @version $ CategoryConvert.java v1.0, 2017年5月10日 下午8:12:50 mxl Exp $
 */
public class CategoryConvert {
	
	/**
	 * 构造节点树
	 * 
	 * @param categorys
	 * @param parenCode
	 * @return
	 */
	public static List<CategoryNode> covert(List<CategoryDO> categorys,
			String parenCode) {
	
		List<CategoryNode> nodes = new ArrayList<CategoryNode>();
		Map<String , List<CategoryDO>> maps = getMaps(categorys);
		
		List<CategoryDO> parent = maps.get(parenCode);
		
		for (CategoryDO category : parent) {
			CategoryNode node = new CategoryNode();
			
			node.setText(category.getName());
			node.setCode(category.getCode());
			node.setNodes(getChildNodeByParent(maps , category.getCode()));
			
			nodes.add(node);
			
		}
		
		return nodes;
	}
	
	/**
	 * 获取孩子节点
	 * 
	 * @param maps
	 * @param parentCode
	 * @return
	 */
	private static List<CategoryNode> getChildNodeByParent(
			Map<String , List<CategoryDO>> maps, String parentCode) {
	
		List<CategoryNode> nodes = new ArrayList<CategoryNode>();
		
		List<CategoryDO> child = maps.get(parentCode);
		
		if (child == null) {
			return nodes;
		}
		for (CategoryDO category : child) {
			
			CategoryNode node = new CategoryNode();
			
			node.setText(category.getName());
			node.setCode(category.getCode());
			node.setNodes(getChildNodeByParent(maps , category.getCode()));
			
			nodes.add(node);
		}
		
		return nodes;
		
	}
	
	/**
	 * 
	 * @param categorys
	 * @return
	 */
	private static Map<String , List<CategoryDO>> getMaps(
			List<CategoryDO> categorys) {
	
		Map<String , List<CategoryDO>> maps = new HashMap<String , List<CategoryDO>>();
		
		for (CategoryDO category : categorys) {
			
			String parentCode = category.getParentCode();
			
			if (maps.get(parentCode) == null) {
				List<CategoryDO> nodes = new ArrayList<CategoryDO>();
				
				nodes.add(category);
				maps.put(parentCode , nodes);
			} else {
				maps.get(parentCode).add(category);
			}
			
		}
		
		return maps;
		
	}
}

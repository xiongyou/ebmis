/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.test;

/**
 * 
 * @author mxl
 * @version $ DBIUtils.java v1.0, 2017年5月10日 下午4:34:44 mxl Exp $
 */
public class DBIUtils {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		produceSQL();
		
	}
	
	private static void produceSQL() {
	
		for (int i = 1; i < 9; i++) {
			
			String sql = "update category  set parent_code=1100" + i
					+ " where category_code like '1100" + i + "%' and level=2;";
			System.out.println(sql);
		}
		
	}
}

package com.cqu.edu.ebmis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ReportService {
	/**获取采集的原始数据
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getOriginData(HashMap map);
	/**
	 *原始数据所有的条数
	 * @param map
	 * @return
	 */
	int getOriginDataCount();
	/**
	 * 重庆本土网店清单数据
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getCQLocalStore(HashMap map); 
	/**
	 *重庆本土网店清单的条数
	 * @param map
	 * @return
	 */
	int getCQLocalStoreCount();
	/**
	 * 阿里平台分类统计
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> AliClassifyData(HashMap map); 
	/**
	 *阿里平台分类统计的条数
	 * @param map
	 * @return
	 */
	int AliClassifyCount();
	/**
	 * 天猫月度单品20强
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> TmMonthProductData(HashMap map);
	/**
	 * 淘宝月度单品20强
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> TbMonthProductData(HashMap map);
}

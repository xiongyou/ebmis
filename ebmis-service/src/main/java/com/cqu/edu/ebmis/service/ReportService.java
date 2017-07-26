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
	/**
	 * 所有商品数据
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> allProductNumData(HashMap map); 
	/**
	 *所有商品数据的条数
	 * @param map
	 * @return
	 */
	int allProductNumCount();
	/**
	 * 重庆农产品数量
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> CQFarmProductNumData(HashMap map); 
	/**
	 *重庆农产品数量的条数
	 * @param map
	 * @return
	 */
	int CQFarmProductNumCount();
	/**
	 * 分平台店铺数量
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> PlatformStoreNumData(HashMap map); 
	/**
	 *分平台店铺数量的条数
	 * @param map
	 * @return
	 */
	int PlatformStoreNumCount();
	/**
	 * 分类体系
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> ClassifySystemData(HashMap map); 
	/**
	 *分类体系的条数
	 * @param map
	 * @return
	 */
	int ClassifySystemCount();
	/**
	 * 一级分类统计
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> OneClassifyData(HashMap map); 
	/**
	 *一级分类统计的条数
	 * @param map
	 * @return
	 */
	int OneClassifyCount();
	/**
	 * 生鲜分类统计
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> FreshClassifyData(HashMap map); 
	/**
	 *生鲜分类统计的条数
	 * @param map
	 * @return
	 */
	int FreshClassifyCount();
	/**
	 * 非生鲜分类统计
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> NoFreshClassifyData(HashMap map); 
	/**
	 *非生鲜分类统计的条数
	 * @param map
	 * @return
	 */
	int NoFreshClassifyCount();
}

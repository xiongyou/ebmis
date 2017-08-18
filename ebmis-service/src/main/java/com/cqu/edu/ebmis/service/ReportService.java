package com.cqu.edu.ebmis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ReportService {
	
	/**
	 * 修改原始数据的复核数据
	 * @param map
	 * @return
	 */
	void updateOriginData(HashMap map);
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
	int getOriginDataCount(HashMap map);
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
	 *重庆农产品上网销售品类数清单
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> CQFarmNetMarketClassifyData(HashMap map);
	/**
	 *监测统计总表
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> ControlStatisticsTotalData(HashMap map); 
	/**
	 *阿里平台分类统计的条数
	 * @param map
	 * @return
	 */
	int AliClassifyCount(HashMap map);
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
	int allProductNumCount(HashMap map);
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
	int CQFarmProductNumCount(HashMap map);
	/**
	 * 注册地在重庆的农产品网店数量
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> CQFarmProductStoreNumData(HashMap map); 
	/**
	 *注册地在重庆的农产品网店数量的条数
	 * @param map
	 * @return
	 */
	int CQFarmProductStoreNumCount(HashMap map);
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
	int PlatformStoreNumCount(HashMap map);
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
	int OneClassifyCount(HashMap map);
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
	int FreshClassifyCount(HashMap map);
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
	int NoFreshClassifyCount(HashMap map);
	/**
	 * 重庆农产品各省市销售情况
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> CQFarmProductEveryMarketData(HashMap map); 
	/**
	 *重庆农产品各省市销售情况的条数
	 * @param map
	 * @return
	 */
	int CQFarmProductEveryMarketCount();
	/**
	 * 重庆农产品分省店铺数量
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> CQFarmProductEveryStoreData(HashMap map); 
	/**
	 *重庆农产品分省店铺数量的条数
	 * @param map
	 * @return
	 */
	int CQFarmProductEveryStoreCount();
	/**
	 * 售卖重庆农产品的店铺
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> MarketCQFarmProductStoreData(HashMap map); 
	/**
	 *售卖重庆农产品的店铺的条数
	 * @param map
	 * @return
	 */
	int MarketCQFarmProductStoreCount();
	/**
	 * 重庆各区县店铺数量
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> CQEveryCityStoreData(HashMap map); 
	/**
	 *重庆各区县店铺数量的条数
	 * @param map
	 * @return
	 */
	int CQEveryCityStoreCount();
}

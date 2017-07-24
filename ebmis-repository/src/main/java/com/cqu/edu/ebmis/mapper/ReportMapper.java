package com.cqu.edu.ebmis.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ReportMapper {

	/**
	 * 获取原始的采集数据
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getOriginData(HashMap map); 
}

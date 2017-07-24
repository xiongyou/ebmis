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
}

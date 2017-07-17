package com.cqu.edu.ebmis.handler;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * 查询返回两列的Map
 * 
 * @author xiongyou1701
 *
 */
public class MapResultHandler  implements ResultHandler {

	@SuppressWarnings("rawtypes")
	private final Map mappedResults = new HashMap();

	@SuppressWarnings("unchecked")
	@Override
	public void handleResult(ResultContext context) {
		@SuppressWarnings("rawtypes")
		Map map = (Map) context.getResultObject();
		mappedResults.put(map.get("key"), map.get("value")); // xml
																// 配置里面的property的值，对应的列
	}

	public Map getMappedResults() {
		return mappedResults;
	}
}

package com.cqu.edu.ebmis.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cqu.edu.ebmis.mapper.ReportMapper;
import com.cqu.edu.ebmis.repository.ReportRepository;
@Repository
public class ReportRepositoryImpl implements ReportRepository {
	@Autowired
	private ReportMapper reportMapper;
	@Override
	public List<Map<String, Object>> getOriginData(HashMap map) {
		// TODO Auto-generated method stub
		return reportMapper.getOriginData(map);
	}

}

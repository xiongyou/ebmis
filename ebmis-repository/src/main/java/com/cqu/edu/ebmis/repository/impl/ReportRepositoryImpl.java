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
	@Override
	public int getOriginDataCount() {
		// TODO Auto-generated method stub
		return reportMapper.getOriginDataCount();
	}
	@Override
	public List<Map<String, Object>> getCQLocalStore(HashMap map) {
		// TODO Auto-generated method stub
		return reportMapper.getCQLocalStore(map);
	}
	@Override
	public int getCQLocalStoreCount() {
		// TODO Auto-generated method stub
		return reportMapper.getCQLocalStoreCount();
	}
	@Override
	public List<Map<String, Object>> AliClassifyData(HashMap map) {
		// TODO Auto-generated method stub
		return reportMapper.AliClassifyData(map);
	}
	@Override
	public int AliClassifyCount() {
		// TODO Auto-generated method stub
		return reportMapper.AliClassifyCount();
	}
	@Override
	public List<Map<String, Object>> TmMonthProductData(HashMap map) {
		// TODO Auto-generated method stub
		return reportMapper.TmMonthProductData(map);
	}
	@Override
	public List<Map<String, Object>> TbMonthProductData(HashMap map) {
		// TODO Auto-generated method stub
		return reportMapper.TbMonthProductData(map);
	}

}

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
	public int getOriginDataCount(HashMap map) {
		// TODO Auto-generated method stub
		return reportMapper.getOriginDataCount(map);
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
	public int AliClassifyCount(HashMap map) {
		// TODO Auto-generated method stub
		return reportMapper.AliClassifyCount(map);
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
	@Override
	public List<Map<String, Object>> allProductNumData(HashMap map) {
		// TODO Auto-generated method stub
		return reportMapper.allProductNumData(map);
	}
	@Override
	public int allProductNumCount(HashMap map) {
		// TODO Auto-generated method stub
		return reportMapper.allProductNumCount(map);
	}
	@Override
	public List<Map<String, Object>> CQFarmProductNumData(HashMap map) {
		// TODO Auto-generated method stub
		return reportMapper.CQFarmProductNumData(map);
	}
	@Override
	public int CQFarmProductNumCount(HashMap map) {
		// TODO Auto-generated method stub
		return reportMapper.CQFarmProductNumCount(map);
	}
	@Override
	public List<Map<String, Object>> PlatformStoreNumData(HashMap map) {
		// TODO Auto-generated method stub
		return reportMapper.PlatformStoreNumData(map);
	}
	@Override
	public int PlatformStoreNumCount(HashMap map) {
		// TODO Auto-generated method stub
		return reportMapper.PlatformStoreNumCount(map);
	}
	@Override
	public List<Map<String, Object>> ClassifySystemData(HashMap map) {
		// TODO Auto-generated method stub
		return reportMapper.ClassifySystemData(map);
	}
	@Override
	public int ClassifySystemCount() {
		// TODO Auto-generated method stub
		return reportMapper.ClassifySystemCount();
	}
	@Override
	public List<Map<String, Object>> OneClassifyData(HashMap map) {
		// TODO Auto-generated method stub
		return reportMapper.OneClassifyData(map);
	}
	@Override
	public int OneClassifyCount(HashMap map) {
		// TODO Auto-generated method stub
		return reportMapper.OneClassifyCount(map);
	}
	@Override
	public List<Map<String, Object>> FreshClassifyData(HashMap map) {
		// TODO Auto-generated method stub
		return reportMapper.FreshClassifyData(map);
	}
	@Override
	public int FreshClassifyCount(HashMap map) {
		// TODO Auto-generated method stub
		return reportMapper.FreshClassifyCount(map);
	}
	@Override
	public List<Map<String, Object>> NoFreshClassifyData(HashMap map) {
		// TODO Auto-generated method stub
		return reportMapper.NoFreshClassifyData(map);
	}
	@Override
	public int NoFreshClassifyCount(HashMap map) {
		// TODO Auto-generated method stub
		return reportMapper.NoFreshClassifyCount(map);
	}
	@Override
	public List<Map<String, Object>> CQFarmProductEveryMarketData(HashMap map) {
		// TODO Auto-generated method stub
		return reportMapper.CQFarmProductEveryMarketData(map);
	}
	@Override
	public int CQFarmProductEveryMarketCount() {
		// TODO Auto-generated method stub
		return reportMapper.CQFarmProductEveryMarketCount();
	}
	@Override
	public List<Map<String, Object>> CQFarmProductEveryStoreData(HashMap map) {
		// TODO Auto-generated method stub
		return reportMapper.CQFarmProductEveryStoreData(map);
	}
	@Override
	public int CQFarmProductEveryStoreCount() {
		// TODO Auto-generated method stub
		return reportMapper.CQFarmProductEveryStoreCount();
	}
	@Override
	public List<Map<String, Object>> MarketCQFarmProductStoreData(HashMap map) {
		// TODO Auto-generated method stub
		return reportMapper.MarketCQFarmProductStoreData(map);
	}
	@Override
	public int MarketCQFarmProductStoreCount() {
		// TODO Auto-generated method stub
		return reportMapper.MarketCQFarmProductStoreCount();
	}
	@Override
	public List<Map<String, Object>> CQEveryCityStoreData(HashMap map) {
		// TODO Auto-generated method stub
		return reportMapper.CQEveryCityStoreData(map);
	}
	@Override
	public int CQEveryCityStoreCount() {
		// TODO Auto-generated method stub
		return reportMapper.CQEveryCityStoreCount();
	}
	@Override
	public void updateOriginData(HashMap map) {
		// TODO Auto-generated method stub
		reportMapper.updateOriginData(map);
	}

}

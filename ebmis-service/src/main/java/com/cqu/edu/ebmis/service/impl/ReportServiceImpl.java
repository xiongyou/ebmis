package com.cqu.edu.ebmis.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqu.edu.ebmis.repository.ReportRepository;
import com.cqu.edu.ebmis.service.ReportService;
@Service
public class ReportServiceImpl implements ReportService {
	@Resource private ReportRepository reportRepository;
	public List<Map<String, Object>> getOriginData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.getOriginData(map);
	}
	public int getOriginDataCount(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.getOriginDataCount(map);
	}
	public List<Map<String, Object>> getCQLocalStore(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.getCQLocalStore(map);
	}
	public int getCQLocalStoreCount(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.getCQLocalStoreCount(map);
	}
	public List<Map<String, Object>> AliClassifyData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.AliClassifyData(map);
	}
	public int AliClassifyCount(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.AliClassifyCount(map);
	}
	public List<Map<String, Object>> TmMonthProductData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.TmMonthProductData(map);
	}
	public List<Map<String, Object>> TbMonthProductData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.TbMonthProductData(map);
	}
	public List<Map<String, Object>> allProductNumData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.allProductNumData(map);
	}
	public int allProductNumCount(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.allProductNumCount(map);
	}
	public List<Map<String, Object>> CQFarmProductNumData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.CQFarmProductNumData(map);
	}
	public int CQFarmProductNumCount(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.CQFarmProductNumCount(map);
	}
	public List<Map<String, Object>> PlatformStoreNumData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.PlatformStoreNumData(map);
	}
	public int PlatformStoreNumCount(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.PlatformStoreNumCount(map);
	}
	public List<Map<String, Object>> ClassifySystemData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.ClassifySystemData(map);
	}
	public int ClassifySystemCount() {
		// TODO Auto-generated method stub
		return reportRepository.ClassifySystemCount();
	}
	public List<Map<String, Object>> OneClassifyData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.OneClassifyData(map);
	}
	public int OneClassifyCount(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.OneClassifyCount(map);
	}
	public List<Map<String, Object>> FreshClassifyData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.FreshClassifyData(map);
	}
	public int FreshClassifyCount(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.FreshClassifyCount(map);
	}
	public List<Map<String, Object>> NoFreshClassifyData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.NoFreshClassifyData(map);
	}
	public int NoFreshClassifyCount(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.NoFreshClassifyCount(map);
	}
	public List<Map<String, Object>> CQFarmProductEveryMarketData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.CQFarmProductEveryMarketData(map);
	}
	public int CQFarmProductEveryMarketCount(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.CQFarmProductEveryMarketCount(map);
	}
	public List<Map<String, Object>> CQFarmProductEveryStoreData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.CQFarmProductEveryStoreData(map);
	}
	public int CQFarmProductEveryStoreCount(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.CQFarmProductEveryStoreCount(map);
	}
	public List<Map<String, Object>> MarketCQFarmProductStoreData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.MarketCQFarmProductStoreData(map);
	}
	public int MarketCQFarmProductStoreCount(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.MarketCQFarmProductStoreCount(map);
	}
	public List<Map<String, Object>> CQEveryCityStoreData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.CQEveryCityStoreData(map);
	}
	public int CQEveryCityStoreCount() {
		// TODO Auto-generated method stub
		return reportRepository.CQEveryCityStoreCount();
	}
	public void updateOriginData(HashMap map) {
		// TODO Auto-generated method stub
		reportRepository.updateOriginData(map);
	}
	public List<Map<String, Object>> CQFarmProductStoreNumData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.CQFarmProductStoreNumData(map);
	}
	public int CQFarmProductStoreNumCount(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.CQFarmProductStoreNumCount(map);
	}
	public List<Map<String, Object>> CQFarmNetMarketClassifyData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.CQFarmNetMarketClassifyData(map);
	}
	public List<Map<String, Object>> ControlStatisticsTotalData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.ControlStatisticsTotalData(map);
	}
	public int CQFarmNetMarketClassifyCount(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.CQFarmNetMarketClassifyCount(map);
	}
	public int ControlStatisticsTotalCount(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.ControlStatisticsTotalCount(map);
	}
	public List<Map<String, Object>> EveryCityFarmProductNumData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.EveryCityFarmProductNumData(map);
	}
	public int EveryCityFarmProductNumCount(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.EveryCityFarmProductNumCount(map);
	}

}

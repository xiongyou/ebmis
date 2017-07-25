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
	public int getOriginDataCount() {
		// TODO Auto-generated method stub
		return reportRepository.getOriginDataCount();
	}
	public List<Map<String, Object>> getCQLocalStore(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.getCQLocalStore(map);
	}
	public int getCQLocalStoreCount() {
		// TODO Auto-generated method stub
		return reportRepository.getCQLocalStoreCount();
	}
	public List<Map<String, Object>> AliClassifyData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.AliClassifyData(map);
	}
	public int AliClassifyCount() {
		// TODO Auto-generated method stub
		return reportRepository.AliClassifyCount();
	}
	public List<Map<String, Object>> TmMonthProductData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.TmMonthProductData(map);
	}
	public List<Map<String, Object>> TbMonthProductData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.TbMonthProductData(map);
	}

}

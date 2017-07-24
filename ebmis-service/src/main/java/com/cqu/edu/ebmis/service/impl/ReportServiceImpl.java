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
	public List<Map<String, Object>> getOrignData(HashMap map) {
		// TODO Auto-generated method stub
		return reportRepository.getOrignData(map);
	}

}

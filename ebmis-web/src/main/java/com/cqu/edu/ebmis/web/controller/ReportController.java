package com.cqu.edu.ebmis.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cqu.edu.ebmis.service.ReportService;

@Controller
@RequestMapping("/report")
public class ReportController extends SuperController {
	@Autowired
	private ReportService reportService;
	@RequestMapping("/origin")
	public String list(Model model) {
		
		HashMap map=new HashMap();
    	map.put("size", 1);
    	map.put("offset", 10);
    	List<Map<String, Object>> res=reportService.getOriginData(map);
    	System.out.println(res.size());
		return "";
		
	}
}

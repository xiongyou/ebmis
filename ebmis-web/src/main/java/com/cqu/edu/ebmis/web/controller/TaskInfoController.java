/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cqu.edu.ebmis.domain.TaskInfoDO;
import com.cqu.edu.ebmis.service.TaskInfoService;

/**
 * 三级分类管理
 * 
 * @author mxl
 * @version $ CategoryController.java v1.0, 2017年5月5日 上午11:38:18 mxl Exp $
 */
@Controller
@RequestMapping("/taskInfo")
public class TaskInfoController extends SuperController {
	
	@Autowired
	private TaskInfoService taskInfoService;
	@RequestMapping("/projectControl")
	public String list(Model model) {
		String projectID1=request.getParameter("projectID");
		Integer projectID=Integer.parseInt(projectID1);
		Integer projectExecutPeriod=taskInfoService.findProjectExecutPeriod(projectID);
		TaskInfoDO taskInfoDO1=new TaskInfoDO();
		taskInfoDO1.setProjectID(projectID);
		taskInfoDO1.setProjectExcitedPeriod(projectExecutPeriod);
		int awaitTaskNumber=taskInfoService.findDefultAwaitTaskNum(taskInfoDO1);
		int executedTaskNumber=taskInfoService.findDefultExecutedTaskNum(taskInfoDO1);
		int executingTaskNumber=taskInfoService.findDefultExecutingTaskNum(taskInfoDO1);
		int allExecutTaskNum=taskInfoService.findDefultAllExecutTaskNum(taskInfoDO1);
		TaskInfoDO taskInfoDO=new TaskInfoDO();
		taskInfoDO.setAwaitTaskNumber(awaitTaskNumber);
		taskInfoDO.setExecutedTaskNumber(executedTaskNumber);
		taskInfoDO.setExecutingTaskNumber(executingTaskNumber);
		taskInfoDO.setAllExecutTaskNum(allExecutTaskNum);
		model.addAttribute("taskInfoDO", taskInfoDO);
		return "/project/projectControl";
	}
	
}

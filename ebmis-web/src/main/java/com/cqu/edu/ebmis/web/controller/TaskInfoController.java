/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
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
	/**
	 * 默认查询的饼图数据
	 */
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
		taskInfoDO.setProjectID(projectID);
		model.addAttribute("taskInfoDO", taskInfoDO);
		return "/project/projectControl";
	}
	/**
	 * 监控查询的饼图数据
	 * @param model
	 * @param taskInfoDO1
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/projectSubmitControl")
	public TaskInfoDO projectEye(Model model,TaskInfoDO taskInfoDO1) {
		try {
			taskInfoDO1.setFinishedTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(taskInfoDO1.getFinishedTime1()));
			taskInfoDO1.setDistributedTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(taskInfoDO1.getDistributedTime1()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int awaitTaskNumber=taskInfoService.findAwaitTaskNum(taskInfoDO1);
		int executedTaskNumber=taskInfoService.findExecutedTaskNum(taskInfoDO1);
		int executingTaskNumber=taskInfoService.findExecutingTaskNum(taskInfoDO1);
		int allExecutTaskNum=taskInfoService.findAllExecutTaskNum(taskInfoDO1);
		TaskInfoDO taskInfoDO=new TaskInfoDO();
		taskInfoDO.setAwaitTaskNumber(awaitTaskNumber);
		taskInfoDO.setExecutedTaskNumber(executedTaskNumber);
		taskInfoDO.setExecutingTaskNumber(executingTaskNumber);
		taskInfoDO.setAllExecutTaskNum(allExecutTaskNum);
		taskInfoDO.setProjectID(taskInfoDO1.getProjectID());
		return taskInfoDO;
	}
	/**
	 * 默认查询柱形数据
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/projectUserTask")
	public List<TaskInfoDO> projectUserTask(Model model) {
		String projectID1=request.getParameter("projectID");
		Integer projectID=Integer.parseInt(projectID1);
		Integer projectExecutPeriod=taskInfoService.findProjectExecutPeriod(projectID);
		TaskInfoDO taskInfoDO=new TaskInfoDO();
		taskInfoDO.setProjectID(projectID);
		taskInfoDO.setProjectExcitedPeriod(projectExecutPeriod);
		List<TaskInfoDO> taskInfoDOList=taskInfoService.findDefultUserTaskNum(taskInfoDO);
		return taskInfoDOList;
	}
	/**
	 * 查询柱形数据
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/projectUserTaskPillar")
	public List<TaskInfoDO> projectUserTaskPillar(Model model,TaskInfoDO taskInfoDO) {
		try {
			taskInfoDO.setFinishedTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(taskInfoDO.getFinishedTime1()));
			taskInfoDO.setDistributedTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(taskInfoDO.getDistributedTime1()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<TaskInfoDO> taskInfoDOList=taskInfoService.findUserTaskNum(taskInfoDO);
		return taskInfoDOList;
	}
	
}

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

import com.cqu.edu.ebmis.domain.TaskInfoDO;
import com.cqu.edu.ebmis.service.TaskInfoService;

/**
 * 三级分类管理
 * 
 * @author mxl
 * @version $ CategoryController.java v1.0, 2017年5月5日 上午11:38:18 mxl Exp $
 */
@Controller
@RequestMapping("/allProjectTask")
public class AllProjectTaskInfoController extends SuperController {
	/**
	 * 默认查询的饼图数据
	 */
	@Autowired
	private TaskInfoService taskInfoService;
	@RequestMapping("/defultProjectTaskInfo")
	public String list(Model model) {
		int awaitTaskNumber=taskInfoService.findDefultAllAwaitTaskNum();
		int executedTaskNumber=taskInfoService.findDefultAllExecutedTaskNum();
		int executingTaskNumber=taskInfoService.findDefultAllExecutingTaskNum();
		int allExecutTaskNum=taskInfoService.findDefultAllProjectExecutTaskNum();
		TaskInfoDO taskInfoDO=new TaskInfoDO();
		taskInfoDO.setAwaitTaskNumber(awaitTaskNumber);
		taskInfoDO.setExecutedTaskNumber(executedTaskNumber);
		taskInfoDO.setExecutingTaskNumber(executingTaskNumber);
		taskInfoDO.setAllExecutTaskNum(allExecutTaskNum);
		model.addAttribute("taskInfoDO", taskInfoDO);
		return "/allProjectTask/projectTaskInfo";
	}
	/**
	 * 监控查询的饼图数据
	 * @param model
	 * @param taskInfoDO1
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/projectTaskInfo")
	public TaskInfoDO projectEye(Model model,TaskInfoDO taskInfoDO1) {
		try {
			taskInfoDO1.setFinishedTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(taskInfoDO1.getFinishedTime1()));
			taskInfoDO1.setDistributedTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(taskInfoDO1.getDistributedTime1()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int awaitTaskNumber=taskInfoService.findAllAwaitTaskNum(taskInfoDO1);
		int executedTaskNumber=taskInfoService.findAllExecutedTaskNum(taskInfoDO1);
		int executingTaskNumber=taskInfoService.findAllExecutingTaskNum(taskInfoDO1);
		int allExecutTaskNum=taskInfoService.findAllProjectExecutTaskNum(taskInfoDO1);
		TaskInfoDO taskInfoDO=new TaskInfoDO();
		taskInfoDO.setAwaitTaskNumber(awaitTaskNumber);
		taskInfoDO.setExecutedTaskNumber(executedTaskNumber);
		taskInfoDO.setExecutingTaskNumber(executingTaskNumber);
		taskInfoDO.setAllExecutTaskNum(allExecutTaskNum);
		return taskInfoDO;
	}
	/**
	 * 默认查询柱形数据
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/defultProjectTaskPillar")
	public List<TaskInfoDO> projectUserTask(Model model) {
		List<TaskInfoDO> taskInfoDOList=taskInfoService.findDefultAllUserTaskNum();
		return taskInfoDOList;
	}
	/**
	 * 查询柱形数据
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/projectTaskPillar")
	public List<TaskInfoDO> projectUserTaskPillar(Model model,TaskInfoDO taskInfoDO) {
		try {
			taskInfoDO.setFinishedTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(taskInfoDO.getFinishedTime1()));
			taskInfoDO.setDistributedTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(taskInfoDO.getDistributedTime1()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<TaskInfoDO> taskInfoDOList=taskInfoService.findAllUserTaskNum(taskInfoDO);
		return taskInfoDOList;
	}
	
}

package com.cqu.edu.ebmis.service;

import java.util.List;

import com.cqu.edu.ebmis.domain.TaskDO;
import com.cqu.edu.ebmis.service.page.Page;

/**
 * 任务管理操作
 * @author xiongyou1701
 *
 */
public interface TaskService {
	/**
	 * 存储操作
	 * 
	 * @param category
	 * @return
	 */
	int save(TaskDO task,List<Integer> projectIds);
	
	/**
	 * 批量插入任务
	 */
	boolean saveBatch(int projectId,String dataObj,List<Integer> projectIds,String filePath);
	
	/**
	 * 删除操作
	 * 
	 * @param code
	 * @return
	 */
	int delete(int code);
	
	/**
	 * 更新操作
	 * 
	 * @param project
	 * @return
	 */
	void update(TaskDO task);
	

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<TaskDO> findAll();
	
	/**
	 * 通过任务Id查找任务
	 * @param taskId
	 * @return
	 */
	TaskDO find(int taskId);
	
	/**
	 * 根据任务的项目Id查找
	 * 
	 * @param projectId
	 * @return
	 */
	List<TaskDO> findByProjectId(int projectId);
	
	/**
	 * 分页查询
	 * 
	 * @param size
	 * @param offset
	 * @return
	 */
	Page<TaskDO> findByPage(int projectId,Page<TaskDO> page);
	
}

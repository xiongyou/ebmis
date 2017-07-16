package com.cqu.edu.ebmis.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cqu.edu.ebmis.domain.TaskDO;

public interface TaskRepository {

	/**
	 * 插入任务
	 * 
	 * @param task
	 * @return
	 * @throws Exception
	 */
	public int insertTask(TaskDO task);

	/**
	 * 查找所有的任务
	 * 
	 * @return
	 */
	public List<TaskDO> findAll();

	/**
	 * 根据TaskID查找(主键)
	 * 
	 * @param productID
	 * @return
	 */
	public TaskDO findById(int taskId);

	/**
	 * 根据任务的项目Id查找
	 * 
	 * @param projectId
	 * @return
	 */
	public List<TaskDO> findTaskByProjectId(int projectId);

	/**
	 * 根据projectId与urlHashForm判断是否重复
	 */
	//public List<Task> findTaskByIdandHashcde(int projectId, int hashcode);

	/**
	 * 找出某一项目id下面所有的hashvalue值
	 */
	//public List<Integer> getExistedHashByPrpjectId(int projectId);

	/**
	 * 更新innerId字段
	 */
	// public boolean updateInnerId();

	/**
	 * 更新任务信息
	 * 
	 * @param product
	 */
	public void updateTask(TaskDO task);
	
	public int deleteTask(int taskId);

	public List<TaskDO> selectByPage(@Param("size") int size,
			@Param("offset") int offset);
	
	public int selectAllCount();
	
	/**
	 * 根据项目ID查找其所有的任务列表，并进行分页
	 * @param projectId
	 * @param size
	 * @param offset
	 * @return
	 */
	public List<TaskDO> selectByPageProject(@Param("projectId")int projectId,@Param("size") int size,
			@Param("offset") int offset);
	
	/**
	 * 根据项目ID查找任务的数量
	 * @param projectId
	 * @return
	 */
	public int selectAllCountProject(@Param("projectId")int projectId);
	
	/**
	 * 查询某一项目下所有任务，得到一个任务中所有的MD5码和关键字
	 */
	public Map<String, String> getTasksByProjectId(int projectId);
	
	/**
	 * 批量插入任务
	 */
	
	public boolean insertTasksBatch(List<TaskDO> tasks);
	
	/**
	 * 批量更新task的关键字
	 */
	public boolean updateKeyWord(List<TaskDO> tasks);
	
	/**
	 * 
	 * 获得多个指定项目下任务 md5码与关键字
	 */
	public HashMap<String, String> getTasksByProjectIds(List<Integer> ids);
	
	
}

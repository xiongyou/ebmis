/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cqu.edu.ebmis.domain.KeyWordDO;

/**
 * 关键字仓储
 * 
 * @author mxl
 * @version $ KeyWordRepository.java v1.0, 2017年5月7日 下午12:24:26 mxl Exp $
 */
public interface KeyWordRepository {
	
	/**
	 * 插入
	 * 
	 * @param keyword
	 * @return
	 */
	int insert(KeyWordDO keyword);
	
	/**
	 * 删除
	 * 
	 * @param categoryCode
	 * @return
	 */
	int deleteByPrimaryKey(long id);
	
	/**
	 * 按主键查找
	 * 
	 * @param categoryCode
	 * @return
	 */
	KeyWordDO selectByPrimaryKey(long id);
	
	/**
	 * 按照关键字名称查找
	 * 
	 * @param name
	 * @return
	 */
	KeyWordDO selectByKeyWord(@Param("keyword") String keyword);
	
	/**
	 * 更新记录
	 * 
	 * @param keyword
	 * @return
	 */
	int update(KeyWordDO keyword);
	
	/**
	 * 查找所有记录
	 * 
	 * @return
	 */
	List<KeyWordDO> selectAllKeyWord();
	
	/**
	 * 根据关键字模糊查找，查询分页
	 * 
	 * @param keyword
	 *            关键字
	 * @param size
	 *            页大小
	 * @param offset
	 *            偏移量
	 * @return
	 */
	List<KeyWordDO> selectByParam(String keyword,int size, int offset);
	
	/**
	 * 查询分页
	 * 
	 * @param size
	 *            页大小
	 * @param offset
	 *            偏移量
	 * @return
	 */
	List<KeyWordDO> selectByPage(int size, int offset);
	
	/**
	 * 
	 * @return
	 */
	int selectCount();
}

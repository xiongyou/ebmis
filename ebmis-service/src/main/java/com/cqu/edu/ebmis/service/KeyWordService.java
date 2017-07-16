/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.service;

import java.util.List;

import com.cqu.edu.ebmis.common.QueryDto;
import com.cqu.edu.ebmis.domain.KeyWordDO;
import com.cqu.edu.ebmis.service.page.Page;

/**
 * 关键字管理服务
 * 
 * @author mxl
 * @version $ KeyWordService.java v1.0, 2017年5月7日 下午12:28:57 mxl Exp $
 */
public interface KeyWordService {
	
	/**
	 * 存储操作
	 * 
	 * @param keyword
	 * @return
	 */
	int save(KeyWordDO keyword);
	
	/**
	 * 删除操作
	 * 
	 * @param id
	 * @return
	 */
	int delete(long id);
	
	/**
	 * 更新操作
	 * 
	 * @param keyword
	 * @return
	 */
	int update(KeyWordDO keyword);
	
	/**
	 * 按照关键字名称查找
	 * 
	 * @param keyword
	 * @return
	 */
	KeyWordDO findByKeyWord(String keyword);
	
	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<KeyWordDO> findAll();
	
	/**
	 * 查询通过ID
	 * 
	 * @param id
	 * @return
	 */
	KeyWordDO findByID(long id);
	
	/**
	 * 根据关键字模糊查找，查询分页
	 * 
	 * @param params[keyword]
	 *            关键字
	 * @param size
	 *            页大小
	 * @param offset
	 *            偏移量
	 * @return
	 */
	Page<KeyWordDO> findByParam(String keyword,Page<KeyWordDO> page);
	
	/**
	 * 分页查询
	 * 
	 * @param size
	 * @param offset
	 * @return
	 */
	Page<KeyWordDO> findByPage(Page<KeyWordDO> page);
	
}

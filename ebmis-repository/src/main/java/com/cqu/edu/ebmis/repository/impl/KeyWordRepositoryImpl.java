/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cqu.edu.ebmis.domain.KeyWordDO;
import com.cqu.edu.ebmis.mapper.KeyWordMapper;
import com.cqu.edu.ebmis.repository.KeyWordRepository;

/**
 * 关键字仓储实现
 * 
 * @author mxl
 * @version $ KeyWordRepositoryImpl.java v1.0, 2017年5月7日 下午12:26:26 mxl Exp $
 */
@Repository
public class KeyWordRepositoryImpl implements KeyWordRepository {
	
	@Autowired
	private KeyWordMapper	keyWordMapper;
	
	/**
	 * @see com.cqu.edu.ebmis.repository.KeyWordRepository#insert(com.cqu.edu.ebmis.domain.KeyWordDO)
	 */
	@Override
	public int insert(KeyWordDO keyword) {
	
		return keyWordMapper.insert(keyword);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.KeyWordRepository#deleteByPrimaryKey(java.lang.String)
	 */
	@Override
	public int deleteByPrimaryKey(long id) {
	
		return keyWordMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.KeyWordRepository#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public KeyWordDO selectByPrimaryKey(long id) {
	
		return keyWordMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.KeyWordRepository#selectByKeyWord(java.lang.String)
	 */
	@Override
	public KeyWordDO selectByKeyWord(String keyword) {
	
		return keyWordMapper.selectByKeyWord(keyword);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.KeyWordRepository#update(com.cqu.edu.ebmis.domain.KeyWordDO)
	 */
	@Override
	public int update(KeyWordDO keyword) {
	
		return keyWordMapper.update(keyword);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.KeyWordRepository#selectAllKeyWord()
	 */
	@Override
	public List<KeyWordDO> selectAllKeyWord() {
	
		return keyWordMapper.selectAllKeyWord();
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.KeyWordRepository#selectByPage(int,
	 *      int)
	 */
	@Override
	public List<KeyWordDO> selectByPage(int size, int offset) {
	
		return keyWordMapper.selectByPage(size , offset);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.KeyWordRepository#selectCount()
	 */
	@Override
	public int selectCount() {
	
		return keyWordMapper.selectAllCount();
	}

	@Override
	public List<KeyWordDO> selectByParam(String keyword, int size, int offset) {
		// TODO Auto-generated method stub
		return keyWordMapper.selectByParam(keyword, size, offset);
	}
	
}

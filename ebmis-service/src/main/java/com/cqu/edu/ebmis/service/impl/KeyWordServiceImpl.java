/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqu.edu.ebmis.common.QueryDto;
import com.cqu.edu.ebmis.domain.KeyWordDO;
import com.cqu.edu.ebmis.repository.KeyWordRepository;
import com.cqu.edu.ebmis.service.KeyWordService;
import com.cqu.edu.ebmis.service.page.Page;

/**
 * 关键字管理服务实现
 * 
 * @author mxl
 * @version $ KeyWordServiceImpl.java v1.0, 2017年5月7日 下午12:30:51 mxl Exp $
 */
@Service
public class KeyWordServiceImpl implements KeyWordService {

	@Autowired
	private KeyWordRepository keyWordRepository;

	/**
	 * @see com.cqu.edu.ebmis.service.KeyWordService#save(com.cqu.edu.ebmis.domain.KeyWordDO)
	 */
	public int save(KeyWordDO keyword) {

		return keyWordRepository.insert(keyword);
	}

	/**
	 * @see com.cqu.edu.ebmis.service.KeyWordService#delete(java.lang.String)
	 */
	public int delete(long id) {

		return keyWordRepository.deleteByPrimaryKey(id);
	}

	/**
	 * @see com.cqu.edu.ebmis.service.KeyWordService#update(com.cqu.edu.ebmis.domain.KeyWordDO)
	 */
	public int update(KeyWordDO keyword) {

		return keyWordRepository.update(keyword);
	}

	/**
	 * @see com.cqu.edu.ebmis.service.KeyWordService#findByKeyWord(java.lang.String)
	 */
	public KeyWordDO findByKeyWord(String keyword) {

		return keyWordRepository.selectByKeyWord(keyword);
	}

	/**
	 * @see com.cqu.edu.ebmis.service.KeyWordService#findAll()
	 */
	public List<KeyWordDO> findAll() {

		return keyWordRepository.selectAllKeyWord();
	}

	/**
	 * @see com.cqu.edu.ebmis.service.KeyWordService#findByID(long)
	 */
	public KeyWordDO findByID(long id) {

		return keyWordRepository.selectByPrimaryKey(id);
	}

	/**
	 * @see com.cqu.edu.ebmis.service.KeyWordService#findByPage(com.cqu.edu.ebmis.service.page.Page)
	 */
	public Page<KeyWordDO> findByPage(Page<KeyWordDO> page) {

		List<KeyWordDO> keyWords = keyWordRepository.selectByPage(page.getLimit(), page.getOffset());
		page.setTotal(keyWordRepository.selectCount());

		page.setRecords(keyWords);
		return page;
	}

	public Page<KeyWordDO> findByParam(String keyword, Page<KeyWordDO> page) {

		if (keyword != null && !keyword.equals("")) {

			List<KeyWordDO> keyWords = keyWordRepository.selectByParam(keyword, page.getLimit(),
					page.getOffset());
			page.setTotal(keyWordRepository.selectCount());

			page.setRecords(keyWords);
			return page;
		} else {
			return this.findByPage(page);
		}

	}

}

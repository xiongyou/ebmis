/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.repository.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cqu.edu.ebmis.domain.ThreeClassificationDo;
import com.cqu.edu.ebmis.mapper.ThreeClassificationMapper;
import com.cqu.edu.ebmis.repository.ThreeClassificationRepository;

/**
 * 产品基本信息仓储实现
 * 
 * @author mxl
 * @version $ ProductBaseInfoRepositoryImpl.java v1.0, 2017年5月5日 下午11:15:06 mxl
 *          Exp $
 */
@Repository
public class ThreeClassificationRepositoryImpl implements ThreeClassificationRepository {
	
	@Autowired
	private ThreeClassificationMapper	threeClassificationMapper;

	@Override
	public List<ThreeClassificationDo> findLevel0() {
		// TODO Auto-generated method stub
		return threeClassificationMapper.findLevel0();
	}

	@Override
	public List<ThreeClassificationDo> findLevel1(String LevelName) {
		// TODO Auto-generated method stub
		return threeClassificationMapper.findLevel1(LevelName);
	}

	@Override
	public List<ThreeClassificationDo> findLevel2(ThreeClassificationDo threeClassificationDo) {
		// TODO Auto-generated method stub
		return threeClassificationMapper.findLevel2(threeClassificationDo);
	}

	@Override
	public List<ThreeClassificationDo> findLevel3(ThreeClassificationDo threeClassificationDo) {
		// TODO Auto-generated method stub
		return threeClassificationMapper.findLevel3(threeClassificationDo);
	}

	@Override
	public List<ThreeClassificationDo> allPlatform() {
		// TODO Auto-generated method stub
		return threeClassificationMapper.allPlatform();
	}

	@Override
	public List<ThreeClassificationDo> getThreeKeyWordDate(int size, int offset, String word, String level2) {
		// TODO Auto-generated method stub
		return threeClassificationMapper.getThreeKeyWordDate(size, offset, word, level2);
	}

	@Override
	public int getThreeKeyWordNum(int size, int offset, String word, String level2) {
		// TODO Auto-generated method stub
		return threeClassificationMapper.getThreeKeyWordNum(size, offset, word, level2);
	}

	@Override
	public List<ThreeClassificationDo> allFindLevel2() {
		// TODO Auto-generated method stub
		return threeClassificationMapper.allFindLevel2();
	}

	@Override
	public void updateThreeKeyWord(HashMap map) {
		// TODO Auto-generated method stub
		threeClassificationMapper.updateThreeKeyWord(map);
	}
	
	
}

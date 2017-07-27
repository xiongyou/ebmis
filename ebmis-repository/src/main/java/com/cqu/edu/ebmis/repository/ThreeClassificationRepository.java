/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.repository;

import java.util.List;

import com.cqu.edu.ebmis.domain.ThreeClassificationDo;


public interface ThreeClassificationRepository {
	
	/**
	 * 零级列表
	 * @return
	 */
	List<ThreeClassificationDo> findLevel0();
	/**
	 * 选择零级的一级列表
	 * @param LevelName
	 * @return
	 */
	List<ThreeClassificationDo> findLevel1(String LevelName);
	/**
	 * 选择零级,一级的二级列表
	 * @param threeClassificationDo
	 * @return
	 */
	List<ThreeClassificationDo> findLevel2(ThreeClassificationDo threeClassificationDo);
	/**
	 * 选择零级,一级,二级的三级列表
	 * @param threeClassificationDo
	 * @return
	 */
	List<ThreeClassificationDo> findLevel3(ThreeClassificationDo threeClassificationDo);
}

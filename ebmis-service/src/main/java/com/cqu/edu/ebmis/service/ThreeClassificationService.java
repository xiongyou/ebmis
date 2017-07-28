/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.service;

import java.util.List;

import com.cqu.edu.ebmis.domain.ThreeClassificationDo;


/**
 * 产品基本信息服务
 * 
 * @author mxl
 * @version $ ProductBaseInfoService.java v1.0, 2017年5月5日 下午11:19:01 mxl Exp $
 */
public interface ThreeClassificationService {
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
	/**
	 * 所有平台
	 * @param threeClassificationDo
	 * @return
	 */
	List<ThreeClassificationDo> allPlatform();
	
}

/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.service;

import java.util.HashMap;
import java.util.List;

import com.cqu.edu.ebmis.domain.CategoryDO;
import com.cqu.edu.ebmis.domain.ThreeClassificationDo;
import com.cqu.edu.ebmis.service.page.Page;


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
	 * 查询所有二级列表
	 * 
	 */
	List<ThreeClassificationDo> allFindLevel2();
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
	/**
	 * 分页三级关键词查询
	 * 
	 * @param size
	 * @param offset
	 * @return
	 */
	Page<ThreeClassificationDo> findThreeKeyWordByPage(Page<ThreeClassificationDo> page,String word,int locFamous,String level2);
	/**
	 * 修改关键词属性
	 * 
	 */
	void updateThreeKeyWord(HashMap map);
	/**
	 * 同步修改关键词属性
	 * 
	 */
	void synchUpdateThreeKeyWord(HashMap map);
	
}

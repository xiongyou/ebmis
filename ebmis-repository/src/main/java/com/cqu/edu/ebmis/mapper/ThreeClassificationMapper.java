/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cqu.edu.ebmis.domain.CategoryDO;
import com.cqu.edu.ebmis.domain.CategoryManagerDO;
import com.cqu.edu.ebmis.domain.ThreeClassificationDo;


public interface ThreeClassificationMapper {
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

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
	List<ThreeClassificationDo> findLevel0();
	List<ThreeClassificationDo> findLevel1(String LevelName);
	List<ThreeClassificationDo> findLevel2(ThreeClassificationDo threeClassificationDo);
	List<ThreeClassificationDo> findLevel3(ThreeClassificationDo threeClassificationDo);
}

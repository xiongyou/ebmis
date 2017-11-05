/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	/**
	 * 查询所有二级列表
	 * 
	 */
	List<ThreeClassificationDo> allFindLevel2();
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
	/**
	 * 查询三级关键词
	 * 
	 */
	List<ThreeClassificationDo> getThreeKeyWordDate(@Param("size") int size,
			@Param("offset") int offset,@Param("locFamous") int locFamous,@Param("word") String word,@Param("level2") String level2);
	/**
	 * 查询三级关键词的数量
	 * 
	 */
	int getThreeKeyWordNum(@Param("size") int size,
			@Param("offset") int offset,@Param("locFamous") int locFamous,@Param("word") String word,@Param("level2") String level2);
}

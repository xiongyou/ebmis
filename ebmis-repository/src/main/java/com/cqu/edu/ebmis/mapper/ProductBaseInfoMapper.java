/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cqu.edu.ebmis.domain.ProductBaseInfoDO;
import com.cqu.edu.ebmis.domain.ThreeClassificationDo;

/**
 * 
 * @author mxl
 * @version $ ProductBaseInfoMapper.java v1.0, 2017年5月5日 下午10:28:01 mxl Exp $
 */
public interface ProductBaseInfoMapper {
	
	int deleteByPrimaryKey(@Param("productInnerId") long productInnerId);
	
	/**
	 * 通过主键查找商品
	 * @param productInnerId
	 * @return
	 */
	ProductBaseInfoDO selectByPrimaryKey(
			@Param("productInnerId") long productInnerId);
	
	/**
	 * 更新商品
	 * @param product
	 * @return
	 */
	int update(ProductBaseInfoDO product);
	
	/**
	 * 查找全部商品
	 * @return
	 */
	List<ProductBaseInfoDO> selectAllProduct();
	
	
	/**
	 * 分页查找全部商品
	 * @param size
	 * @param offset
	 * @return
	 */
	List<ProductBaseInfoDO> selectByPage(@Param("size") int size,
			@Param("offset") int offset);
	/**
	 * 初始搜索查找全部商品
	 * @return
	 */
	List<ProductBaseInfoDO> selectAllSearchProduct(@Param("size") int size,
			@Param("offset") int offset, @Param("word") String word,@Param("checkedNum") int checkedNum);
	/**
	 * 初始搜索查找全部商品的数量
	 * @return
	 */
	int selectAllSearchProductNum(@Param("size") int size,
			@Param("offset") int offset, @Param("word") String word,@Param("checkedNum") int checkedNum);
	/**
	 * 层级分页查找全部商品
	 * @param size
	 * @param offset
	 * @return
	 */
	List<ProductBaseInfoDO> getLevelList(@Param("size") int size,
			@Param("offset") int offset,@Param("platform") String platform,@Param("checkedNum") int checkedNum,@Param("level0") String level0,
			@Param("level1") String level1,@Param("level2") String level2,@Param("level3") String level3);
	/**
	 * 层级查找全部商品的数量
	 * @param size
	 * @param offset
	 * @return
	 */
	int getLevelListNum(@Param("platform") String platform,@Param("checkedNum") int checkedNum,@Param("level0") String level0,
			@Param("level1") String level1,@Param("level2") String level2,@Param("level3") String level3);
	/**
	 * 层级分页搜索查找商品
	 * @param size
	 * @param offset
	 * @return
	 */
	List<ProductBaseInfoDO> getLevelSearchProduct(@Param("size") int size,
			@Param("offset") int offset, @Param("word") String word,@Param("platform") String platform,@Param("checkedNum") int checkedNum,@Param("level0") String level0,
			@Param("level1") String level1,@Param("level2") String level2,@Param("level3") String level3);
	/**
	 * 层级分页搜索查找商品的数量
	 * @param size
	 * @param offset
	 * @return
	 */
	int getLevelSearchProductNum(@Param("word") String word,@Param("platform") String platform,@Param("checkedNum") int checkedNum,@Param("level0") String level0,
			@Param("level1") String level1,@Param("level2") String level2,@Param("level3") String level3);
	
	
	/**
	 * 统计所有商品的数量
	 * @return
	 */
	int selectAllCount();

	/**
	 * 分页查找是否被检查的商品
	 * @param checked
	 * @param size
	 * @param offset
	 * @return
	 */
	List<ProductBaseInfoDO> selectCheckedByPage(@Param("checked") int checked,@Param("size") int size,
			@Param("offset") int offset);
	
	/**
	 * 是否被检查的商品的数量
	 * @param checked
	 * @return
	 */
	int selectCheckedCount(@Param("checked") int checked);
	
	/**
	 * 通过HashMap传递参数
	 * 
	 * @param map
	 *    如:checked  是否已经复核
	 *       isValid  是否为农产品
	 *       platform 平台
	 *       keyword  关键字
	 *       categoryCode 关键字代码， 可能会是一个列表。
	 *       key      可以进行模糊查找的关键字，如productName like "%key%"  、  keyword like  "%key%"
	 *       size     分页大小
	 *       offset   偏移量
	 * @return
	 */
	List<ProductBaseInfoDO> select(HashMap map);
	
	/**
	 * 通过HashMap传递参数
	 * 
	 * @param map
	 *    如:checked  是否已经复核
	 *       isValid  是否为农产品
	 *       platform 平台
	 *       keyword  关键字
	 *       categoryCode 关键字代码， 可能会是一个列表。
	 *       key      可以进行模糊查找的关键字，如productName like "%key%"  、  keyword like  "%key%"
	 * @return
	 */
	int selectCount(HashMap map);
}

/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cqu.edu.ebmis.domain.ProductBaseInfoDO;
import com.cqu.edu.ebmis.domain.ThreeClassificationDo;

/**
 * 产品基本信息仓储
 * 
 * @author mxl
 * @version $ProductBaseInfoRepository.java v1.0, 2017年5月5日 下午11:11:00 mxl Exp $
 */
public interface ProductBaseInfoRepository {
	
	/**
	 * 删除
	 * 
	 * @param productInnerId
	 * @return
	 */
	int deleteByPrimaryKey(long productInnerId);
	
	/**
	 * 按主键查找
	 * 
	 * @param productInnerId
	 * @return
	 */
	ProductBaseInfoDO selectByPrimaryKey(long productInnerId);
	
	/**
	 * 更新记录
	 * 
	 * @param product
	 * @return
	 */
	int update(ProductBaseInfoDO product);
	
	/**
	 * 查找所有记录
	 * 
	 * @return
	 */
	List<ProductBaseInfoDO> selectAllProduct();
	
	/**
	 * 查询分页
	 * 
	 * @param size
	 *            页大小
	 * @param offset
	 *            偏移量
	 * @return
	 */
	List<ProductBaseInfoDO> selectByPage(int size, int offset);
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
	 * 
	 * @return
	 */
	int selectCount();
	
	/**
	 * 根据复核状态进行分页查询
	 * @param checked 是否已复核
	 * @param size 页大小
	 * @param offset 偏移量
	 * @return
	 */
	List<ProductBaseInfoDO> selectCheckedByPage(int checked,int size ,int offset);
	
	int selectCheckedCount(int checked);
	/**
	 * 层级分页查找全部商品
	 * @param size
	 * @param offset
	 * @return
	 */
	List<ProductBaseInfoDO> getLevelList(@Param("size") int size,
			@Param("offset") int offset,@Param("platform") String platform, @Param("checkedNum") int checkedNum,@Param("level0") String level0,
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
}

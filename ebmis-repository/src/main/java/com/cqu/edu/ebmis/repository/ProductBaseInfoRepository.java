/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.repository;

import java.util.List;

import com.cqu.edu.ebmis.domain.ProductBaseInfoDO;

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
}

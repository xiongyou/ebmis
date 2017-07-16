/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cqu.edu.ebmis.domain.ProductBaseInfoDO;
import com.cqu.edu.ebmis.mapper.ProductBaseInfoMapper;
import com.cqu.edu.ebmis.repository.ProductBaseInfoRepository;

/**
 * 产品基本信息仓储实现
 * 
 * @author mxl
 * @version $ ProductBaseInfoRepositoryImpl.java v1.0, 2017年5月5日 下午11:15:06 mxl
 *          Exp $
 */
@Repository
public class ProductBaseInfoRepositoryImpl implements ProductBaseInfoRepository {
	
	@Autowired
	private ProductBaseInfoMapper	productBaseInfoMapper;
	
	/**
	 * @see com.cqu.edu.ebmis.repository.ProductBaseInfoRepository#deleteByPrimaryKey(long)
	 */
	@Override
	public int deleteByPrimaryKey(long productInnerId) {
	
		return productBaseInfoMapper.deleteByPrimaryKey(productInnerId);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.ProductBaseInfoRepository#selectByPrimaryKey(long)
	 */
	@Override
	public ProductBaseInfoDO selectByPrimaryKey(long productInnerId) {
	
		return productBaseInfoMapper.selectByPrimaryKey(productInnerId);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.ProductBaseInfoRepository#update(com.cqu.edu.ebmis.domain.ProductBaseInfoDO)
	 */
	@Override
	public int update(ProductBaseInfoDO product) {
	
		return productBaseInfoMapper.update(product);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.ProductBaseInfoRepository#selectAllProduct()
	 */
	@Override
	public List<ProductBaseInfoDO> selectAllProduct() {
	
		return productBaseInfoMapper.selectAllProduct();
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.ProductBaseInfoRepository#selectByPage(int,
	 *      int)
	 */
	@Override
	public List<ProductBaseInfoDO> selectByPage(int size, int offset) {
	
		return productBaseInfoMapper.selectByPage(size , offset);
	}
	
	/**
	 * @see com.cqu.edu.ebmis.repository.ProductBaseInfoRepository#selectCount()
	 */
	@Override
	public int selectCount() {
	
		return productBaseInfoMapper.selectAllCount();
	}

	@Override
	public List<ProductBaseInfoDO> selectCheckedByPage(int checked, int size, int offset) {
		return productBaseInfoMapper.selectCheckedByPage(checked, size, offset);
	}

	@Override
	public int selectCheckedCount(int checked) {
		return productBaseInfoMapper.selectCheckedCount(checked);
	}
	
	
}

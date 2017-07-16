package com.cqu.edu.ebmis.mapper;

import java.util.HashMap;
import java.util.List;

import com.cqu.edu.ebmis.domain.UrlDO;

public interface UrlMapper {

	/**
	 * 插入一条URL记录
	 * @param url
	 * @return
	 */
	public int insert(UrlDO url);
	
	/**
	 * 批量插入
	 * @param urls
	 * @return
	 */
	public boolean insertUrls(List<UrlDO> urls);
	
	/**
	 * 更新URL记录
	 * @param url
	 * @return
	 */
	int update(UrlDO url);
	
	/**
	 * 批量更新
	 * @param urls
	 * @return
	 */
	public boolean updateUrls(List<UrlDO> urls);

	/**
	 * 获取所有的URL
	 * 
	 * @return
	 */
	public List<UrlDO> getAllUrls();

	/**
	 * 更新所有URL的MD5
	 */
	//public void updateMd5Value();
	
	/**
	 * @param productInnerId
	 * @return
	 */
	public UrlDO findById(int productInnerId);
	
	/**
	 * 查询md5与关键词
	 * @return
	 */
	public HashMap<String, String> getExsitUrls();
	
	/**
	 * 查询md5与productInnerId
	 * @return
	 */
	public HashMap<String, Integer> getProductIds();
	
	/**
	 * 批量地，根据MD5更新url的关键字
	 * @param urls
	 * @return
	 */
	public boolean updateKeyWord(List<UrlDO> urls);
	
	/**
	 * 查找某一个relativeInnerId对应的链接与关键词，用一个数组保存，默认为空
	 * @param relativeInnerId
	 * @return
	 */
	public String[] getInfoByRelativeId(int relativeInnerId);
	

}

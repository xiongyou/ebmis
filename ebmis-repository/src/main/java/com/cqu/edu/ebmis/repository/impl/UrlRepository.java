package com.cqu.edu.ebmis.repository.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.cqu.edu.ebmis.domain.UrlDO;
import com.cqu.edu.ebmis.mapper.UrlMapper;
@Repository
public class UrlRepository implements com.cqu.edu.ebmis.repository.UrlRepository {

	@Resource
	private UrlMapper urlMapper;
	@Override
	public int insert(UrlDO url) {
		return urlMapper.insert(url);
	}

	@Override
	public boolean insertUrls(List<UrlDO> urls) {
		return urlMapper.insertUrls(urls);
	}

	@Override
	public int update(UrlDO url) {
		return urlMapper.update(url);
	}

	@Override
	public boolean updateUrls(List<UrlDO> urls) {
		return urlMapper.updateUrls(urls);
	}

	@Override
	public List<UrlDO> getAllUrls() {
		return urlMapper.getAllUrls();
	}

	@Override
	public UrlDO findById(int productInnerId) {
		return urlMapper.findById(productInnerId);
	}

	@Override
	public HashMap<String, String> getExsitUrls() {
		return urlMapper.getExsitUrls();
	}

	@Override
	public HashMap<String, Integer> getProductIds() {
		return urlMapper.getProductIds();
	}

	@Override
	public boolean updateKeyWord(List<UrlDO> urls) {
		return urlMapper.updateKeyWord(urls);
	}

	@Override
	public String[] getInfoByRelativeId(int relativeInnerId) {
		return urlMapper.getInfoByRelativeId(relativeInnerId);
	}

}

package com.cqu.edu.ebmis.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cqu.edu.ebmis.domain.UrlDO;
import com.cqu.edu.ebmis.handler.MapResultHandler;
import com.cqu.edu.ebmis.mapper.UrlMapper;
@Repository
public class UrlRepository extends SqlSessionDaoSupport implements com.cqu.edu.ebmis.repository.UrlRepository {

	@Resource
	private UrlMapper urlMapper;
	
	@Resource
	     public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
	       super.setSqlSessionFactory(sqlSessionFactory);
	      }


	@Override
	public int insert(UrlDO url) {
		return urlMapper.insert(url);
	}

	@Override
	public boolean insertUrls(List<UrlDO> urls) {
		//对于大数据量，需要分批次执行，每1000个一批。
		int size=urls.size();
		if(size==0)
			return true;
		int count=size/1000 + 1; //循环的次数
		List<UrlDO> tmpUrl=new ArrayList<UrlDO>();
		
		for(int i=0;i<count;i++ ){
			//如果是最后一批，则只统计到列表的大小-1。
			if(i==count-1)
				tmpUrl=urls.subList(i*1000, size-1);
			else
			 tmpUrl=urls.subList(i*1000, (i+1)*1000-1);
			if(!tmpUrl.isEmpty())
				urlMapper.insertUrls(tmpUrl);
		}
		
		return true;
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
	public UrlDO findByMd5(String md5){
		return urlMapper.findByMd5(md5);
	}

	@Override
	public HashMap<String, String> getExsitUrls() {
         
	        int size = 10000;
	        try{
	        	MapResultHandler mrh=new MapResultHandler();
	    		this.getSqlSession().select("getExsitUrls", mrh);
	    		Map map=mrh.getMappedResults();
	    		return (HashMap<String, String>) map;//urlMapper.getExsitUrls();
	            
	        }catch (Exception e){
	            e.printStackTrace();
	            return null;
	        } 
		/*
		MapResultHandler mrh=new MapResultHandler();
		session.select("getExsitUrls", mrh);
		Map map=mrh.getMappedResults();
		return (HashMap<String, String>) map;//urlMapper.getExsitUrls();
		*/
	}

	@Override
	public HashMap<String, Integer> getProductIds() {
		try{
        	MapResultHandler mrh=new MapResultHandler();
    		this.getSqlSession().select("getProductIds", mrh);
    		Map map=mrh.getMappedResults();
    		return (HashMap<String, Integer>) map;//urlMapper.getExsitUrls();
            
        }catch (Exception e){
            e.printStackTrace();
            return null;
        } 
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

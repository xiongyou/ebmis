package com.cqu.edu.ebmis.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqu.edu.ebmis.repository.impl.ReportRepositoryImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
@Service
public class AppTest 
    extends TestCase
{
//	@Resource ReportRepositoryImpl report;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
//    	HashMap map=new HashMap();
//    	map.put("size", 1);
//    	map.put("offset", 10);
//    	List<Map<String, Object>> res=report.getOrignData(map);
//    	System.out.println(res.size());
    }
    
    
    
}

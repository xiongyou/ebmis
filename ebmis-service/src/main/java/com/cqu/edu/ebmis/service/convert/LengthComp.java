package com.cqu.edu.ebmis.service.convert;

import java.util.Comparator;

import com.cqu.edu.ebmis.domain.TaskDO;


/*
 * 实现关键字长度比较的容器,返回最长的关键字
 */
public class LengthComp implements Comparator<Object>{

	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		TaskDO task1 = (TaskDO)o1;
		TaskDO task2 = (TaskDO)o2;
		int a = 0, b = 0;
		if(task1.getKeyword()!=null){
			a = task1.getKeyword().length();
		}
		if(task2.getKeyword()!=null){
			b = task2.getKeyword().length();
		}
		return -(a-b);
	}

}

package com.web.dao;

import java.util.List;
import java.util.Map;

public interface DpObjectDAO {
	int insert(Object obj);
	int insert(Map<String, Object> param);
	int execTotalCount();
	int execTotalCount(String rcate);
	int execTotalCount1(String pcate);
	List<Object> select(int startCount, int endCount); //list
	List<Object> select(int startCount, int endCount, String cate); //list_rcate
	void updateHits(String num);
	Object select(String num);
	int update(Object obj);
	int update(Map<String, Object> param);
	int delete(String num);
	int delete(Map<String, Object> param);
	String selectFile(String id);
	List<Object> select1(int startCount, int endCount, String num);
	List<Object> oplist(String popid);
	
}

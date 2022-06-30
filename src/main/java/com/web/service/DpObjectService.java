package com.web.service;

import java.util.List;

public interface DpObjectService {
	int getInsertResult(Object obj);
	int getListCount();
	List<Object> getListResult(int startCount, int endCount);
	List<Object> getListResult(int startCount, int endCount,String cate);
	void getUpdateHits(String num);
	Object getContent(String num);
	int getUpdateResult(Object obj);
	int getDeleteResult(String num);
	List<Object> getOplist(String popid);
}

package com.web.service;

import java.util.List;

import com.web.vo.DpCommentVO;

public class DpObjectServiceAdapter implements DpObjectService{
	public int getInsertResult(Object obj) {return 0;}
	public int getListCount() {return 0;}
	public List<Object> getListResult(int startCount, int endCount) { return null;}
	public void getUpdateHits(String num) {}
	public Object getContent(String num) { return null;}
	public int getUpdateResult(Object obj) { return 0;}
	public int getDeleteResult(String num) {return 0;}
	public String getFilename(String num) { return "";}
	public List<Object> getListResult(int startCount, int endCount, String cate) {	return null;	}
	public List<DpCommentVO> getListResult(String num){return null;}
	public List<Object> getOplist(String popid) {return null;}
}

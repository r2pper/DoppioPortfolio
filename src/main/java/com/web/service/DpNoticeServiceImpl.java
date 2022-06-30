package com.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.dao.DpNoticeDAO;

import com.web.vo.DpNoticeVO;


public class DpNoticeServiceImpl implements DpNoticeService{
	@Autowired
	private DpNoticeDAO noticeDao;
	
	@Override
	public int getInsertResult(Object obj) {
		DpNoticeVO vo = (DpNoticeVO)obj;
		return noticeDao.insert(vo);
	}
	
	@Override
	public int getListCount() {
		return noticeDao.execTotalCount();
	}
	
	@Override
	public void getUpdateHits(String nnum) {
		noticeDao.updateHits(nnum);
	}
	
	@Override
	public List<Object> getListResult(int startCount, int endCount){
		return noticeDao.select(startCount, endCount);
	}
	
	@Override
	public Object getContent(String nnum) {
		return noticeDao.select(nnum);
	}
	
	@Override
	public int getUpdateResult(Object obj) {
		DpNoticeVO vo = (DpNoticeVO)obj;
		return noticeDao.update(vo);
	}
	
	@Override public int getDeleteResult(String nnum) {
		return noticeDao.delete(nnum);
	}
	
	@Override
	public String getFilename(String nnum) {
		return noticeDao.selectFile(nnum);
	}

	@Override
	public List<Object> getListResult(int startCount, int endCount, String cate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getOplist(String popid) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Object> getListResult(Map<String,Object> param) {
		// TODO Auto-generated method stub
		return noticeDao.selectList(param);
	}
}

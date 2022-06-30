package com.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.dao.DpQnaDAO;
import com.web.vo.DpQnaVO;

public class DpQnaServiceImpl implements DpQnaService{
	@Autowired
	private DpQnaDAO qnaDao;
	
	@Override
	public int getInsertResult(Object obj) {
		DpQnaVO vo = (DpQnaVO)obj;
		return qnaDao.insert(vo);
	}
	
	@Override
	public int getListCount() {
		return qnaDao.execTotalCount();
	}
	
	@Override
	public void getUpdateHits(String qnum) {
		qnaDao.updateHits(qnum);
	}
	
	@Override
	public List<Object> getListResult(int startCount, int endCount){
		return qnaDao.select(startCount, endCount);
	}
	
	@Override
	public Object getContent(String qnum) {
		return qnaDao.select(qnum);
	}
	
	@Override
	public int getUpdateResult(Object obj) {
		DpQnaVO vo = (DpQnaVO)obj;
		return qnaDao.update(vo);
	}
	
	@Override public int getDeleteResult(String qnum) {
		return qnaDao.delete(qnum);
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
		return qnaDao.selectList(param);
	}
}

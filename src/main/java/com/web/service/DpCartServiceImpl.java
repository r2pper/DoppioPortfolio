package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.dao.DpCartDAO;
import com.web.vo.DpCartVO;

public class DpCartServiceImpl implements DpCartService {
	
	@Autowired
	private DpCartDAO cartDAO;
	
	@Override //등록
	public int getInsertResult(Object obj) {
		DpCartVO vo = (DpCartVO)obj;
		return cartDAO.insert(vo);
	}

	@Override
	public int getListCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override	//카트 리스트
	public List<Object> getListResult(int startCount, int endCount) {
		return cartDAO.select(startCount, endCount);
	}

	@Override
	public List<Object> getListResult(int startCount, int endCount, String cate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getUpdateHits(String num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getContent(String num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getUpdateResult(Object obj) {
		// TODO Auto-generated method stub
		DpCartVO vo = (DpCartVO)obj;
		return cartDAO.update(vo);
	}
	
	//장바구니 삭제
	@Override
	public int getDeleteResult(String pnum) {
		return cartDAO.delete(pnum);
	}
	

	@Override
	public String getFilename(String canum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getOplist(String popid) {
		// TODO Auto-generated method stub
		return null;
	}

	}

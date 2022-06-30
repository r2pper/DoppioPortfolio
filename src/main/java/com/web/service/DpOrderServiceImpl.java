package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.dao.DpOrderDAO;
import com.web.vo.DpOrderVO;


public class DpOrderServiceImpl implements DpOrderService {

	@Autowired
	private DpOrderDAO orderDAO;
	
	@Override
	public int getInsertResult(Object obj) {
		DpOrderVO vo = (DpOrderVO)obj;
		return orderDAO.insert(vo);
	}

	@Override
	public int getListCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Object> getListResult(int startCount, int endCount) {
		return orderDAO.select(startCount, endCount);
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
		return 0;
	}

	@Override
	public int getDeleteResult(String num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Object> getOplist(String popid) {
		// TODO Auto-generated method stub
		return null;
	}

}

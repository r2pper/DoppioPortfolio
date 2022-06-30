package com.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.dao.DpBoardDAO;
import com.web.vo.DpBoardVO;

public class DpBoardServiceImpl implements DpBoardService {
	@Autowired
	private DpBoardDAO boardDao;
	
	@Override
	public int getInsertResult(Object obj) {
		DpBoardVO vo = (DpBoardVO)obj;
		return boardDao.insert(vo);
	}
	
	@Override
	public int getListCount() {
		return boardDao.execTotalCount();
	}
	
	@Override
	public void getUpdateHits(String bnum) {
		boardDao.updateHits(bnum);
	}
	
	@Override
	public List<Object> getListResult(int startCount, int endCount){
		return boardDao.select(startCount, endCount);
	}
	
	@Override
	public Object getContent(String bnum) {
		return boardDao.select(bnum);
	}
	
	@Override
	public int getUpdateResult(Object obj) {
		DpBoardVO vo = (DpBoardVO)obj;
		return boardDao.update(vo);
	}
	
	@Override public int getDeleteResult(String bnum) {
		return boardDao.delete(bnum);
	}
	
	@Override
	public String getFilename(String bnum) {
		return boardDao.selectFile(bnum);
	}

	@Override
	public List<Object> getListResult(int startCount, int endCount, String cate) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public List<Object> getListResult(Map<String,Object> param) {
		// TODO Auto-generated method stub
		return boardDao.selectList(param);
	}

	@Override
	public List<Object> getOplist(String popid) {
		// TODO Auto-generated method stub
		return null;
	}
}


package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.dao.DpCommentDAO;
import com.web.vo.DpCommentVO;

public class DpCommentServiceImpl implements DpCommentService {
	@Autowired
	private DpCommentDAO commentDao;
	
	@Override //등록
	public int getInsertResult(Object obj) {
		DpCommentVO vo = (DpCommentVO)obj;
		return commentDao.insert(vo);
	}
	
	
	@Override //수정
	public int getUpdateResult(Object obj) {
		DpCommentVO vo = (DpCommentVO)obj;
		return commentDao.update(vo);
	}
	
	@Override //삭제
	public int getDeleteResult(String cmnum) {
		return commentDao.delete(cmnum);
	}

	@Override //페이지 숫자
	public int getListCount() {
		return commentDao.execTotalCount();
	}

	@Override // 리스트
	public List<Object> getListResult1(int startCount, int endCount, String num){
		return commentDao.select1(startCount, endCount, num);
	}
	
	@Override
	public List<Object> getListResult(int startCount, int endCount, String cate) {
		return null;
	}
	
	@Override
	public void getUpdateHits(String num) {}

	@Override
	public Object getContent(String num) {
		return null;
	}

	@Override
	public List<Object> getListResult(int startCount, int endCount) {
		return null;
	}


	@Override
	public List<Object> getOplist(String popid) {
		// TODO Auto-generated method stub
		return null;
	}
}

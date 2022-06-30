package com.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.vo.DpCommentVO;

public class DpCommentDAO implements DpObjectDAO{
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace="mapper.comment";
	
	//댓글 등록
	@Override
	public int insert(Map<String, Object> param) {
		return sqlSession.insert(namespace+".insert", param);
	}
	
	//댓글 리스트	
	@Override
	public List<Object> select1(int startCount, int endCount, String num) {
		Map param = new HashMap<String, String>();
		param.put("start", startCount);
		param.put("end", endCount);
		param.put("num", num);
		
		return sqlSession.selectList(namespace+".list", param);
	}
	
	//댓글 수정
	@Override
	public int update(Map<String, Object> param) {
		return sqlSession.update(namespace+".update", param);
	}
	
	
	//댓글 삭제
	@Override
	public int delete(Map<String, Object> param) {
		return sqlSession.delete(namespace+".delete", param);
	}
	
	
	//페이지 번호
	@Override
	public int execTotalCount() {
		return sqlSession.selectOne(namespace+".count");
	}
	
	@Override
	public void updateHits(String num) {}
	
	@Override
	public Object select(String num) { return null;}
	
	@Override
	public String selectFile(String id) { return "";}

	@Override
	public List<Object> select(int startCount, int endCount, String rcate) {return null;}

	@Override
	public int execTotalCount(String rcate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int execTotalCount1(String pcate) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public List<Object> select(int startCount, int endCount){
		return null;		
	}

	@Override
	public int insert(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Object> oplist(String popid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

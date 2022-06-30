package com.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class DpOrderDAO implements DpObjectDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace="mapper.order";
	
	public Map<String, Object> select(Map<String, Object> param){
		return sqlSession.selectOne(namespace+"."+param.get("sqlName"), param);
	}
	
	@Override
	public int insert(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int insert(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+"."+param.get("sqlName"), param);
	}
	
	
	@Override
	public int execTotalCount() {
		// TODO Auto-generated method stub
		return 0;
	}

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

	@Override
	public List<Object> select(int startCount, int endCount) {		
		return null;
	}
	
	public List<Map<String, Object>> selectList(String mnum){ //게시글 리스트
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("mnum", mnum);
		return sqlSession.selectList(namespace+".list", param);
	}
	
	public List<Map<String, Object>> selectList2(String mnum){ //게시글 리스트
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("mnum", mnum);
		return sqlSession.selectList(namespace+".adminList", param);
	}
	
	@Override
	public List<Object> select(int startCount, int endCount, String cate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateHits(String num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object select(String num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String selectFile(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> select1(int startCount, int endCount, String num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> oplist(String popid) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

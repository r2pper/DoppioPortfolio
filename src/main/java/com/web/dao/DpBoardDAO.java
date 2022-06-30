package com.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.vo.DpBoardVO;

public class DpBoardDAO implements DpObjectDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace="mapper.board";
	
	public Map<String,Object> select(Map<String,Object> param){
		return sqlSession.selectOne(namespace+"."+param.get("sqlName"), param);
	}
	
	@Override //bs파일
	public String selectFile(String bnum) {
		return sqlSession.selectOne(namespace+".bsfile", bnum);		
	}
	
	@Override //게시글 등록
	public int insert(Object obj) {
		DpBoardVO vo = (DpBoardVO)obj;
		return sqlSession.insert(namespace+".insert", vo);
	}

	@Override //페이징 처리
	public int execTotalCount() {
		return sqlSession.selectOne(namespace+".count");
	}

	@Override //게시글 리스트
	public List<Object> select(int startCount, int endCount) {
		Map param = new HashMap<String, String>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList(namespace+".list", param);
	}

	@Override //조회수 업데이트
	public void updateHits(String bnum) {
		sqlSession.update(namespace+".update_hits", bnum);
		
	}

	@Override //게시글 상세보기
	public Object select(String bnum) {
		return sqlSession.selectOne(namespace+".content", bnum);
	}

	@Override //게시글 수정
	public int update(Object obj) {
		DpBoardVO vo = (DpBoardVO)obj;
		return sqlSession.update(namespace+".update", vo);
	}

	@Override //게시글 삭제
	public int delete(String bnum) {
		return sqlSession.delete(namespace+".delete", bnum);
	}

	public List<Object> selectList(Map<String,Object> param) {
		// TODO Auto-generated method stub
		return  sqlSession.selectList(namespace+".list", param);
	}

	@Override
	public int execTotalCount(String pcate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int execTotalCount1(String pcate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Object> select1(int startCount, int endCount, String num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Object> oplist(String popid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> select(int startCount, int endCount, String cate) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}

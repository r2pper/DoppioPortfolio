package com.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.vo.DpRecipeVO;

public class DpRecipeDAO implements DpObjectDAO{
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace="mapper.recipe";
	
	@Override //rs파일
	public String selectFile(String rnum) {
		return sqlSession.selectOne(namespace+".rsfile", rnum);		
	}
	
	@Override //리스트
	public List<Object> select(int startCount, int endCount, String rcate){
		Map param = new HashMap<String, String>();
		param.put("start", startCount);
		param.put("end", endCount);
		if(rcate != null && rcate !="")
			param.put("rcate", rcate);
		return sqlSession.selectList(namespace+".list", param);
	}
	
	@Override //등록
	public int insert(Object obj) {
		DpRecipeVO vo = (DpRecipeVO)obj;
		return sqlSession.insert(namespace+".insert", vo);
	}
	
	
	@Override //페이지 처리
	public int execTotalCount() {
		return sqlSession.selectOne(namespace+".count");
	}
	
	@Override
	public int execTotalCount(String rcate) {
		return sqlSession.selectOne(namespace+".count",rcate);
	}
	
	@Override //조회수 업데이트
	public void updateHits(String rnum) {
		sqlSession.update(namespace+".update_hits", rnum);
	}
	
	@Override // 레시피 상세보기
	public Object select(String rnum) {
		return sqlSession.selectOne(namespace+".content", rnum);
	}
	
	@Override // 레시피 수정
	public int update(Object obj) {
		DpRecipeVO vo = (DpRecipeVO)obj;
		return sqlSession.update(namespace+".update", vo);
	}
	
	@Override //레시피 삭제
	public int delete(String rnum) {
		return sqlSession.delete(namespace+".delete",rnum);
	}

	@Override
	public List<Object> select(int startCount, int endCount) {
		// TODO Auto-generated method stub
		return null;
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
 
	
	
	
}

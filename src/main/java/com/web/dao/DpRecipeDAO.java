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
	
	@Override //rs����
	public String selectFile(String rnum) {
		return sqlSession.selectOne(namespace+".rsfile", rnum);		
	}
	
	@Override //����Ʈ
	public List<Object> select(int startCount, int endCount, String rcate){
		Map param = new HashMap<String, String>();
		param.put("start", startCount);
		param.put("end", endCount);
		if(rcate != null && rcate !="")
			param.put("rcate", rcate);
		return sqlSession.selectList(namespace+".list", param);
	}
	
	@Override //���
	public int insert(Object obj) {
		DpRecipeVO vo = (DpRecipeVO)obj;
		return sqlSession.insert(namespace+".insert", vo);
	}
	
	
	@Override //������ ó��
	public int execTotalCount() {
		return sqlSession.selectOne(namespace+".count");
	}
	
	@Override
	public int execTotalCount(String rcate) {
		return sqlSession.selectOne(namespace+".count",rcate);
	}
	
	@Override //��ȸ�� ������Ʈ
	public void updateHits(String rnum) {
		sqlSession.update(namespace+".update_hits", rnum);
	}
	
	@Override // ������ �󼼺���
	public Object select(String rnum) {
		return sqlSession.selectOne(namespace+".content", rnum);
	}
	
	@Override // ������ ����
	public int update(Object obj) {
		DpRecipeVO vo = (DpRecipeVO)obj;
		return sqlSession.update(namespace+".update", vo);
	}
	
	@Override //������ ����
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

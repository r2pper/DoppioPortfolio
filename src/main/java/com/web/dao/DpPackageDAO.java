package com.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.vo.DpPackageVO;

public class DpPackageDAO implements DpObjectDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace="mapper.package";

	@Override //ps����
	public String selectFile(String pnum) {
		return sqlSession.selectOne(namespace+".psfile", pnum);		
	}
	
	@Override //�Ǹű� ���
	public int insert(Object obj) {
		DpPackageVO vo = (DpPackageVO)obj;
		return sqlSession.insert(namespace+".insert", vo);
	}

	@Override //����¡ ó��
	public int execTotalCount() {
		return sqlSession.selectOne(namespace+".count");
	}

	@Override 
	public List<Object> select(int startCount, int endCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override //��ȸ�� ������Ʈ
	public void updateHits(String pnum) {
		sqlSession.update(namespace+".update_hits", pnum);
		
	}

	@Override //�Ǹű� �󼼺���
	public Object select(String pnum) {
		return sqlSession.selectOne(namespace+".content", pnum);
	}

	@Override //�Ǹű� ����
	public int update(Object obj) {
		DpPackageVO vo = (DpPackageVO)obj;
		return sqlSession.update(namespace+".update", vo);
	}

	@Override //�Ǹű� ����
	public int delete(String pnum) {
		return sqlSession.delete(namespace+".delete", pnum);
	}

	@Override //����Ʈ
	public List<Object> select(int startCount, int endCount, String pcate){
		Map param = new HashMap<String, String>();
		param.put("start", startCount);
		param.put("end", endCount);
		if(pcate != null && pcate !="")
			param.put("pcate", pcate);
		return sqlSession.selectList(namespace+".list", param);
	}

	@Override
	public int execTotalCount(String pcate) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".count",pcate);
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
		return sqlSession.selectList(namespace+".oplist", popid);
	}
}

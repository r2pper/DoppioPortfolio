package com.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.vo.DpBoardVO;
import com.web.vo.DpNoticeVO;



public class DpNoticeDAO implements DpObjectDAO{
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace="mapper.notice";
	
	@Override //ns����
	public String selectFile(String nnum) {
		return sqlSession.selectOne(namespace+".nsfile", nnum);		
	}
	
	@Override //�Խñ� ���
	public int insert(Object obj) {
		DpNoticeVO vo = (DpNoticeVO)obj;
		return sqlSession.insert(namespace+".insert", vo);
	}

	@Override //����¡ ó��
	public int execTotalCount() {
		return sqlSession.selectOne(namespace+".count");
	}

	@Override //�Խñ� ����Ʈ
	public List<Object> select(int startCount, int endCount) {
		Map param = new HashMap<String, String>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList(namespace+".list", param);
	}
	public List<Object> selectList(Map<String,Object> param) {
		// TODO Auto-generated method stub
		return  sqlSession.selectList(namespace+".list", param);
	}

	@Override //��ȸ�� ������Ʈ
	public void updateHits(String nnum) {
		sqlSession.update(namespace+".update_hits", nnum);
		
	}

	@Override //�Խñ� �󼼺���
	public Object select(String nnum) {
		return sqlSession.selectOne(namespace+".content", nnum);
	}

	@Override //�Խñ� ����
	public int update(Object obj) {
		DpNoticeVO vo = (DpNoticeVO)obj;
		return sqlSession.update(namespace+".update", vo);
	}

	@Override //�Խñ� ����
	public int delete(String nnum) {
		return sqlSession.delete(namespace+".delete", nnum);
	}

	@Override
	public List<Object> select(int startCount, int endCount, String cate) {
		// TODO Auto-generated method stub
		return null;
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
}

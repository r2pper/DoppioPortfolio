package com.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.vo.DpMemberVO;

public class DpMemberDAO implements DpObjectDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace = "mapper.member";
	
	/**
	 * 비밀번호 찾기
	 */
	public List<Object> find_pass(String id, String name, String hp, String email) throws Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("name", name);
		param.put("hp", hp);
		param.put("email", email);
		return sqlSession.selectList(namespace+".find_pass", param);
	}
	
	/**
	 * 아이디 찾기
	 */
	public List<Object> find_id(String name, String hp) throws Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", name);
		param.put("hp", hp);
		return sqlSession.selectList(namespace+".find_id", param);
	}
	
	/**
	 * 회원가입 - INSERT
	 */
	@Override
	public int insert(Object obj) {
		DpMemberVO vo = (DpMemberVO)obj;
		return sqlSession.insert(namespace+".insert", vo);
	}
	/**
	 * 회원가입시 장바구니 추가
	 */
	
	public int insertCart(Map<String, Object> param) {
		
		System.out.println("createCart param ----->" + param);
		
		return sqlSession.insert(namespace+".createCart", param);
	}
	/**
	 * 회원가입시 아이디 중복 체크
	 */
	public int idCheck(String id) {
		return sqlSession.selectOne(namespace+".id_check", id);
	}

	/**
	 * 로그인 - select(DpMemberVO vo)
	 */

	public Map<String,Object> select(DpMemberVO vo) {
		return sqlSession.selectOne(namespace+".login", vo);
	}
	
	/**
	 * 페이징 처리
	 */
	public int execTotalCount() { 
		return sqlSession.selectOne(namespace+".count");
	}
	
	/**
	 * 회원 탈퇴 신청/취소
	 */
	public int updateJoinStatus(String mnum, String status) {
		int result = 0;
		int value = Integer.parseInt(status);
		if(value==0) {
			//신청
			result = sqlSession.update(namespace+".status1", mnum);			
		}else {
			//취소
			result = sqlSession.update(namespace+".status2", mnum);
		}
		return result;
	}
	
	/**	 *  회원 전체 리스트 + (페이징처리)	 */
	@Override
	public List<Object> select(int startCount, int endCount){ 
		Map param = new HashMap<String, String>();
		param.put("start", startCount);
		param.put("end", endCount);
		
		return sqlSession.selectList(namespace+".list", param);
	}
	
	
	/**
	 * 회원 상세 정보
	 */
	@Override
	public Object select(String mnum) { 
		
		return sqlSession.selectOne(namespace+".content", mnum);
	}
	
	/**
	 * 회원정보 수정
	 */
	@Override
	public int update(Object obj){ 
		DpMemberVO vo = (DpMemberVO)obj;
		return sqlSession.update(namespace+".update", vo);
	}
	
	
	@Override
	public void updateHits(String num) {}	
	
	
	@Override
	public int delete(String num) {return 0;}
	
	@Override
	public String selectFile(String id) { return "";}
	@Override
	public List<Object> select(int startCount, int endCount, String cate) {
		// TODO Auto-generated method stub
		return null;
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
		return sqlSession.update(namespace+"."+param.get("mapperName"), param);
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

package com.web.service;

import java.util.Map;

import com.web.vo.DpMemberVO;

public interface DpMemberService extends DpObjectService{
	//int getInsertResult(DpMemberVO vo); //회원가입
	Map<String, Object> getLoginResult(DpMemberVO vo); //로그인
	int getIdCheckResult(String id); //회원가입-아이디 중복체크
	int getStatusUpdate(String mnum, String status); 
}

package com.web.service;

import java.util.Map;

import com.web.vo.DpMemberVO;

public interface DpMemberService extends DpObjectService{
	//int getInsertResult(DpMemberVO vo); //ȸ������
	Map<String, Object> getLoginResult(DpMemberVO vo); //�α���
	int getIdCheckResult(String id); //ȸ������-���̵� �ߺ�üũ
	int getStatusUpdate(String mnum, String status); 
}

package com.web.service;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.dao.DpMemberDAO;
import com.web.vo.DpMemberVO;

public class DpMemberServiceImpl extends DpObjectServiceAdapter implements DpMemberService{
	@Autowired
	private DpMemberDAO memberDao;
	
	@Override	// ȸ������
	public int getInsertResult(Object obj) {
		DpMemberVO vo = (DpMemberVO)obj;
		return memberDao.insert(vo);
	}
	
	@Override // ȸ�����Խ� ���̵� �ߺ�üũ
	public int getIdCheckResult(String id) {
		return memberDao.idCheck(id);
	}
	
	@Override	//�α���
	public Map<String,Object> getLoginResult(DpMemberVO vo) {
		System.out.println("getLoginResult ------> " +  memberDao.select(vo));
		return memberDao.select(vo);
	}
	
	@Override //ȸ�� Ż�� ��û ����
	public int getStatusUpdate(String mnum, String status) {
		return memberDao.updateJoinStatus(mnum, status);
	}
	
	@Override //ȸ�� ��������
	public Object getContent(String mnum) {
		return memberDao.select(mnum);
	}
	
	@Override //ȸ������Ʈ ��������ȣ
	public int getListCount() {
		return memberDao.execTotalCount();
	}
	
	@Override //ȸ�� ����Ʈ
	public List<Object> getListResult(int startCount, int endCount){
		List<Object> olist = memberDao.select(startCount, endCount);
		List<DpMemberVO> list = new ArrayList<DpMemberVO>();
		for(Object obj : olist) {
			list.add((DpMemberVO)obj);
		}
		return memberDao.select(startCount, endCount);
	}
	
	@Override
	public int getUpdateResult(Object obj) {
		DpMemberVO vo = (DpMemberVO)obj;
		return memberDao.update(vo);
	}
	
	//���̵� ã��
	public List<Object> find_id(HttpServletResponse response, String name, String hp) throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<Object> id = memberDao.find_id(name, hp);
		
		if (id.isEmpty()) {
			out.println("<script>");
			out.println("alert('���Ե� ���̵� �����ϴ�. �ٽ� Ȯ�����ּ���');");
			out.println("location.assign('/doppio/login/doppio_find_id.th')");
			out.println("</script>");
			out.close();
			return null;
		} else {
			return id;
		}
	}
	
	//��й�ȣ ã��
	public List<Object> find_pass(HttpServletResponse response,String id, String name, String hp, String email) throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<Object> pass = memberDao.find_pass(id,name, hp,email);
		
		if (pass.isEmpty()) {
			out.println("<script>");
			out.println("alert('���Ե� ������ �����ϴ�. �ٽ� Ȯ�����ּ���');");
			out.println("location.assign('/doppio/login/doppio_find_pass.th')");
			out.println("</script>");
			out.close();
			return null;
		} else {
			return pass;
		}
	}
	
	
	
}

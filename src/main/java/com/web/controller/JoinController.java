package com.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.dao.DpMemberDAO;
import com.web.service.DpMemberServiceImpl;
import com.web.vo.DpMemberVO;

@Controller
public class JoinController {
	
	@Autowired
	private DpMemberServiceImpl memberService;
	
	@Autowired
	private DpMemberDAO memberDao;
	
	/**
	 * ȸ������ ȭ�� 
	 */
	@RequestMapping(value = "/join/doppio_join.th", method = RequestMethod.GET)
	public String doppio_join() {
		return "/join/doppio_join";
	}
	
	/**
	 * ȸ������ ó��
	 */
	@RequestMapping(value="/join/doppio_join.th", method = RequestMethod.POST)
	public ModelAndView Join(DpMemberVO vo) {
		ModelAndView mv = new ModelAndView();
		
		//Map<String,Object> mnum = new HashMap<String,Object>();
		
		int result = memberService.getInsertResult(vo);
		Map<String,Object> mnum = memberService.getLoginResult(vo);
			
		if(result < 1) {
			
			mv.addObject("err","ȸ������ ��������!!!");
			return mv;
		}else {
			
			int	res = memberDao.insertCart(mnum);
			if(res < 1) {
				mv.addObject("err","��ٱ��� ��������!!!");
				return mv;	
			}
		}
		
		mv.addObject("join_result","succ");
		mv.setViewName("/login/doppio_login");
		
		
		return mv;
	
	}	
	
	/**
	 * ���̵� �ߺ�üũ ó��
	 */
	@ResponseBody
	@RequestMapping(value="/join/idCheck.th", method=RequestMethod.GET)
	public String idCheck(String id) {
		int result = memberService.getIdCheckResult(id);
		
		return String.valueOf(result);
	}
	
		
		
		
}

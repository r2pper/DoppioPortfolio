package com.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.web.service.DpMemberServiceImpl;
import com.web.vo.DpMemberVO;

@Controller
public class LoginController {
	
	@Autowired
	private DpMemberServiceImpl memberService;
	
	/**
	 * 비밀번호 찾기
	 */	
	@RequestMapping(value = "/login/doppio_find_pass.th", method = RequestMethod.GET)
	public String find_pass() throws Exception{
		return "/login/doppio_find_pass";    
	}
	
	/**
	 * 비밀번호 찾기 결과
	 */
	@RequestMapping(value = "/login/doppio_find_pass_result.th", method = RequestMethod.POST)
	public String find_pass(HttpServletResponse response, 
			@RequestParam("id") String id, @RequestParam("name") String name, 
			@RequestParam("hp") String hp, @RequestParam("email") String email, Model md) throws Exception{
		md.addAttribute("pass", memberService.find_pass(response, id, name, hp, email));
		
		return "/login/doppio_find_pass_result";    
	}
	
	/**
	 * 아이디 찾기
	 */	
	@RequestMapping(value = "/login/doppio_find_id.th", method = RequestMethod.GET)
	public String find_id() throws Exception{
		return "/login/doppio_find_id";    
	}
	
	/**
	 * 아이디 찾기 결과
	 */
	@RequestMapping(value = "/login/doppio_find_id_result.th", method = RequestMethod.POST)
	public String find_id(HttpServletResponse response, @RequestParam("name") String name, @RequestParam("hp") String hp, Model md) throws Exception{
		md.addAttribute("id", memberService.find_id(response, name, hp));
		
		return "/login/doppio_find_id_result";    
	}
	
	/**
	 * 아이디 비밀번호 찾기
	 */	
	@RequestMapping(value = "/login/doppio_find.th", method = RequestMethod.GET)
	public String login_find() throws Exception{
		return "/login/doppio_find";    
	}
	
	/**
	 * 로그인 화면
	 */	
	@RequestMapping(value = "/login/doppio_login.th", method = RequestMethod.GET)
	public ModelAndView doppio_login(String auth_result) {
		ModelAndView mv = new ModelAndView("/login/doppio_login");
		mv.addObject("auth_result", auth_result);
		return mv;    
	}
	
	
	/**
	 * 로그인 처리
	 */
	@RequestMapping(value="/login/doppio_login.th", method=RequestMethod.POST)
	public ModelAndView login(DpMemberVO vo, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Map<String,Object> result = new HashMap<String,Object>();
		result = memberService.getLoginResult(vo);
		
		if(result !=null) {
			System.out.println("result.size() > 0");
			
			if(String.valueOf(result.get("JOIN_STATUS")).equals("0")) {

				System.out.println("joins status 0");
				
				mv.addObject("login_result", "succ");
				mv.setViewName("/doppio_main");
				session.setAttribute("sid",vo.getId());
				session.setAttribute("mnum", result.get("MNUM"));

			}else if(String.valueOf(result.get("JOIN_STATUS")).equals("1")) {
				
				System.out.println("joins status 1");
				
				mv.addObject("login_result", "drop");
				mv.setViewName("/login/doppio_login");
			}
		}else{

			System.out.println("result.size() < 0");			
			
			mv.addObject("login_result","fail");
			mv.setViewName("/login/doppio_login");
				
//			mv.addObject("login_result", "succ");
//			mv.setViewName("doppio_main");
		}
		return mv;
	}
	
	/**
	 * 로그아웃 처리
	 */
	@RequestMapping(value="/login/doppio_logout.th", method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String sid = (String)session.getAttribute("sid");
		
		if(sid != null) {
			session.invalidate();
			mv.addObject("sid", sid);
			mv.addObject("logout_result", "succ");
		}
		mv.setViewName("/doppio_main");
		
		return mv;
	}
	
	
	
	
	
	
	
}

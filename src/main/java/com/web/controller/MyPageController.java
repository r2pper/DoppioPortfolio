package com.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.dao.DpCartDAO;
import com.web.dao.DpMemberDAO;
import com.web.dao.DpOrderDAO;
import com.web.service.DpCartServiceImpl;
import com.web.service.DpMemberServiceImpl;
import com.web.service.DpOrderServiceImpl;
import com.web.service.DpPageServiceImpl;
import com.web.vo.DpCartVO;
import com.web.vo.DpMemberVO;

@Controller
public class MyPageController {
	
	@Autowired
	private DpMemberServiceImpl memberService;
	
	@Autowired
	private DpCartServiceImpl cartService;
	
	@Autowired
	private DpPageServiceImpl pageService;
	
	@Autowired
	private DpMemberDAO memberDao;
	
	@Autowired
	private DpOrderDAO orderDao;
	
	@Autowired
	private DpCartDAO cartDao;
	
	@Autowired
	private DpOrderServiceImpl orderService;
	
	//회원 탈퇴 신청
	@ResponseBody
	@RequestMapping(value="/mypage/doppio_mypage_info_out.th", method=RequestMethod.POST)
	public Map<String,Object> join_status(@RequestBody String vo) throws JsonParseException, JsonMappingException, IOException {

		Map<String,Object> rMap = new HashMap<String,Object>();
		//ModelAndView mv = new ModelAndView();

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> param = mapper.readValue(vo, Map.class);
		
		System.out.println("out param ----> " + param);
		
		if(param.get("service").equals("infoOut")){
			param.put("mapperName","status1");						
		}else {
			param.put("mapperName","status2");
		}
		
		
		int s = memberDao.update(param);

		System.out.println("s ------->" +s);
		
		 if (s >= 1) {
			 
			 rMap.put("res", "success");
			  
		 }else {
			 
			 rMap.put("res", "fail");
		 }
		 
		 		
		
		return rMap;
	}
	
	
	//회원수정 페이지 폼
	@RequestMapping(value = "/mypage/doppio_mypage_info.th", method = RequestMethod.GET)
	public ModelAndView doppio_mypage_info(String mnum) {/* String mnum */
		ModelAndView mv = new ModelAndView();
		DpMemberVO vo = (DpMemberVO)memberService.getContent(mnum); //mnum기준

		mv.addObject("vo",vo);
		mv.setViewName("/mypage/doppio_mypage_info");
		return mv;
	}
	
	//회원수정 페이지 처리
	@RequestMapping(value = "/mypage/doppio_mypage_info.th", method = RequestMethod.POST)
	public ModelAndView doppio_mypage_info(DpMemberVO vo, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = memberService.getUpdateResult(vo);
		
		if(result ==1) {
			mv.setViewName("redirect:/doppio_main.th");
		}else {
			//에러페이지 호출
		}

		return mv;
	}
	
	
	

	
	/*
	 * 		장바구니 리스트 
	 * */
	
	@RequestMapping(value="/mypage/doppio_mypage_basket.th", method=RequestMethod.GET)
		public ModelAndView cart_list(String mnum) {
			ModelAndView mv = new ModelAndView();
			
			List<Map<String, Object>> vo = cartDao.selectList(mnum);
			ArrayList<DpCartVO> list = new ArrayList<DpCartVO>();
			for(Object obj : vo) {
				list.add((DpCartVO)obj);
			}
			mv.addObject("list", list);
			mv.addObject("vo", vo);			
			mv.setViewName("/mypage/doppio_mypage_basket");
			return mv;
	}
	
	
	/* 장바구니 삭제 */
	@ResponseBody
	@RequestMapping(value = "/mypage/doppio_mypage_basketDelete.th", method = RequestMethod.POST)
	public Map<String, Object> cart_delete(@RequestParam(value="list[]") List<String> list,HttpSession session) {
	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mnum", session.getAttribute("mnum"));
		map.put("sqlName", "selectCanum");
		String canum = String.valueOf(cartDao.select(map).get("CANUM"));
		map.put("sqlName", "delete");
		map.put("canum", canum);
	
		int lmap = 0;
		for(String pnum : list) {
			map.put("pnum", pnum);
			lmap = cartDao.delete(map);
			if(lmap < 1 ) {
				map.put("result", "fail");
				//어떤 canum에서 오류났는지
				map.put("failpnum", pnum);
				return map;
			}else{
				map.put("result", "ok");
			}
		}
		return map;
	}
	
	//주문번호 생성
	@ResponseBody
	@RequestMapping(value = "/mypage/doppio_mypage_basket_or.th", method=RequestMethod.POST)
	public Map<String,Object> cart_order_update(@RequestParam(value="list[]") List<String> list, HttpSession session){
		
		ModelAndView mv = new  ModelAndView();
		Map<String,Object> map = new HashMap<String,Object>();
		map.clear();
		map.put("sqlName", "selectOnum");
		String onum = "o_"+String.valueOf(orderDao.select(map).get("ONUM")); 
		//----------주문번호 생성 select
		
		map.put("sqlName", "insert");
		map.put("onum", onum);
		map.put("mnum", session.getAttribute("mnum"));
		
		int or = orderDao.insert(map);
		
		if(or<1) {
			//오류났을때
			System.out.println("insert 오류!!");
		}
		
		map.put("sqlName", "selectCanum");
		String canum = String.valueOf(cartDao.select(map).get("CANUM"));
		
		map.put("canum", canum);
		map.put("sqlName", "update");
		for(String pnum: list) {
			map.put("pnum", pnum);
			int up = cartDao.update(map);
			if(up<1) {
				//오류났을때
				System.out.println("update 오류!!");
				map.put("res","fail");
				return map;
			}
		}	
		
		map.put("res", "ok");
		
		return map;
	}
		
	
	
	
	
//	
//	//주문 내역 넘기기
//	@ResponseBody
//	@RequestMapping(value="/mypage/doppio_mypage_basket_or.th", method=RequestMethod.POST)
//	public Map<String, Object> add_order(@RequestParam(value="list[]") List<String> list){		
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		int lmap = 0;
//		for(String mnum : list) {
//			lmap = orderDao.insert(mnum);
//			if(lmap < 1 ) {
//				map.put("result", "fail");
//				//어떤 canum에서 오류났는지
//				map.put("failMnum", mnum);
//				return map;
//			}else{
//				map.put("result", "ok");
//			}
//		}
//		
//		
//		return map;
//		
//	}
//	
	/* error */
	@RequestMapping(value = "/doppio_error.th", method = RequestMethod.GET)
	public String doppio_error() {
		return "/doppio_error"; 
	}
}

package com.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.dao.DpOrderDAO;
import com.web.service.DpOrderServiceImpl;
import com.web.service.DpPageServiceImpl;
import com.web.vo.DpCartVO;
import com.web.vo.DpOrderVO;

@Controller
public class orderController {
	
	@Autowired
	private DpOrderDAO orderDao;
	
	@Autowired
	private DpPageServiceImpl pageService;
	
	@Autowired
	private DpOrderServiceImpl orderService;
	
	
	
	
	
	//주문 내역
	@RequestMapping(value="/mypage/doppio_mypage_order_history.th", method=RequestMethod.GET)
	public ModelAndView order_list(String mnum) {
		ModelAndView mv = new ModelAndView();
		List<Map<String, Object>> vo = orderDao.selectList(mnum);
		ArrayList<DpOrderVO> list = new ArrayList<DpOrderVO>();
		for(Object obj : vo) {
			list.add((DpOrderVO)obj);
		}
		mv.addObject("list", list);
		mv.addObject("vo", vo);			
		mv.setViewName("/mypage/doppio_mypage_order_history");
		return mv;
	}	
		
}

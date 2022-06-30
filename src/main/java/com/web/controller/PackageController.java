package com.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.dao.DpCartDAO;
import com.web.service.DpCartServiceImpl;
import com.web.service.DpMemberServiceImpl;
import com.web.service.DpPackageServiceImpl;
import com.web.service.DpPageServiceImpl;
import com.web.vo.DpPackageOptionVO;
import com.web.vo.DpPackageVO;

@Controller
public class PackageController {
	
	@Autowired
	private DpPageServiceImpl pageService;
	
	@Autowired
	private DpPackageServiceImpl packageService;
	
	@Autowired
	private DpCartServiceImpl cartService;
	
	@Autowired
	private DpMemberServiceImpl memberService;
	
	@Autowired
	private DpCartDAO cartDao;
	
	/*
	 * 		package_list_de
	 * */
	
	@RequestMapping(value="/package/package_list_de.th", method=RequestMethod.GET)
		public ModelAndView package_list_de(String rpage) {
			ModelAndView mv = new ModelAndView();
			Map<String, String> param = pageService.getPageResult2(rpage, "package_de", packageService);
			
			int startCount = Integer.parseInt(param.get("start"));
			int endCount = Integer.parseInt(param.get("end"));
			
			List<Object> olist = packageService.getListResult(startCount, endCount, "de");
			ArrayList<DpPackageVO> list = new ArrayList<DpPackageVO>();
			
			for(Object obj : olist) {
				list.add((DpPackageVO)obj);
			}
			mv.addObject("list", list);
			mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
			mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
			mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));
			
			mv.setViewName("/package/package_list_de");
			return mv;
	}
	
	/*
	 * 		package_list_cf
	 * */
	
	@RequestMapping(value="/package/package_list_cf.th", method=RequestMethod.GET)
		public ModelAndView package_list_cf(String rpage) {
			ModelAndView mv = new ModelAndView();
			Map<String, String> param = pageService.getPageResult2(rpage, "package_cf", packageService);
			
			int startCount = Integer.parseInt(param.get("start"));
			int endCount = Integer.parseInt(param.get("end"));
			
			List<Object> olist = packageService.getListResult(startCount, endCount, "cf");
			ArrayList<DpPackageVO> list = new ArrayList<DpPackageVO>();
			
			for(Object obj : olist) {
				list.add((DpPackageVO)obj);
			}
			mv.addObject("list", list);
			mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
			mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
			mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));
			
			mv.setViewName("/package/package_list_cf");
			return mv;
	}
	
	/*
	 * 		package_list_ncf
	 * */
	
	@RequestMapping(value="/package/package_list_ncf.th", method=RequestMethod.GET)
		public ModelAndView package_list_ncf(String rpage) {
			ModelAndView mv = new ModelAndView();
			Map<String, String> param = pageService.getPageResult2(rpage, "package_ncf", packageService);
			
			int startCount = Integer.parseInt(param.get("start"));
			int endCount = Integer.parseInt(param.get("end"));
			
			List<Object> olist = packageService.getListResult(startCount, endCount, "ncf");
			ArrayList<DpPackageVO> list = new ArrayList<DpPackageVO>();
			
			for(Object obj : olist) {
				list.add((DpPackageVO)obj);
			}
			mv.addObject("list", list);
			mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
			mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
			mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));
			
			mv.setViewName("/package/package_list_ncf");
			return mv;
	}
	
	/*
	 * 		package_content_de
	 * */
	
	@RequestMapping(value="/package/package_content_de.th", method=RequestMethod.GET)
		public ModelAndView package_content_de(String pnum, String popid, String rno) {
		
			ModelAndView mv = new ModelAndView();
			packageService.getUpdateHits(pnum);
			DpPackageVO vo = (DpPackageVO)packageService.getContent(pnum);
			
			List<Object> olist = packageService.getOplist(popid);
			ArrayList<DpPackageOptionVO> list = new ArrayList<DpPackageOptionVO>();
			for(Object obj : olist){
			//System.out.println(vo.getPopid());
			  list.add((DpPackageOptionVO)obj);

			}
			
			for(DpPackageOptionVO vo1:list){
				   System.out.println(vo1.getPopid()); 
			}

			mv.addObject("list", list);
			mv.addObject("popid", popid);
			mv.addObject("pnum", pnum);
			mv.addObject("vo", vo);
			mv.addObject("rno", rno);
			mv.setViewName("/package/package_content_de");
			
			return mv;
	}
	
	/*
	 * 		package_content_cf 상세보기
	 * */
	
	@RequestMapping(value="/package/package_content_cf.th", method=RequestMethod.GET)
	public ModelAndView package_content_cf(String pnum, String popid, String rno) {
	
		ModelAndView mv = new ModelAndView();
		packageService.getUpdateHits(pnum);
		DpPackageVO vo = (DpPackageVO)packageService.getContent(pnum);
		
		List<Object> olist = packageService.getOplist(popid);
		ArrayList<DpPackageOptionVO> list = new ArrayList<DpPackageOptionVO>();
		for(Object obj : olist){
		//System.out.println(vo.getPopid());
		  list.add((DpPackageOptionVO)obj);

		}
		
		mv.addObject("list", list);
		mv.addObject("popid", popid);
		mv.addObject("pnum", pnum);
		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		mv.setViewName("/package/package_content_cf");
		
		return mv;
		}
	
	/*
	 * 		package_content_ncf 상세보기
	 * */
	
	@RequestMapping(value="/package/package_content_ncf.th", method=RequestMethod.GET)
		public ModelAndView package_content_ncf(String pnum, String popid, String rno) {
			
			ModelAndView mv = new ModelAndView();
			packageService.getUpdateHits(pnum);
			DpPackageVO vo = (DpPackageVO)packageService.getContent(pnum);
			
			List<Object> olist = packageService.getOplist(popid);
			ArrayList<DpPackageOptionVO> list = new ArrayList<DpPackageOptionVO>();
			for(Object obj : olist){
			//System.out.println(vo.getPopid());
			  list.add((DpPackageOptionVO)obj);

			}
			
			for(DpPackageOptionVO vo1:list){
				   System.out.println(vo1.getPopid()); 
			}

			mv.addObject("list", list);
			mv.addObject("popid", popid);
			mv.addObject("pnum", pnum);
			mv.addObject("vo", vo);
			mv.addObject("rno", rno);
			mv.setViewName("/package/package_content_ncf");
			
			return mv;
	}
	
	//de 카트 등록처리 
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/package/package_content_de_cart.th", method=RequestMethod.POST)
	public ModelAndView add_cart_de(@RequestBody String vo, HttpServletRequest request, HttpSession session) throws Exception{
		
		ModelAndView mv = new  ModelAndView();
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> param = mapper.readValue(vo, Map.class);
		param.put("mnum", session.getAttribute("mnum"));
		int s = cartDao.insert(param);
		
		
		if(s >= 1) {
			mv.setViewName("/mypage/doppio_mypage_basket");
		}else {
			//에러페이지 호출
		}
		return mv;
	}
	
	
	//cf 카트 등록처리 
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/package/package_content_cf_cart.th", method=RequestMethod.POST)
	public ModelAndView add_cart_cf(@RequestBody String vo, HttpServletRequest request, HttpSession session) throws Exception{
		
		ModelAndView mv = new  ModelAndView();
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> param = mapper.readValue(vo, Map.class); // vo를 map형식으로 변환한것?
		param.put("mnum", session.getAttribute("mnum"));		
		int s = cartDao.insert(param);
		
		
		if(s >= 1) {
			mv.setViewName("/mypage/doppio_mypage_basket");
		}else {
			//에러페이지 호출
		}
		return mv;
	}
	
	
	//ncf 카트 등록처리 
		@SuppressWarnings("unchecked")
		@RequestMapping(value="/package/package_content_ncf_cart.th", method=RequestMethod.POST)
		public ModelAndView add_cart_ncf(@RequestBody String vo, HttpServletRequest request, HttpSession session) throws Exception{
			
			ModelAndView mv = new  ModelAndView();
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> param = mapper.readValue(vo, Map.class);
			param.put("mnum", session.getAttribute("mnum"));
			int s = cartDao.insert(param);
			
			
			if(s >= 1) {
				mv.setViewName("/mypage/doppio_mypage_basket");
			}else {
				//에러페이지 호출
			}
			return mv;
		}
		
		
}

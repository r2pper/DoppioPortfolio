package com.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.dao.DpCommentDAO;
import com.web.dao.DpNoticeDAO;
import com.web.service.DpCommentServiceImpl;
import com.web.service.DpNoticeServiceImpl;
import com.web.service.DpPageServiceImpl;
import com.web.service.FileServiceImpl;

import com.web.vo.DpCommentVO;
import com.web.vo.DpNoticeVO;

@Controller
public class NoticeController {
	@Autowired
	private DpNoticeServiceImpl noticeService;
	
	@Autowired
	private DpNoticeDAO noticeDao;
	
	@Autowired
	private DpPageServiceImpl pageService;
	
	@Autowired
	private FileServiceImpl fileService;
	
	@Autowired
	private DpCommentServiceImpl commentService;

	@Autowired
	private DpCommentDAO commentDao;
	
	//공지 리스트 검색
		@ResponseBody
		@RequestMapping(value="/notice/notice_list.th", method=RequestMethod.POST)
		public Map<String, Object> notice_search(@RequestBody String rpage) throws JsonParseException, JsonMappingException, IOException {
			Map<String, Object> map = new HashMap<String, Object>();
			ObjectMapper mapper = new ObjectMapper();		
			Map<String, Object> param = mapper.readValue(rpage, Map.class);
			List<Object> olist = noticeService.getListResult(param);
			int totalCnt = noticeService.getListCount();
			int resultCnt = olist.size();
			map.put("searchList", olist);
			map.put("totalListCnt", totalCnt);
			map.put("resultCnt", resultCnt);
			return map;
		}
	
	//공지 리스트
		@RequestMapping(value="/notice/notice_list.th", method=RequestMethod.GET)
		public ModelAndView notice_list(String rpage) {
			ModelAndView mv = new ModelAndView();
			
			Map<String, String> param = pageService.getPageResult(rpage, "notice", noticeService);
			int startCount = Integer.parseInt(param.get("start"));
			int endCount = Integer.parseInt(param.get("end"));
			
			List<Object> olist = noticeService.getListResult(startCount, endCount);
			ArrayList<DpNoticeVO> list = new ArrayList<DpNoticeVO>();
			for(Object obj : olist) {
				list.add((DpNoticeVO)obj);
			}
			
			mv.addObject("list", list);
			mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
			mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
			mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));
			
			mv.setViewName("/notice/notice_list");
			return mv;
		}
		
		//공지 상세보기
		@RequestMapping(value="/notice/notice_content.th", method=RequestMethod.GET)
			public ModelAndView notice_content(String nnum, String rno, String rpage) {
			ModelAndView mv = new ModelAndView();
			noticeService.getUpdateHits(nnum);
			DpNoticeVO vo = (DpNoticeVO)noticeService.getContent(nnum);
			Map<String, String> param = pageService.getPageResult3(rpage, "comment", commentService); 
			int startCount = Integer.parseInt(param.get("start")); 
			int endCount = Integer.parseInt(param.get("end")); 
			List<Object> olist = commentService.getListResult1(startCount, endCount, nnum);
			ArrayList<DpCommentVO> list = new ArrayList<DpCommentVO>(); 
			for(Object obj : olist) { 
				list.add((DpCommentVO)obj); 
			}
			  
			mv.addObject("list", list); 
			mv.addObject("dbCount", Integer.parseInt(param.get("dbCount"))); 
			mv.addObject("pageSize", Integer.parseInt(param.get("pageSize"))); 
			mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));
			  
			mv.addObject("nnum", nnum); 
			mv.addObject("vo", vo); 
			mv.addObject("rno", rno);
			mv.setViewName("/notice/notice_content"); 
			return mv; 
		}
}

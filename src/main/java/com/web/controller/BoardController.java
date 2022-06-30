package com.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.web.dao.DpBoardDAO;
import com.web.dao.DpCommentDAO;
import com.web.service.DpBoardServiceImpl;
import com.web.service.DpCommentServiceImpl;
import com.web.service.DpPageServiceImpl;
import com.web.service.FileServiceImpl;
import com.web.vo.DpBoardVO;
import com.web.vo.DpCommentVO;

@Controller
public class BoardController {

	@Autowired
	private DpBoardServiceImpl boardService;
	
	@Autowired
	private DpBoardDAO boardDao;
	
	@Autowired
	private DpPageServiceImpl pageService;
	
	@Autowired
	private FileServiceImpl fileService;
	
	@Autowired
	private DpCommentServiceImpl commentService;

	@Autowired
	private DpCommentDAO commentDao;
	
	//게시글 검색
	@ResponseBody
	@RequestMapping(value="/board/board_list.th", method=RequestMethod.POST)
	public Map<String, Object> board_search(@RequestBody String rpage) throws JsonParseException, JsonMappingException, IOException {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		Map<String, Object> param = mapper.readValue(rpage, Map.class);
		
//		int startCount = Integer.parseInt(param.get("start"));
//		int endCount = Integer.parseInt(param.get("end"));

		
		List<Object> olist = boardService.getListResult(param);
		/*
		 * ArrayList<DpBoardVO> list = new ArrayList<DpBoardVO>(); for(Object obj :
		 * olist) { list.add((DpBoardVO)obj); }
		 */
		
		int totalCnt = boardService.getListCount();
		int resultCnt = olist.size();
		map.put("searchList", olist);
		map.put("totalListCnt", totalCnt);
		map.put("resultCnt", resultCnt);
		/*
		 * map.put("dbCount", Integer.parseInt(param.get("dbCount")));
		 * map.put("pageSize", Integer.parseInt(param.get("pageSize")));
		 * map.put("reqPage", Integer.parseInt(param.get("reqPage")));
		 */
				
		return map;
	}
	
	
	//게시글 리스트
	@RequestMapping(value="/board/board_list.th", method=RequestMethod.GET)
	public ModelAndView board_lis(String rpage) {
		ModelAndView mv = new ModelAndView();
		
		Map<String, String> param = pageService.getPageResult(rpage, "board", boardService);
		int startCount = Integer.parseInt(param.get("start"));
		int endCount = Integer.parseInt(param.get("end"));
		
		List<Object> olist = boardService.getListResult(startCount, endCount);
		ArrayList<DpBoardVO> list = new ArrayList<DpBoardVO>();
		for(Object obj : olist) {
			list.add((DpBoardVO)obj);
		}
		
		mv.addObject("list", list);
		mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
		mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
		mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));
		
		mv.setViewName("/board/board_list");
		return mv;
	}
	
	//게시글 상세보기
	@RequestMapping(value="/board/board_content.th", method=RequestMethod.GET)
		public ModelAndView board_content(String bnum, String rno, String rpage) {
		ModelAndView mv = new ModelAndView();
		boardService.getUpdateHits(bnum);
		DpBoardVO vo = (DpBoardVO)boardService.getContent(bnum);
		Map<String, String> param = pageService.getPageResult3(rpage, "comment", commentService); 
		int startCount = Integer.parseInt(param.get("start")); 
		int endCount = Integer.parseInt(param.get("end")); 
		List<Object> olist = commentService.getListResult1(startCount, endCount, bnum);
		ArrayList<DpCommentVO> list = new ArrayList<DpCommentVO>(); 
		for(Object obj : olist) { 
			list.add((DpCommentVO)obj); 
		}
		  
		mv.addObject("list", list); 
		mv.addObject("dbCount", Integer.parseInt(param.get("dbCount"))); 
		mv.addObject("pageSize", Integer.parseInt(param.get("pageSize"))); 
		mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));
		  
		mv.addObject("bnum", bnum); 
		mv.addObject("vo", vo); 
		mv.addObject("rno", rno);
		mv.setViewName("/board/board_content"); 
		return mv; 
	}
	
	//게시글 등록폼
			@RequestMapping(value="/board/board_write.th", method=RequestMethod.GET)
			public ModelAndView board_write() {
				ModelAndView mv = new ModelAndView();
				mv.setViewName("/board/board_write");
				return mv;
			}
	
	//게시글 등록처리
	@RequestMapping(value="/board/board_write.th", method=RequestMethod.POST)
		public String board_write(DpBoardVO vo, HttpServletRequest request) throws Exception{
				
				String result_page = "";		
				
				vo = fileService.fileCheck(vo);
				int result = boardService.getInsertResult(vo);
				
				if(result == 1) {
					fileService.fileSave(vo,request);					
					result_page = "redirect:board_list.th";
					
				}else {
					//占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 호占쏙옙
				}		
				
				return result_page;
	}
	
	
	//게시글 업데이트폼
	@RequestMapping(value="/board/board_update.th", method=RequestMethod.GET)
		public ModelAndView board_update(String bnum, String rno) {
			ModelAndView mv = new ModelAndView();
			DpBoardVO vo = (DpBoardVO)boardService.getContent(bnum);
			
			mv.addObject("vo",vo);
			mv.addObject("rno",rno);
			mv.setViewName("/board/board_update");
			
			return mv;
	}
	
	//게시글 업데이트 처리
	@RequestMapping(value="/board/board_update.th", method=RequestMethod.POST)
		public ModelAndView board_update(DpBoardVO vo, HttpServletRequest request) throws Exception{
		
			ModelAndView mv = new ModelAndView();
			String oldFile = vo.getBsfile();
			
			vo = fileService.fileCheck(vo);
			
			int result = boardService.getUpdateResult(vo);
	
			System.out.println("update bnum ------ " + vo.getId());
			
			if(result == 1) {
				fileService.fileSave(vo, request, oldFile);
				mv.setViewName("redirect:/board/board_list.th");
			}else {
				//error
			}
			
			return mv;
	}
//		//게시글 삭제
//		@RequestMapping(value="/board/board_content.th", method=RequestMethod.GET)
//		public ModelAndView board_delete(String bnum, String rno) {
//			ModelAndView mv = new ModelAndView();
//			mv.addObject("bnum", bnum);
//			mv.addObject(rno);
//			mv.setViewName("/board/board_list.th");
//			
//			return mv;
//		}
	
		//게시글 삭제처리
		@RequestMapping(value="/board/board_content.th", method=RequestMethod.POST)
		public ModelAndView board_delete(DpBoardVO vo, HttpServletRequest request)
														throws Exception{
			ModelAndView mv = new ModelAndView();
			String bsfile = boardService.getFilename(vo.getBnum());
			int result = boardService.getDeleteResult(vo.getBnum());
		
			if(result == 1) {
				if(bsfile != null) {
					String path = request.getSession().getServletContext().getRealPath("/");
					path += "resources\\upload\\";
					File file = new File(path + bsfile);
					if(file.exists()) file.delete();
				}
				mv.setViewName("redirect:/board/board_list.th");			
			}else {
				//에러페이지 호출
			}		
			
			return mv;
	}
		
		
		
		
		
		
		
	// 댓글등록
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/board/board_content_cmtWrite.th", method = RequestMethod.POST)
	public ModelAndView board_content_write(@RequestBody String vo, HttpServletRequest request) throws Exception {

		ModelAndView mv = new ModelAndView();

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> param = mapper.readValue(vo, Map.class);
		int s = commentDao.insert(param);

		if (s >= 1) {
			mv.setViewName("/board/board_content");
		}
		return mv;
	}

	// 댓글수정
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/board/board_content_cmtUpdate.th", method = RequestMethod.POST)
	public ModelAndView board_content_update(@RequestBody String vo, HttpServletRequest request) throws Exception {

		ModelAndView mv = new ModelAndView();

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> param = mapper.readValue(vo, Map.class);
		int s = commentDao.update(param);

		if (s >= 1) {
			mv.setViewName("/board/board_content");			
		} 
		return mv;
	}
	
	// 댓글삭제
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/board/board_content_cmtDelete.th", method = RequestMethod.POST)
	public ModelAndView board_content_delete(@RequestBody String vo, HttpServletRequest request) throws Exception {

		ModelAndView mv = new ModelAndView();

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> param = mapper.readValue(vo, Map.class);
		int s = commentDao.delete(param);

		if (s >= 1) {
			mv.setViewName("/board/board_content");			
		} 
		return mv;
	}	
}

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
import com.web.dao.DpCommentDAO;
import com.web.dao.DpNoticeDAO;
import com.web.dao.DpOrderDAO;
import com.web.dao.DpRecipeDAO;
import com.web.service.DpCommentServiceImpl;
import com.web.service.DpMemberServiceImpl;
import com.web.service.DpNoticeServiceImpl;
import com.web.service.DpPackageServiceImpl;
import com.web.service.DpPageServiceImpl;
import com.web.service.DpRecipeServiceImpl;
import com.web.service.FileServiceImpl;
import com.web.vo.DpBoardVO;
import com.web.vo.DpCommentVO;
import com.web.vo.DpMemberVO;
import com.web.vo.DpNoticeVO;
import com.web.vo.DpOrderVO;
import com.web.vo.DpPackageVO;
import com.web.vo.DpQnaVO;
import com.web.vo.DpRecipeVO;

@Controller
public class AdminController {
	@Autowired
	private DpMemberServiceImpl memberService;

	@Autowired
	private DpRecipeServiceImpl recipeService;

	@Autowired
	private DpRecipeDAO recipeDao;

	@Autowired
	private DpPackageServiceImpl packageService;

	@Autowired
	private DpPageServiceImpl pageService;

	@Autowired
	private FileServiceImpl fileService;

	@Autowired
	private DpCommentServiceImpl commentService;

	@Autowired
	private DpCommentDAO commentDao;
	
	@Autowired
	private DpNoticeServiceImpl noticeService;
	
	@Autowired
	private DpNoticeDAO noticeDao;
	
	@Autowired
	private DpOrderDAO orderDao;
	

	@RequestMapping(value = "/admin/admin.th", method = RequestMethod.GET)
	public String admin() {

		return "/admin/admin";
	}

	/** * 관리자 회원관리페이지 (리스트) */
	@RequestMapping(value = "/admin/member/member_list.th", method = RequestMethod.GET)
	public ModelAndView admin_member_list(String rpage) {
		ModelAndView mv = new ModelAndView();
		Map<String, String> param = pageService.getPageResult3(rpage, "member", memberService);
		int startCount = Integer.parseInt(param.get("start"));
		int endCount = Integer.parseInt(param.get("end"));
		ArrayList<DpMemberVO> list = new ArrayList<DpMemberVO>();
		List<Object> olist = memberService.getListResult(startCount, endCount);
		for (Object obj : olist) {
			list.add((DpMemberVO) obj);
		}
		mv.addObject("list", list);
		mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
		mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
		mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));
		mv.setViewName("/admin/member/member_list");
		return mv;
	}

	/** * 관리자 회원관리 상세페이지 */
	@RequestMapping(value = "/admin/member/member_content.th", method = RequestMethod.GET)
	public ModelAndView admin_member_content(String mnum, String rno) {
		ModelAndView mv = new ModelAndView();
		DpMemberVO vo = (DpMemberVO) memberService.getContent(mnum);

		mv.addObject("vo", vo);
		mv.addObject("rno", rno);

		mv.setViewName("/admin/member/member_content");
		return mv;
	}
	
	
	//------------------------notice--------------------------------//
	//공지 리스트 검색
	@ResponseBody
	@RequestMapping(value="/admin/admin_notice/notice_list.th", method=RequestMethod.POST)
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
	@RequestMapping(value="/admin/admin_notice/notice_list.th", method=RequestMethod.GET)
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
		
		mv.setViewName("/admin/admin_notice/notice_list");
		return mv;
	}
	
	//공지 상세보기
	@RequestMapping(value="/admin/admin_notice/notice_content.th", method=RequestMethod.GET)
	public ModelAndView notice_content(String nnum, String rno, String rpage) {
		ModelAndView mv = new ModelAndView();
		
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
		mv.setViewName("/admin/admin_notice/notice_content"); 
		return mv; 
	}
	
	
	//공지 등록폼
	@RequestMapping(value="/admin/admin_notice/notice_write.th", method=RequestMethod.GET)
	public ModelAndView notice_write() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/admin_notice/notice_write");
		return mv;
	}

	//공지글 등록 처리
	@RequestMapping(value="/admin/admin_notice/notice_write.th", method=RequestMethod.POST)
	public String notice_write(DpNoticeVO vo, HttpServletRequest request) throws Exception{
			
			String result_page = "";		
			
			vo = fileService.fileCheck(vo);
			int result = noticeService.getInsertResult(vo);
			
			if(result == 1) {
				fileService.fileSave(vo,request);					
				result_page = "redirect:/admin/admin_notice/notice_list.th";
				
			}else {
				//에러페이지 호출
			}		
			
			return result_page;
	}
	
	
	//공지글 수정폼
	@RequestMapping(value="/admin/admin_notice/notice_update.th", method=RequestMethod.GET)
	public ModelAndView notice_update(String nnum, String rno) {
		ModelAndView mv = new ModelAndView();
		DpNoticeVO vo = (DpNoticeVO)noticeService.getContent(nnum);
		
		mv.addObject("vo",vo);
		mv.addObject("rno",rno);
		mv.setViewName("/admin/admin_notice/notice_update");
		
		return mv;
	}
	
	//공지글 수정 처리
	@RequestMapping(value="/admin/admin_notice/notice_update.th", method=RequestMethod.POST)
	public ModelAndView notice_update(DpNoticeVO vo, HttpServletRequest request) throws Exception{
	
		ModelAndView mv = new ModelAndView();
		String oldFile = vo.getNsfile();
		
		vo = fileService.fileCheck(vo);
		
		int result = noticeService.getUpdateResult(vo);
	
		System.out.println("update Nnum ------ " + vo.getId());
		
		if(result == 1) {
			fileService.fileSave(vo, request, oldFile);
			mv.setViewName("redirect:/admin/admin_notice/notice_list.th");
		}else {
			//에러페이지 호출
		}
		
		return mv;
	}
	
	//공지글 삭제처리
	@RequestMapping(value="/admin/admin_notice/notice_content.th", method=RequestMethod.POST)
	public ModelAndView notice_delete(DpNoticeVO vo, HttpServletRequest request)
													throws Exception{
		ModelAndView mv = new ModelAndView();
		String Nsfile = noticeService.getFilename(vo.getNnum());
		int result = noticeService.getDeleteResult(vo.getNnum());
	
		if(result == 1) {
			if(Nsfile != null) {
				String path = request.getSession().getServletContext().getRealPath("/");
				path += "resources\\upload\\";
				File file = new File(path + Nsfile);
				if(file.exists()) file.delete();
			}
			mv.setViewName("redirect:/admin/admin_notice/notice_list.th");			
		}else {
			//에러페이지 호출
		}		
		
		return mv;
	}
	
	
	
	//-----------------------ORDER--------------------------------//
	
	//주문 내역
	@RequestMapping(value="/admin/admin_order_list.th", method=RequestMethod.GET)
	public ModelAndView admin_order_list(String mnum) {
		ModelAndView mv = new ModelAndView();
		List<Map<String, Object>> vo = orderDao.selectList2(mnum);
		ArrayList<DpOrderVO> list = new ArrayList<DpOrderVO>();
		for(Object obj : vo) {
			list.add((DpOrderVO)obj);
		}
		mv.addObject("list", list);
		mv.addObject("vo", vo);			
		mv.setViewName("/admin/admin_order_list");
		return mv;
	}	
	
	
	
	
	
	
	
	
	

	/* 관리자 레시피 */
	// 레시피 삭제처리 - 커피
	@RequestMapping(value = "/admin/admin_recipe/recipe_content_cf.th", method = RequestMethod.POST)
	public ModelAndView recipe_delete_cf(DpRecipeVO vo, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		String rsfile = recipeService.getFilename(vo.getRnum());
		int result = recipeService.getDeleteResult(vo.getRnum());

		if (result == 1) {
			if (rsfile != null) {
				String path = request.getSession().getServletContext().getRealPath("/");
				path += "resources\\upload\\";
				File file = new File(path + rsfile); 
				if (file.exists())
					file.delete();
			}
			mv.setViewName("redirect:/admin/admin_recipe/recipe_list_cf.th");
		}
		return mv;

	}

	// 레시피 삭제처리 - 논커피
	@RequestMapping(value = "/admin/admin_recipe/recipe_content_ncf.th", method = RequestMethod.POST)
	public ModelAndView recipe_delete_ncf(DpRecipeVO vo, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		String rsfile = recipeService.getFilename(vo.getRnum());
		int result = recipeService.getDeleteResult(vo.getRnum());

		if (result == 1) {
			if (rsfile != null) {
				String path = request.getSession().getServletContext().getRealPath("/");
				path += "resources\\upload\\";
				File file = new File(path + rsfile);
				if (file.exists())
					file.delete();
			}
			mv.setViewName("redirect:/admin/admin_recipe/recipe_list_ncf.th");
		}
		return mv;

	}

	// 레시피 삭제처리 - 디저트
	@RequestMapping(value = "/admin/admin_recipe/recipe_content_de.th", method = RequestMethod.POST)
	public ModelAndView recipe_delete_de(DpRecipeVO vo, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		String rsfile = recipeService.getFilename(vo.getRnum());
		int result = recipeService.getDeleteResult(vo.getRnum());

		if (result == 1) {
			if (rsfile != null) {
				String path = request.getSession().getServletContext().getRealPath("/");
				path += "resources\\upload\\";
				File file = new File(path + rsfile);
				if (file.exists())
					file.delete();
			}
			mv.setViewName("redirect:/admin/admin_recipe/recipe_list_de.th");
		}
		return mv;

	}

	// 레시피 업데이트 폼 - 커피
	@RequestMapping(value = "/admin/admin_recipe/recipe_update_cf.th", method = RequestMethod.GET)
	public ModelAndView recipe_update_cf(String rnum, String rno) {
		ModelAndView mv = new ModelAndView();
		DpRecipeVO vo = (DpRecipeVO) recipeService.getContent(rnum);

		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		mv.setViewName("/admin/admin_recipe/recipe_update_cf");
		return mv;
	}

	// 레시피 업데이트 폼 - 논커피
	@RequestMapping(value = "/admin/admin_recipe/recipe_update_ncf.th", method = RequestMethod.GET)
	public ModelAndView recipe_update_ncf(String rnum, String rno) {
		ModelAndView mv = new ModelAndView();
		DpRecipeVO vo = (DpRecipeVO) recipeService.getContent(rnum);

		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		mv.setViewName("/admin/admin_recipe/recipe_update_ncf");
		return mv;
	}

	// 레시피 업데이트 폼 - 디저트
	@RequestMapping(value = "/admin/admin_recipe/recipe_update_de.th", method = RequestMethod.GET)
	public ModelAndView recipe_update_de(String rnum, String rno) {
		ModelAndView mv = new ModelAndView();
		DpRecipeVO vo = (DpRecipeVO) recipeService.getContent(rnum);

		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		mv.setViewName("/admin/admin_recipe/recipe_update_de");
		return mv;
	}

	// 레시피 업데이트 처리 - 커피
	@RequestMapping(value = "/admin/admin_recipe/recipe_update_cf.th", method = RequestMethod.POST)
	public ModelAndView recipe_update_cf(DpRecipeVO vo, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		String oldFile = vo.getRsfile();
		vo = fileService.fileCheck(vo);

		int result = recipeService.getUpdateResult(vo);
		if (result == 1) {
			fileService.fileSave(vo, request, oldFile);
			mv.setViewName("redirect:/admin/admin_recipe/recipe_list_cf.th");
		} else {
			// 에러페이지 호출
		}

		return mv;
	}

	// 레시피 업데이트 처리 - 논커피
	@RequestMapping(value = "/admin/admin_recipe/recipe_update_ncf.th", method = RequestMethod.POST)
	public ModelAndView recipe_update_ncf(DpRecipeVO vo, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		String oldFile = vo.getRsfile();
		vo = fileService.fileCheck(vo);

		int result = recipeService.getUpdateResult(vo);
		if (result == 1) {
			fileService.fileSave(vo, request, oldFile);
			mv.setViewName("redirect:/admin/admin_recipe/recipe_list_ncf.th");
		} else {
			// 에러페이지 호출
		}

		return mv;
	}

	// 레시피 업데이트 처리 - 디저트
	@RequestMapping(value = "/admin/admin_recipe/recipe_update_desert.th", method = RequestMethod.POST)
	public ModelAndView recipe_update_desert(DpRecipeVO vo, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		String oldFile = vo.getRsfile();
		vo = fileService.fileCheck(vo);

		int result = recipeService.getUpdateResult(vo);
		if (result == 1) {
			fileService.fileSave(vo, request, oldFile);
			mv.setViewName("redirect:/admin/admin_recipe/recipe_list_desert.th");
		} else {
			// 에러페이지 호출
		}

		return mv;
	}

	// 레시피 등록폼 - 커피
	@RequestMapping(value = "/admin/admin_recipe/recipe_write_cf.th", method = RequestMethod.GET)
	public ModelAndView recipe_write_cf() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/admin_recipe/recipe_write_cf");
		return mv;
	}

	// 레시피 등록폼 - 논커피
	@RequestMapping(value = "/admin/admin_recipe/recipe_write_ncf.th", method = RequestMethod.GET)
	public ModelAndView recipe_write_ncf() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/admin_recipe/recipe_write_ncf");
		return mv;
	}

	// 레시피 등록폼 - 디저트
	@RequestMapping(value = "/admin/admin_recipe/recipe_write_de.th", method = RequestMethod.GET)
	public ModelAndView recipe_write_de() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/admin_recipe/recipe_write_de");
		return mv;
	}

	// 레시피 등록처리 - 커피
	@RequestMapping(value = "/admin/admin_recipe/recipe_write_cf.th", method = RequestMethod.POST)
	public String recipe_write_cf(DpRecipeVO vo, HttpServletRequest request) throws Exception {

		String result_page = "";

		vo = fileService.fileCheck(vo);
		int result = recipeService.getInsertResult(vo);

		if (result == 1) {
			fileService.fileSave(vo, request);
			result_page = "redirect:/admin/admin_recipe/recipe_list_cf.th";
		} else {
			// 에러페이지 호출
		}
		return result_page;
	}

	// 레시피 등록처리 - 논커피
	@RequestMapping(value = "/admin/admin_recipe/recipe_write_ncf.th", method = RequestMethod.POST)
	public String recipe_write_ncf(DpRecipeVO vo, HttpServletRequest request) throws Exception {

		String result_page = "";

		vo = fileService.fileCheck(vo);
		int result = recipeService.getInsertResult(vo);

		if (result == 1) {
			fileService.fileSave(vo, request);
			result_page = "redirect:/admin/admin_recipe/recipe_list_ncf.th";
		} else {
			// 에러페이지 호출
		}
		return result_page;
	}

	// 레시피 등록처리 - 디저트
	@RequestMapping(value = "/admin/admin_recipe/recipe_write_de.th", method = RequestMethod.POST)
	public String recipe_write_de(DpRecipeVO vo, HttpServletRequest request) throws Exception {

		String result_page = "";

		vo = fileService.fileCheck(vo);
		int result = recipeService.getInsertResult(vo);

		if (result == 1) {
			fileService.fileSave(vo, request);
			result_page = "redirect:/admin/admin_recipe/recipe_list_de.th";
		} else {
			// 에러페이지 호출
		}
		return result_page;

	}

	/* recipe_list 레시피 리스트 - 디저트 */
	@RequestMapping(value = "/admin/admin_recipe/recipe_list_de.th", method = RequestMethod.GET)
	public ModelAndView recipe_list(String rpage) {
		ModelAndView mv = new ModelAndView();
		Map<String, String> param = pageService.getPageResult2(rpage, "recipe_de", recipeService);
		int startCount = Integer.parseInt(param.get("start"));
		int endCount = Integer.parseInt(param.get("end"));
		List<Object> olist = recipeService.getListResult(startCount, endCount, "de");
		ArrayList<DpRecipeVO> list = new ArrayList<DpRecipeVO>();
		for (Object obj : olist) {
			list.add((DpRecipeVO) obj);
		}
		mv.addObject("list", list);
		mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
		mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
		mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));

		mv.setViewName("/admin/admin_recipe/recipe_list_de");
		return mv;
	}

	/* recipe_list 레시피 리스트 - 커피 */
	@RequestMapping(value = "/admin/admin_recipe/recipe_list_cf.th", method = RequestMethod.GET)
	public ModelAndView recipe_list_cf(String rpage) {
		ModelAndView mv = new ModelAndView();
		Map<String, String> param = pageService.getPageResult2(rpage, "recipe_cf", recipeService);
		int startCount = Integer.parseInt(param.get("start"));
		int endCount = Integer.parseInt(param.get("end"));
		List<Object> olist = recipeService.getListResult(startCount, endCount, "cf");
		ArrayList<DpRecipeVO> list = new ArrayList<DpRecipeVO>();
		for (Object obj : olist) {
			list.add((DpRecipeVO) obj);
		}
		mv.addObject("list", list);
		mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
		mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
		mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));

		mv.setViewName("/admin/admin_recipe/recipe_list_cf");
		return mv;
	}

	/* recipe_list 레시피 리스트 - 논커피 */
	@RequestMapping(value = "/admin/admin_recipe/recipe_list_ncf.th", method = RequestMethod.GET)
	public ModelAndView recipe_list_ncf(String rpage) {
		ModelAndView mv = new ModelAndView();
		Map<String, String> param = pageService.getPageResult2(rpage, "recipe_ncf", recipeService);
		int startCount = Integer.parseInt(param.get("start"));
		int endCount = Integer.parseInt(param.get("end"));
		List<Object> olist = recipeService.getListResult(startCount, endCount, "ncf");
		ArrayList<DpRecipeVO> list = new ArrayList<DpRecipeVO>();
		for (Object obj : olist) {
			list.add((DpRecipeVO) obj);
		}
		mv.addObject("list", list);
		mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
		mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
		mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));

		mv.setViewName("/admin/admin_recipe/recipe_list_ncf");
		return mv;
	}

	

	// 레시피 상세페이지 - 커피 + 댓글리스트
	
	  @RequestMapping(value="/admin/admin_recipe/recipe_content_cf.th", method=RequestMethod.GET) 
	  public ModelAndView recipe_content_cf(String rnum, String rno, String rpage) { 
		  ModelAndView mv = new ModelAndView();
		  //recipeService.getUpdateHits(rnum); 
		  DpRecipeVO vo = (DpRecipeVO)recipeService.getContent(rnum);
		  
		  Map<String, String> param = pageService.getPageResult3(rpage, "comment", commentService); 
		  int startCount = Integer.parseInt(param.get("start")); 
		  int endCount = Integer.parseInt(param.get("end")); 
		  List<Object> olist = commentService.getListResult1(startCount, endCount, rnum);
		  ArrayList<DpCommentVO> list = new ArrayList<DpCommentVO>(); 
		  for(Object obj : olist) { 
			  list.add((DpCommentVO)obj); 
		  }
		  
		  mv.addObject("list", list); 
		  mv.addObject("dbCount", Integer.parseInt(param.get("dbCount"))); 
		  mv.addObject("pageSize", Integer.parseInt(param.get("pageSize"))); 
		  mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));
		  
		  mv.addObject("rnum", rnum); 
		  mv.addObject("vo", vo); 
		  mv.addObject("rno", rno);
		  mv.setViewName("/admin/admin_recipe/recipe_content_cf"); 
		  return mv; 
	  }
	 

	// 레시피 상세페이지 - 커피 - 댓글등록
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/admin_recipe/recipe_content_cf_cmtWrite.th", method = RequestMethod.POST)
	public ModelAndView recipe_content_cf_write(@RequestBody String vo, HttpServletRequest request) throws Exception {

		ModelAndView mv = new ModelAndView();

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> param = mapper.readValue(vo, Map.class);
		int s = commentDao.insert(param);

		if (s >= 1) {
			mv.setViewName("/admin/admin_recipe/recipe_content_cf");
		}
		return mv;
	}

	// 레시피 상세페이지 - 커피 - 댓글수정
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/admin_recipe/recipe_content_cf_cmtUpdate.th", method = RequestMethod.POST)
	public ModelAndView recipe_content_cf_update(@RequestBody String vo, HttpServletRequest request) throws Exception {

		ModelAndView mv = new ModelAndView();

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> param = mapper.readValue(vo, Map.class);
		int s = commentDao.update(param);

		if (s >= 1) {
			mv.setViewName("/admin/admin_recipe/recipe_content_cf");			
		} 
		return mv;
	}
	
	// 레시피 상세페이지 - 커피 - 댓글삭제
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/admin_recipe/recipe_content_cf_cmtDelete.th", method = RequestMethod.POST)
	public ModelAndView recipe_content_cf_delete(@RequestBody String vo, HttpServletRequest request) throws Exception {

		ModelAndView mv = new ModelAndView();

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> param = mapper.readValue(vo, Map.class);
		int s = commentDao.delete(param);

		if (s >= 1) {
			mv.setViewName("/admin/admin_recipe/recipe_content_cf");			
		} 
		return mv;
	}
	
	
	
	
	
	
	

	// 레시피 상세페이지 - 논커피
	@RequestMapping(value = "/admin/admin_recipe/recipe_content_ncf.th", method = RequestMethod.GET)
	public ModelAndView recipe_content_ncf(String rnum, String rno, String rpage) {
		ModelAndView mv = new ModelAndView();
		/* recipeService.getUpdateHits(rnum); */
		DpRecipeVO vo = (DpRecipeVO) recipeService.getContent(rnum);
		
		Map<String,String> param = pageService.getPageResult3(rpage, "comment", commentService);
		int startCount = Integer.parseInt(param.get("start")); 
		int endCount = Integer.parseInt(param.get("end")); 
		 
		List<Object> olist = commentService.getListResult1(startCount, endCount, rnum);
		ArrayList<DpCommentVO> list = new ArrayList<DpCommentVO>(); 
		for(Object obj : olist) { 
			list.add((DpCommentVO)obj); 
		}
		  
	    mv.addObject("list", list); 
	    mv.addObject("dbCount", Integer.parseInt(param.get("dbCount"))); 
	    mv.addObject("pageSize", Integer.parseInt(param.get("pageSize"))); 
	    mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));
	  
	    mv.addObject("rnum", rnum); 
	    mv.addObject("vo", vo); 
	    mv.addObject("rno", rno);
	    mv.setViewName("/admin/admin_recipe/recipe_content_ncf"); 
	    return mv; 
		
	}
	
	// 레시피 상세페이지 - 논커피 - 댓글등록
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/admin_recipe/recipe_content_ncf_cmtWrite.th", method = RequestMethod.POST)
	public ModelAndView recipe_content_ncf_write(@RequestBody String vo, HttpServletRequest request) throws Exception {

		ModelAndView mv = new ModelAndView();

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> param = mapper.readValue(vo, Map.class);
		int s = commentDao.insert(param);

		if (s >= 1) {
			mv.setViewName("/admin/admin_recipe/recipe_content_ncf");
		}
		return mv;
	}

	// 레시피 상세페이지 - 논커피 - 댓글수정
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/admin_recipe/recipe_content_ncf_cmtUpdate.th", method = RequestMethod.POST)
	public ModelAndView recipe_content_ncf_update(@RequestBody String vo, HttpServletRequest request) throws Exception {

		ModelAndView mv = new ModelAndView();

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> param = mapper.readValue(vo, Map.class);
		int s = commentDao.update(param);

		if (s >= 1) {
			mv.setViewName("/admin/admin_recipe/recipe_content_ncf");			
		} 
		return mv;
	}
	
	// 레시피 상세페이지 - 논커피 - 댓글삭제
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/admin_recipe/recipe_content_ncf_cmtDelete.th", method = RequestMethod.POST)
	public ModelAndView recipe_content_ncf_delete(@RequestBody String vo, HttpServletRequest request) throws Exception {

		ModelAndView mv = new ModelAndView();

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> param = mapper.readValue(vo, Map.class);
		int s = commentDao.delete(param);

		if (s >= 1) {
			mv.setViewName("/admin/admin_recipe/recipe_content_ncf");			
		} 
		return mv;
	}
	
	
	
	
	
	
	
	// 레시피 상세페이지 - 디저트
	@RequestMapping(value = "/admin/admin_recipe/recipe_content_de.th", method = RequestMethod.GET)
	public ModelAndView recipe_content_de(String rnum, String rno, String rpage) {
		ModelAndView mv = new ModelAndView();
		/* recipeService.getUpdateHits(rnum); */
		DpRecipeVO vo = (DpRecipeVO) recipeService.getContent(rnum);
		Map<String,String> param = pageService.getPageResult3(rpage, "comment", commentService);
		int startCount = Integer.parseInt(param.get("start")); 
		int endCount = Integer.parseInt(param.get("end")); 
		 
		List<Object> olist = commentService.getListResult1(startCount, endCount, rnum);
		ArrayList<DpCommentVO> list = new ArrayList<DpCommentVO>(); 
		for(Object obj : olist) { 
			list.add((DpCommentVO)obj); 
		}
		  
	    mv.addObject("list", list); 
	    mv.addObject("dbCount", Integer.parseInt(param.get("dbCount"))); 
	    mv.addObject("pageSize", Integer.parseInt(param.get("pageSize"))); 
	    mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));
	  
	    mv.addObject("rnum", rnum); 
	    mv.addObject("vo", vo); 
	    mv.addObject("rno", rno);
	    mv.setViewName("/admin/admin_recipe/recipe_content_de"); 
	    return mv;
	}
	// 레시피 상세페이지 - 디저트 - 댓글등록
		@SuppressWarnings("unchecked")
		@RequestMapping(value = "/admin/admin_recipe/recipe_content_de_cmtWrite.th", method = RequestMethod.POST)
		public ModelAndView recipe_content_de_write(@RequestBody String vo, HttpServletRequest request) throws Exception {

			ModelAndView mv = new ModelAndView();

			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> param = mapper.readValue(vo, Map.class);
			int s = commentDao.insert(param);

			if (s >= 1) {
				mv.setViewName("/admin/admin_recipe/recipe_content_de");
			}
			return mv;
		}

		// 레시피 상세페이지 - 디저트 - 댓글수정
		@SuppressWarnings("unchecked")
		@RequestMapping(value = "/admin/admin_recipe/recipe_content_de_cmtUpdate.th", method = RequestMethod.POST)
		public ModelAndView recipe_content_de_update(@RequestBody String vo, HttpServletRequest request) throws Exception {

			ModelAndView mv = new ModelAndView();

			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> param = mapper.readValue(vo, Map.class);
			int s = commentDao.update(param);

			if (s >= 1) {
				mv.setViewName("/admin/admin_recipe/recipe_content_de");			
			} 
			return mv;
		}
		
		// 레시피 상세페이지 - 디저트 - 댓글삭제
		@SuppressWarnings("unchecked")
		@RequestMapping(value = "/admin/admin_recipe/recipe_content_de_cmtDelete.th", method = RequestMethod.POST)
		public ModelAndView recipe_content_de_delete(@RequestBody String vo, HttpServletRequest request) throws Exception {

			ModelAndView mv = new ModelAndView();

			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> param = mapper.readValue(vo, Map.class);
			int s = commentDao.delete(param);

			if (s >= 1) {
				mv.setViewName("/admin/admin_recipe/recipe_content_de");			
			} 
			return mv;
		}
		
		
		
		
		
		
		
		
	// ************************************************************************************

	/* 관리자 패키지 */

	// 디저트 패키지 업데이트 폼
	@RequestMapping(value = "/admin/admin_package/package_update_de.th", method = RequestMethod.GET)
	public ModelAndView package_update_de(String pnum, String rno) {

		ModelAndView mv = new ModelAndView();
		DpPackageVO vo = (DpPackageVO) packageService.getContent(pnum);

		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		mv.setViewName("/admin/admin_package/package_update_de");

		return mv;
	}

	// 커피 패키지 업데이트 폼
	@RequestMapping(value = "/admin/admin_package/package_update_cf.th", method = RequestMethod.GET)
	public ModelAndView package_update_cf(String pnum, String rno) {

		ModelAndView mv = new ModelAndView();
		DpPackageVO vo = (DpPackageVO) packageService.getContent(pnum);

		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		mv.setViewName("/admin/admin_package/package_update_cf");

		return mv;
	}

	// 논커피 패키지 업데이트 폼
	@RequestMapping(value = "/admin/admin_package/package_update_ncf.th", method = RequestMethod.GET)
	public ModelAndView package_update_ncf(String pnum, String rno) {

		ModelAndView mv = new ModelAndView();
		DpPackageVO vo = (DpPackageVO) packageService.getContent(pnum);

		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		mv.setViewName("/admin/admin_package/package_update_ncf");

		return mv;
	}

	// 디저트 패키지 업데이트 처리
	@RequestMapping(value = "/admin/admin_package/package_update_de.th", method = RequestMethod.POST)
	public ModelAndView package_update_de(DpPackageVO vo, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		String oldFile = vo.getPsfile();
		vo = fileService.fileCheck(vo);

		int result = packageService.getUpdateResult(vo);
		if (result == 1) {
			fileService.fileSave(vo, request, oldFile);
			mv.setViewName("redirect:/admin/admin_package/package_list_de.th");
		} else {
			// 에러페이지 호출
		}

		return mv;
	}

	// 커피 패키지 업데이트 처리
	@RequestMapping(value = "/admin/admin_package/package_update_cf.th", method = RequestMethod.POST)
	public ModelAndView package_update_cf(DpPackageVO vo, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		String oldFile = vo.getPsfile();
		vo = fileService.fileCheck(vo);

		int result = packageService.getUpdateResult(vo);
		if (result == 1) {
			fileService.fileSave(vo, request, oldFile);
			mv.setViewName("redirect:/admin/admin_package/package_list_cf.th");
		} else {
			// 에러페이지 호출
		}

		return mv;
	}

	// 논커피 패키지 업데이트 처리
	@RequestMapping(value = "/admin/admin_package/package_update_ncf.th", method = RequestMethod.POST)
	public ModelAndView package_update_ncf(DpPackageVO vo, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		String oldFile = vo.getPsfile();
		vo = fileService.fileCheck(vo);

		int result = packageService.getUpdateResult(vo);
		if (result == 1) {
			fileService.fileSave(vo, request, oldFile);
			mv.setViewName("redirect:/admin/admin_package/package_list_ncf.th");
		} else {
			// 에러페이지 호출
		}

		return mv;
	}

	// 디저트 패키지 등록폼
	@RequestMapping(value = "/admin/admin_package/package_write_de.th", method = RequestMethod.GET)
	public ModelAndView package_write_de() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/admin_package/package_write_de");
		return mv;
	}

	// 커피 패키지 등록폼
	@RequestMapping(value = "/admin/admin_package/package_write_cf.th", method = RequestMethod.GET)
	public ModelAndView package_write_cf() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/admin_package/package_write_cf");
		return mv;
	}

	// 논커피 패키지 등록폼
	@RequestMapping(value = "/admin/admin_package/package_write_ncf.th", method = RequestMethod.GET)
	public ModelAndView package_write_ncf() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/admin_package/package_write_ncf");
		return mv;
	}

	// 디저트 패키지 등록처리
	@RequestMapping(value = "/admin/admin_package/package_write_de.th", method = RequestMethod.POST)
	public String package_write_de(DpPackageVO vo, HttpServletRequest request) throws Exception {

		String result_page = "";

		vo = fileService.fileCheck(vo);
		int result = packageService.getInsertResult(vo);

		if (result == 1) {
			fileService.fileSave(vo, request);
			result_page = "redirect:/admin/admin_package/package_list_de.th";
		} else {
			// 에러페이지 호출
		}
		return result_page;
	}

	// 커피 패키지 등록처리
	@RequestMapping(value = "/admin/admin_package/package_write_cf.th", method = RequestMethod.POST)
	public String package_write_cf(DpPackageVO vo, HttpServletRequest request) throws Exception {

		String result_page = "";

		vo = fileService.fileCheck(vo);
		int result = packageService.getInsertResult(vo);

		if (result == 1) {
			fileService.fileSave(vo, request);
			result_page = "redirect:/admin/admin_package/package_list_cf.th";
		} else {
			// 에러페이지 호출
		}
		return result_page;
	}

	// 논커피 패키지 등록처리
	@RequestMapping(value = "/admin/admin_package/package_write_ncf.th", method = RequestMethod.POST)
	public String package_write_ncf(DpPackageVO vo, HttpServletRequest request) throws Exception {

		String result_page = "";

		vo = fileService.fileCheck(vo);
		int result = packageService.getInsertResult(vo);

		if (result == 1) {
			fileService.fileSave(vo, request);
			result_page = "redirect:/admin/admin_package/package_list_ncf.th";
		} else {
			// 에러페이지 호출
		}
		return result_page;
	}

	// 디저트 패키지 리스트
	@RequestMapping(value = "/admin/admin_package/package_list_de.th", method = RequestMethod.GET)

	public ModelAndView package_list_de(String rpage) {
		ModelAndView mv = new ModelAndView();
		Map<String, String> param = pageService.getPageResult2(rpage, "package_de", packageService);

		int startCount = Integer.parseInt(param.get("start"));
		int endCount = Integer.parseInt(param.get("end"));

		List<Object> olist = packageService.getListResult(startCount, endCount, "de");
		ArrayList<DpPackageVO> list = new ArrayList<DpPackageVO>();

		for (Object obj : olist) {
			list.add((DpPackageVO) obj);
		}
		mv.addObject("list", list);
		mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
		mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
		mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));

		mv.setViewName("/admin/admin_package/package_list_de");
		return mv;
	}

	// 커피 패키지 리스트
	@RequestMapping(value = "/admin/admin_package/package_list_cf.th", method = RequestMethod.GET)

	public ModelAndView package_list_cf(String rpage) {
		ModelAndView mv = new ModelAndView();
		Map<String, String> param = pageService.getPageResult2(rpage, "package_cf", packageService);

		int startCount = Integer.parseInt(param.get("start"));
		int endCount = Integer.parseInt(param.get("end"));

		List<Object> olist = packageService.getListResult(startCount, endCount, "cf");
		ArrayList<DpPackageVO> list = new ArrayList<DpPackageVO>();

		for (Object obj : olist) {
			list.add((DpPackageVO) obj);
		}
		mv.addObject("list", list);
		mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
		mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
		mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));

		mv.setViewName("/admin/admin_package/package_list_cf");
		return mv;
	}

	// 논커피 패키지 리스트
	@RequestMapping(value = "/admin/admin_package/package_list_ncf.th", method = RequestMethod.GET)

	public ModelAndView package_list_ncf(String rpage) {
		ModelAndView mv = new ModelAndView();
		Map<String, String> param = pageService.getPageResult2(rpage, "package_ncf", packageService);

		int startCount = Integer.parseInt(param.get("start"));
		int endCount = Integer.parseInt(param.get("end"));

		List<Object> olist = packageService.getListResult(startCount, endCount, "ncf");
		ArrayList<DpPackageVO> list = new ArrayList<DpPackageVO>();

		for (Object obj : olist) {
			list.add((DpPackageVO) obj);
		}
		mv.addObject("list", list);
		mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
		mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
		mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));

		mv.setViewName("/admin/admin_package/package_list_ncf");
		return mv;
	}

	// 디저트 패키지 상세보기
	@RequestMapping(value = "/admin/admin_package/package_content_de.th", method = RequestMethod.GET)
	public ModelAndView package_content_de(String pnum, String rno) {
		ModelAndView mv = new ModelAndView();
		/* packageService.getUpdateHits(pnum); */
		DpPackageVO vo = (DpPackageVO) packageService.getContent(pnum);

		mv.addObject("pnum", pnum);
		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		mv.setViewName("/admin/admin_package/package_content_de");
		return mv;
	}

	// 커피 패키지 상세보기
	@RequestMapping(value = "/admin/admin_package/package_content_cf.th", method = RequestMethod.GET)
	public ModelAndView package_content_cf(String pnum, String rno) {
		ModelAndView mv = new ModelAndView();
		/* packageService.getUpdateHits(pnum); */
		DpPackageVO vo = (DpPackageVO) packageService.getContent(pnum);

		mv.addObject("pnum", pnum);
		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		mv.setViewName("/admin/admin_package/package_content_cf");
		return mv;
	}

	// 논커피 패키지 상세보기
	@RequestMapping(value = "/admin/admin_package/package_content_ncf.th", method = RequestMethod.GET)
	public ModelAndView package_content_ncf(String pnum, String rno) {
		ModelAndView mv = new ModelAndView();
		/* packageService.getUpdateHits(pnum); */
		DpPackageVO vo = (DpPackageVO) packageService.getContent(pnum);

		mv.addObject("pnum", pnum);
		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		mv.setViewName("/admin/admin_package/package_content_ncf");
		return mv;
	}

	// 디저트 패키지 삭제처리
	@RequestMapping(value = "/admin/admin_package/package_content_de.th", method = RequestMethod.POST)
	public ModelAndView package_delete_de(DpPackageVO vo, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		String psfile = packageService.getFilename(vo.getPnum());
		int result = packageService.getDeleteResult(vo.getPnum());

		if (result == 1) {
			if (psfile != null) {
				String path = request.getSession().getServletContext().getRealPath("/");
				path += "resources\\upload\\";
				File file = new File(path + psfile);
				if (file.exists())
					file.delete();
			}
			mv.setViewName("redirect:/admin/admin_package/package_list_de.th");
		}
		return mv;
	}

	// 커피 패키지 삭제처리
	@RequestMapping(value = "/admin/admin_package/package_content_cf.th", method = RequestMethod.POST)
	public ModelAndView package_delete_cf(DpPackageVO vo, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		String psfile = packageService.getFilename(vo.getPnum());
		int result = packageService.getDeleteResult(vo.getPnum());

		if (result == 1) {
			if (psfile != null) {
				String path = request.getSession().getServletContext().getRealPath("/");
				path += "resources\\upload\\";
				File file = new File(path + psfile);
				if (file.exists())
					file.delete();
			}
			mv.setViewName("redirect:/admin/admin_package/package_list_cf.th");
		}
		return mv;
	}

	// 논커피 패키지 삭제처리
	@RequestMapping(value = "/admin/admin_package/package_content_ncf.th", method = RequestMethod.POST)
	public ModelAndView package_delete_ncf(DpPackageVO vo, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		String psfile = packageService.getFilename(vo.getPnum());
		int result = packageService.getDeleteResult(vo.getPnum());

		if (result == 1) {
			if (psfile != null) {
				String path = request.getSession().getServletContext().getRealPath("/");
				path += "resources\\upload\\";
				File file = new File(path + psfile);
				if (file.exists())
					file.delete();
			}
			mv.setViewName("redirect:/admin/admin_package/package_list_ncf.th");
		}
		return mv;
	}

//		
//		
//		//댓글 등록폼 - 커피
//		@RequestMapping(value="/admin/admin_recipe/recipe_write_cf.th", method=RequestMethod.GET)
//		public ModelAndView comment_write_cf() {
//			ModelAndView mv = new ModelAndView();
//			mv.setViewName("/admin/admin_recipe/recipe_write_cf");
//			return mv;
//		}
//		
//
//		//댓글 등록 기능 - 커피
//		 @RequestMapping(value="/admin/admin_recipe/recipe_content_cf.th",method=RequestMethod.POST) 
//		 public ModelAndView comment_write_cf(DpCommentVO vo,	 HttpServletRequest request) throws Exception{
//		  
//			 ModelAndView mv = new ModelAndView();
//			 
//			 int result = commentService.getInsertResult(vo); 
//			 if(result == 1) {
//			 mv.setViewName("redirect:/admin/admin_recipe/recipe_content_cf.th"); 
//			 }else {
//			 //에러페이지 
//			 } return mv;
//		  
//		  }
//		
//		//댓글 리스트 - 커피
//		@RequestMapping(value = "/admin/admin_recipe/recipe_content_cf.th", method = RequestMethod.GET)
//		public ModelAndView comment_list_cf(String rpage) {
//			ModelAndView mv = new ModelAndView();
//			Map<String, String> param = pageService.getPageResult3(rpage, "comment", commentService);
//			int startCount = Integer.parseInt(param.get("start"));
//			int endCount = Integer.parseInt(param.get("end"));
//			List<Object> olist = commentService.getListResult(startCount, endCount);
//			ArrayList<DpCommentVO> list = new ArrayList<DpCommentVO>();
//			for (Object obj : olist) {
//				list.add((DpCommentVO) obj);
//			}
//
//			mv.addObject("list", list);
//			mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
//			mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
//			mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));
//
//			mv.setViewName("/admin/admin_recipe/recipe_content_cf");
//			return mv;
//		}
//		
//		
//		

}
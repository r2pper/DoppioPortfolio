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

	/** * ������ ȸ������������ (����Ʈ) */
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

	/** * ������ ȸ������ �������� */
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
	//���� ����Ʈ �˻�
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
	//���� ����Ʈ
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
	
	//���� �󼼺���
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
	
	
	//���� �����
	@RequestMapping(value="/admin/admin_notice/notice_write.th", method=RequestMethod.GET)
	public ModelAndView notice_write() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/admin_notice/notice_write");
		return mv;
	}

	//������ ��� ó��
	@RequestMapping(value="/admin/admin_notice/notice_write.th", method=RequestMethod.POST)
	public String notice_write(DpNoticeVO vo, HttpServletRequest request) throws Exception{
			
			String result_page = "";		
			
			vo = fileService.fileCheck(vo);
			int result = noticeService.getInsertResult(vo);
			
			if(result == 1) {
				fileService.fileSave(vo,request);					
				result_page = "redirect:/admin/admin_notice/notice_list.th";
				
			}else {
				//���������� ȣ��
			}		
			
			return result_page;
	}
	
	
	//������ ������
	@RequestMapping(value="/admin/admin_notice/notice_update.th", method=RequestMethod.GET)
	public ModelAndView notice_update(String nnum, String rno) {
		ModelAndView mv = new ModelAndView();
		DpNoticeVO vo = (DpNoticeVO)noticeService.getContent(nnum);
		
		mv.addObject("vo",vo);
		mv.addObject("rno",rno);
		mv.setViewName("/admin/admin_notice/notice_update");
		
		return mv;
	}
	
	//������ ���� ó��
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
			//���������� ȣ��
		}
		
		return mv;
	}
	
	//������ ����ó��
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
			//���������� ȣ��
		}		
		
		return mv;
	}
	
	
	
	//-----------------------ORDER--------------------------------//
	
	//�ֹ� ����
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
	
	
	
	
	
	
	
	
	

	/* ������ ������ */
	// ������ ����ó�� - Ŀ��
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

	// ������ ����ó�� - ��Ŀ��
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

	// ������ ����ó�� - ����Ʈ
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

	// ������ ������Ʈ �� - Ŀ��
	@RequestMapping(value = "/admin/admin_recipe/recipe_update_cf.th", method = RequestMethod.GET)
	public ModelAndView recipe_update_cf(String rnum, String rno) {
		ModelAndView mv = new ModelAndView();
		DpRecipeVO vo = (DpRecipeVO) recipeService.getContent(rnum);

		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		mv.setViewName("/admin/admin_recipe/recipe_update_cf");
		return mv;
	}

	// ������ ������Ʈ �� - ��Ŀ��
	@RequestMapping(value = "/admin/admin_recipe/recipe_update_ncf.th", method = RequestMethod.GET)
	public ModelAndView recipe_update_ncf(String rnum, String rno) {
		ModelAndView mv = new ModelAndView();
		DpRecipeVO vo = (DpRecipeVO) recipeService.getContent(rnum);

		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		mv.setViewName("/admin/admin_recipe/recipe_update_ncf");
		return mv;
	}

	// ������ ������Ʈ �� - ����Ʈ
	@RequestMapping(value = "/admin/admin_recipe/recipe_update_de.th", method = RequestMethod.GET)
	public ModelAndView recipe_update_de(String rnum, String rno) {
		ModelAndView mv = new ModelAndView();
		DpRecipeVO vo = (DpRecipeVO) recipeService.getContent(rnum);

		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		mv.setViewName("/admin/admin_recipe/recipe_update_de");
		return mv;
	}

	// ������ ������Ʈ ó�� - Ŀ��
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
			// ���������� ȣ��
		}

		return mv;
	}

	// ������ ������Ʈ ó�� - ��Ŀ��
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
			// ���������� ȣ��
		}

		return mv;
	}

	// ������ ������Ʈ ó�� - ����Ʈ
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
			// ���������� ȣ��
		}

		return mv;
	}

	// ������ ����� - Ŀ��
	@RequestMapping(value = "/admin/admin_recipe/recipe_write_cf.th", method = RequestMethod.GET)
	public ModelAndView recipe_write_cf() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/admin_recipe/recipe_write_cf");
		return mv;
	}

	// ������ ����� - ��Ŀ��
	@RequestMapping(value = "/admin/admin_recipe/recipe_write_ncf.th", method = RequestMethod.GET)
	public ModelAndView recipe_write_ncf() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/admin_recipe/recipe_write_ncf");
		return mv;
	}

	// ������ ����� - ����Ʈ
	@RequestMapping(value = "/admin/admin_recipe/recipe_write_de.th", method = RequestMethod.GET)
	public ModelAndView recipe_write_de() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/admin_recipe/recipe_write_de");
		return mv;
	}

	// ������ ���ó�� - Ŀ��
	@RequestMapping(value = "/admin/admin_recipe/recipe_write_cf.th", method = RequestMethod.POST)
	public String recipe_write_cf(DpRecipeVO vo, HttpServletRequest request) throws Exception {

		String result_page = "";

		vo = fileService.fileCheck(vo);
		int result = recipeService.getInsertResult(vo);

		if (result == 1) {
			fileService.fileSave(vo, request);
			result_page = "redirect:/admin/admin_recipe/recipe_list_cf.th";
		} else {
			// ���������� ȣ��
		}
		return result_page;
	}

	// ������ ���ó�� - ��Ŀ��
	@RequestMapping(value = "/admin/admin_recipe/recipe_write_ncf.th", method = RequestMethod.POST)
	public String recipe_write_ncf(DpRecipeVO vo, HttpServletRequest request) throws Exception {

		String result_page = "";

		vo = fileService.fileCheck(vo);
		int result = recipeService.getInsertResult(vo);

		if (result == 1) {
			fileService.fileSave(vo, request);
			result_page = "redirect:/admin/admin_recipe/recipe_list_ncf.th";
		} else {
			// ���������� ȣ��
		}
		return result_page;
	}

	// ������ ���ó�� - ����Ʈ
	@RequestMapping(value = "/admin/admin_recipe/recipe_write_de.th", method = RequestMethod.POST)
	public String recipe_write_de(DpRecipeVO vo, HttpServletRequest request) throws Exception {

		String result_page = "";

		vo = fileService.fileCheck(vo);
		int result = recipeService.getInsertResult(vo);

		if (result == 1) {
			fileService.fileSave(vo, request);
			result_page = "redirect:/admin/admin_recipe/recipe_list_de.th";
		} else {
			// ���������� ȣ��
		}
		return result_page;

	}

	/* recipe_list ������ ����Ʈ - ����Ʈ */
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

	/* recipe_list ������ ����Ʈ - Ŀ�� */
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

	/* recipe_list ������ ����Ʈ - ��Ŀ�� */
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

	

	// ������ �������� - Ŀ�� + ��۸���Ʈ
	
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
	 

	// ������ �������� - Ŀ�� - ��۵��
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

	// ������ �������� - Ŀ�� - ��ۼ���
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
	
	// ������ �������� - Ŀ�� - ��ۻ���
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
	
	
	
	
	
	
	

	// ������ �������� - ��Ŀ��
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
	
	// ������ �������� - ��Ŀ�� - ��۵��
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

	// ������ �������� - ��Ŀ�� - ��ۼ���
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
	
	// ������ �������� - ��Ŀ�� - ��ۻ���
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
	
	
	
	
	
	
	
	// ������ �������� - ����Ʈ
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
	// ������ �������� - ����Ʈ - ��۵��
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

		// ������ �������� - ����Ʈ - ��ۼ���
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
		
		// ������ �������� - ����Ʈ - ��ۻ���
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

	/* ������ ��Ű�� */

	// ����Ʈ ��Ű�� ������Ʈ ��
	@RequestMapping(value = "/admin/admin_package/package_update_de.th", method = RequestMethod.GET)
	public ModelAndView package_update_de(String pnum, String rno) {

		ModelAndView mv = new ModelAndView();
		DpPackageVO vo = (DpPackageVO) packageService.getContent(pnum);

		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		mv.setViewName("/admin/admin_package/package_update_de");

		return mv;
	}

	// Ŀ�� ��Ű�� ������Ʈ ��
	@RequestMapping(value = "/admin/admin_package/package_update_cf.th", method = RequestMethod.GET)
	public ModelAndView package_update_cf(String pnum, String rno) {

		ModelAndView mv = new ModelAndView();
		DpPackageVO vo = (DpPackageVO) packageService.getContent(pnum);

		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		mv.setViewName("/admin/admin_package/package_update_cf");

		return mv;
	}

	// ��Ŀ�� ��Ű�� ������Ʈ ��
	@RequestMapping(value = "/admin/admin_package/package_update_ncf.th", method = RequestMethod.GET)
	public ModelAndView package_update_ncf(String pnum, String rno) {

		ModelAndView mv = new ModelAndView();
		DpPackageVO vo = (DpPackageVO) packageService.getContent(pnum);

		mv.addObject("vo", vo);
		mv.addObject("rno", rno);
		mv.setViewName("/admin/admin_package/package_update_ncf");

		return mv;
	}

	// ����Ʈ ��Ű�� ������Ʈ ó��
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
			// ���������� ȣ��
		}

		return mv;
	}

	// Ŀ�� ��Ű�� ������Ʈ ó��
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
			// ���������� ȣ��
		}

		return mv;
	}

	// ��Ŀ�� ��Ű�� ������Ʈ ó��
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
			// ���������� ȣ��
		}

		return mv;
	}

	// ����Ʈ ��Ű�� �����
	@RequestMapping(value = "/admin/admin_package/package_write_de.th", method = RequestMethod.GET)
	public ModelAndView package_write_de() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/admin_package/package_write_de");
		return mv;
	}

	// Ŀ�� ��Ű�� �����
	@RequestMapping(value = "/admin/admin_package/package_write_cf.th", method = RequestMethod.GET)
	public ModelAndView package_write_cf() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/admin_package/package_write_cf");
		return mv;
	}

	// ��Ŀ�� ��Ű�� �����
	@RequestMapping(value = "/admin/admin_package/package_write_ncf.th", method = RequestMethod.GET)
	public ModelAndView package_write_ncf() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/admin_package/package_write_ncf");
		return mv;
	}

	// ����Ʈ ��Ű�� ���ó��
	@RequestMapping(value = "/admin/admin_package/package_write_de.th", method = RequestMethod.POST)
	public String package_write_de(DpPackageVO vo, HttpServletRequest request) throws Exception {

		String result_page = "";

		vo = fileService.fileCheck(vo);
		int result = packageService.getInsertResult(vo);

		if (result == 1) {
			fileService.fileSave(vo, request);
			result_page = "redirect:/admin/admin_package/package_list_de.th";
		} else {
			// ���������� ȣ��
		}
		return result_page;
	}

	// Ŀ�� ��Ű�� ���ó��
	@RequestMapping(value = "/admin/admin_package/package_write_cf.th", method = RequestMethod.POST)
	public String package_write_cf(DpPackageVO vo, HttpServletRequest request) throws Exception {

		String result_page = "";

		vo = fileService.fileCheck(vo);
		int result = packageService.getInsertResult(vo);

		if (result == 1) {
			fileService.fileSave(vo, request);
			result_page = "redirect:/admin/admin_package/package_list_cf.th";
		} else {
			// ���������� ȣ��
		}
		return result_page;
	}

	// ��Ŀ�� ��Ű�� ���ó��
	@RequestMapping(value = "/admin/admin_package/package_write_ncf.th", method = RequestMethod.POST)
	public String package_write_ncf(DpPackageVO vo, HttpServletRequest request) throws Exception {

		String result_page = "";

		vo = fileService.fileCheck(vo);
		int result = packageService.getInsertResult(vo);

		if (result == 1) {
			fileService.fileSave(vo, request);
			result_page = "redirect:/admin/admin_package/package_list_ncf.th";
		} else {
			// ���������� ȣ��
		}
		return result_page;
	}

	// ����Ʈ ��Ű�� ����Ʈ
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

	// Ŀ�� ��Ű�� ����Ʈ
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

	// ��Ŀ�� ��Ű�� ����Ʈ
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

	// ����Ʈ ��Ű�� �󼼺���
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

	// Ŀ�� ��Ű�� �󼼺���
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

	// ��Ŀ�� ��Ű�� �󼼺���
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

	// ����Ʈ ��Ű�� ����ó��
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

	// Ŀ�� ��Ű�� ����ó��
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

	// ��Ŀ�� ��Ű�� ����ó��
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
//		//��� ����� - Ŀ��
//		@RequestMapping(value="/admin/admin_recipe/recipe_write_cf.th", method=RequestMethod.GET)
//		public ModelAndView comment_write_cf() {
//			ModelAndView mv = new ModelAndView();
//			mv.setViewName("/admin/admin_recipe/recipe_write_cf");
//			return mv;
//		}
//		
//
//		//��� ��� ��� - Ŀ��
//		 @RequestMapping(value="/admin/admin_recipe/recipe_content_cf.th",method=RequestMethod.POST) 
//		 public ModelAndView comment_write_cf(DpCommentVO vo,	 HttpServletRequest request) throws Exception{
//		  
//			 ModelAndView mv = new ModelAndView();
//			 
//			 int result = commentService.getInsertResult(vo); 
//			 if(result == 1) {
//			 mv.setViewName("redirect:/admin/admin_recipe/recipe_content_cf.th"); 
//			 }else {
//			 //���������� 
//			 } return mv;
//		  
//		  }
//		
//		//��� ����Ʈ - Ŀ��
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
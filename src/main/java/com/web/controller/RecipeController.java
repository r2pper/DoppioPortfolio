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
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.dao.DpCommentDAO;
import com.web.service.DpCommentServiceImpl;
import com.web.service.DpPageServiceImpl;
import com.web.service.DpRecipeServiceImpl;
import com.web.vo.DpCommentVO;
import com.web.vo.DpRecipeVO;
 

	@Controller
	public class RecipeController { 
		 
		@Autowired
		private DpRecipeServiceImpl recipeService;
		
		@Autowired
		private DpPageServiceImpl pageService;
		
		@Autowired
		private DpCommentServiceImpl commentService;

		@Autowired
		private DpCommentDAO commentDao;
	
		/*recipe_list 레시피 리스트  - 디저트*/		
		@RequestMapping(value="/recipe/recipe_list_de.th", method=RequestMethod.GET)
		public ModelAndView recipe_list(String rpage) {
			ModelAndView mv = new ModelAndView();
			Map<String, String> param = pageService.getPageResult2(rpage, "recipe_de", recipeService);
			int startCount = Integer.parseInt(param.get("start"));
			int endCount = Integer.parseInt(param.get("end"));
			List<Object> olist = recipeService.getListResult(startCount, endCount, "de");
			ArrayList<DpRecipeVO> list = new ArrayList<DpRecipeVO>();
			for(Object obj : olist) {
				list.add((DpRecipeVO)obj);
			}
			mv.addObject("list", list);
			mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
			mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
			mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));
			
			mv.setViewName("/recipe/recipe_list_de");
			return mv;
		}
		/*recipe_list 레시피 리스트 - 커피*/		
		@RequestMapping(value="/recipe/recipe_list_cf.th", method=RequestMethod.GET)
		public ModelAndView recipe_list_cf(String rpage) {
			ModelAndView mv = new ModelAndView();
			Map<String, String> param = pageService.getPageResult2(rpage, "recipe_cf", recipeService);
			int startCount = Integer.parseInt(param.get("start"));
			int endCount = Integer.parseInt(param.get("end"));
			List<Object> olist = recipeService.getListResult(startCount, endCount, "cf");
			ArrayList<DpRecipeVO> list = new ArrayList<DpRecipeVO>();
			for(Object obj : olist) {
				list.add((DpRecipeVO)obj);
			}
			mv.addObject("list", list);
			mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
			mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
			mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));
			
			mv.setViewName("/recipe/recipe_list_cf");
			return mv;
		}
		/*recipe_list 레시피 리스트 - 논커피*/		
		@RequestMapping(value="/recipe/recipe_list_ncf.th", method=RequestMethod.GET)
		public ModelAndView recipe_list_ncf(String rpage) {
			ModelAndView mv = new ModelAndView();
			Map<String, String> param = pageService.getPageResult2(rpage, "recipe_ncf", recipeService);
			int startCount = Integer.parseInt(param.get("start"));
			int endCount = Integer.parseInt(param.get("end"));
			List<Object> olist = recipeService.getListResult(startCount, endCount,"ncf");
			ArrayList<DpRecipeVO> list = new ArrayList<DpRecipeVO>();
			for(Object obj : olist) {
				list.add((DpRecipeVO)obj);
			}
			mv.addObject("list", list);
			mv.addObject("dbCount", Integer.parseInt(param.get("dbCount")));
			mv.addObject("pageSize", Integer.parseInt(param.get("pageSize")));
			mv.addObject("reqPage", Integer.parseInt(param.get("reqPage")));
			
			mv.setViewName("/recipe/recipe_list_ncf");
			return mv;
		}
		
		//레시피 상세페이지 - 디저트
		@RequestMapping(value="/recipe/recipe_content_de.th", method=RequestMethod.GET)
		public ModelAndView recipe_content_de(String rnum, String rno, String rpage) {
			ModelAndView mv = new ModelAndView();
			recipeService.getUpdateHits(rnum);
			DpRecipeVO vo = (DpRecipeVO)recipeService.getContent(rnum);
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
		    mv.setViewName("/recipe/recipe_content_de"); 
		    return mv;
			
		}
		
		//레시피 상세페이지 - 커피
		@RequestMapping(value="/recipe/recipe_content_cf.th", method=RequestMethod.GET)
		public ModelAndView recipe_content_cf(String rnum, String rno,String rpage) {
			ModelAndView mv = new ModelAndView();
			recipeService.getUpdateHits(rnum);
			DpRecipeVO vo = (DpRecipeVO)recipeService.getContent(rnum);
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
		    mv.setViewName("/recipe/recipe_content_cf"); 
		    return mv;
		}
			
		//레시피 상세페이지 - 논커피
		@RequestMapping(value="/recipe/recipe_content_ncf.th", method=RequestMethod.GET)
		public ModelAndView recipe_content_ncf(String rnum, String rno,String rpage) {
			ModelAndView mv = new ModelAndView();
			recipeService.getUpdateHits(rnum);
			DpRecipeVO vo = (DpRecipeVO)recipeService.getContent(rnum);
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
		    mv.setViewName("/recipe/recipe_content_ncf"); 
		    return mv;
		}	
		
	
		
		 

		// 레시피 상세페이지 - 커피 - 댓글등록
		@SuppressWarnings("unchecked")
		@RequestMapping(value = "/recipe/recipe_content_cf_cmtWrite.th", method = RequestMethod.POST)
		public ModelAndView recipe_content_cf_write(@RequestBody String vo, HttpServletRequest request) throws Exception {

			ModelAndView mv = new ModelAndView();

			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> param = mapper.readValue(vo, Map.class);
			int s = commentDao.insert(param);

			if (s >= 1) {
				mv.setViewName("/recipe/recipe_content_cf");
			}
			return mv;
		}

		// 레시피 상세페이지 - 커피 - 댓글수정
		@SuppressWarnings("unchecked")
		@RequestMapping(value = "/recipe/recipe_content_cf_cmtUpdate.th", method = RequestMethod.POST)
		public ModelAndView recipe_content_cf_update(@RequestBody String vo, HttpServletRequest request) throws Exception {

			ModelAndView mv = new ModelAndView();

			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> param = mapper.readValue(vo, Map.class);
			int s = commentDao.update(param);

			if (s >= 1) {
				mv.setViewName("/recipe/recipe_content_cf");			
			} 
			return mv;
		}
		
		// 레시피 상세페이지 - 커피 - 댓글삭제
		@SuppressWarnings("unchecked")
		@RequestMapping(value = "/recipe/recipe_content_cf_cmtDelete.th", method = RequestMethod.POST)
		public ModelAndView recipe_content_cf_delete(@RequestBody String vo, HttpServletRequest request) throws Exception {

			ModelAndView mv = new ModelAndView();

			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> param = mapper.readValue(vo, Map.class);
			int s = commentDao.delete(param);

			if (s >= 1) {
				mv.setViewName("/recipe/recipe_content_cf");			
			} 
			return mv;
		}
		
		
		
		
		
		
		
		
		// 레시피 상세페이지 - 논커피 - 댓글등록
		@SuppressWarnings("unchecked")
		@RequestMapping(value = "/recipe/recipe_content_ncf_cmtWrite.th", method = RequestMethod.POST)
		public ModelAndView recipe_content_ncf_write(@RequestBody String vo, HttpServletRequest request) throws Exception {

			ModelAndView mv = new ModelAndView();

			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> param = mapper.readValue(vo, Map.class);
			int s = commentDao.insert(param);

			if (s >= 1) {
				mv.setViewName("/recipe/recipe_content_ncf");
			}
			return mv;
		}

		// 레시피 상세페이지 - 논커피 - 댓글수정
		@SuppressWarnings("unchecked")
		@RequestMapping(value = "/recipe/recipe_ncf_cmtUpdate.th", method = RequestMethod.POST)
		public ModelAndView recipe_content_ncf_update(@RequestBody String vo, HttpServletRequest request) throws Exception {

			ModelAndView mv = new ModelAndView();

			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> param = mapper.readValue(vo, Map.class);
			int s = commentDao.update(param);

			if (s >= 1) {
				mv.setViewName("/recipe/recipe_content_ncf");			
			} 
			return mv;
		}
		
		// 레시피 상세페이지 - 논커피 - 댓글삭제
		@SuppressWarnings("unchecked")
		@RequestMapping(value = "/recipe/recipe_content_ncf_cmtDelete.th", method = RequestMethod.POST)
		public ModelAndView recipe_content_ncf_delete(@RequestBody String vo, HttpServletRequest request) throws Exception {

			ModelAndView mv = new ModelAndView();

			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> param = mapper.readValue(vo, Map.class);
			int s = commentDao.delete(param);

			if (s >= 1) {
				mv.setViewName("/recipe/recipe_content_ncf");			
			} 
			return mv;
		}
		
		
		
		
		
		
		
		// 레시피 상세페이지 - 디저트 - 댓글등록
			@SuppressWarnings("unchecked")
			@RequestMapping(value = "/recipe/recipe_content_de_cmtWrite.th", method = RequestMethod.POST)
			public ModelAndView recipe_content_de_write(@RequestBody String vo, HttpServletRequest request) throws Exception {

				ModelAndView mv = new ModelAndView();

				ObjectMapper mapper = new ObjectMapper();
				Map<String, Object> param = mapper.readValue(vo, Map.class);
				int s = commentDao.insert(param);

				if (s >= 1) {
					mv.setViewName("/recipe/recipe_content_de");
				}
				return mv;
			}

			// 레시피 상세페이지 - 디저트 - 댓글수정
			@SuppressWarnings("unchecked")
			@RequestMapping(value = "/recipe/recipe_content_de_cmtUpdate.th", method = RequestMethod.POST)
			public ModelAndView recipe_content_de_update(@RequestBody String vo, HttpServletRequest request) throws Exception {

				ModelAndView mv = new ModelAndView();

				ObjectMapper mapper = new ObjectMapper();
				Map<String, Object> param = mapper.readValue(vo, Map.class);
				int s = commentDao.update(param);

				if (s >= 1) {
					mv.setViewName("/recipe/recipe_content_de");			
				} 
				return mv;
			}
			
			// 레시피 상세페이지 - 디저트 - 댓글삭제
			@SuppressWarnings("unchecked")
			@RequestMapping(value = "/recipe/recipe_content_de_cmtDelete.th", method = RequestMethod.POST)
			public ModelAndView recipe_content_de_delete(@RequestBody String vo, HttpServletRequest request) throws Exception {

				ModelAndView mv = new ModelAndView();

				ObjectMapper mapper = new ObjectMapper();
				Map<String, Object> param = mapper.readValue(vo, Map.class);
				int s = commentDao.delete(param);

				if (s >= 1) {
					mv.setViewName("/recipe/recipe_content_de");			
				} 
				return mv;
			}
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

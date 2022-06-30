package com.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.service.DpCommentService;
import com.web.vo.DpRecipeVO;

public class CommentController {
	
	@Autowired
	private DpCommentService commentService;
	
//	//레시피 상세페이지 - 커피 - 댓글등록
//	@RequestMapping(value="/admin/admin_recipe/recipe_content_cf.th", method=RequestMethod.POST)
//	public ModelAndView recipe_content_cf_write(DpRecipeVO vo, HttpServletRequest request) throws Exception{
//		ModelAndView mv = new ModelAndView();
//		
//		
//		int result = commentService.getInsertResult(vo);
//		/* System.out.println("rnum -----> " + param.get("rnum")); */
//		
//		
//		 if(result == 1) { 
//			 mv.setViewName("redirect:/admin/admin_recipe/recipe_content_cf.th?rno="+vo.getRno());
//		 }else { 
//			 //에러페이지 
//		}
//		
//		return mv;
//	}
	
}

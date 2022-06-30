package com.web.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class DpPageServiceImpl{
	@Autowired
	private DpMemberServiceImpl memberService;
	
	@Autowired
	private DpQnaServiceImpl qnaService;
	
	@Autowired
	private DpBoardServiceImpl boardService;
	
	@Autowired
	private DpNoticeServiceImpl noticeService;
	
	@Autowired
	private DpRecipeServiceImpl recipeService;
	
	@Autowired
	private DpPackageServiceImpl packageService;
	
	@Autowired
	private DpCommentServiceImpl commentService;
	
	@Autowired
	private DpCartServiceImpl cartService;
	
	@Autowired
	private DpOrderServiceImpl orderService;
	
	/**
	 * 페이징 처리
	 */
	
	public Map<String, String> getPageResult(String rpage, String serviceName, DpObjectService service) {
		Map<String, String> param = new HashMap<String,String>();
		
		//페이징 처리 - startCount, endCount 구하기
		int startCount = 0;
		int endCount = 0;
		int pageSize = 5;	//한페이지당 게시물 수
		int reqPage = 1;	//요청페이지	
		int pageCount = 1;	//전체 페이지 수
		int dbCount = 0;    //DB에서 가져온 전체 행수
		
		if(serviceName.equals("qna")) {
			qnaService = (DpQnaServiceImpl)service;
			dbCount = qnaService.getListCount();
		}
		
		if(serviceName.equals("board")) {
			boardService = (DpBoardServiceImpl)service;
			dbCount = boardService.getListCount();
		} 
		
		if(serviceName.equals("notice")) {
			noticeService = (DpNoticeServiceImpl)service;
			dbCount = noticeService.getListCount();
		}
		
		if(serviceName.equals("cart_list")) {
			cartService = (DpCartServiceImpl)service;
			dbCount = cartService.getListCount();
		}
		
		if(serviceName.equals("order_list")) {
			orderService = (DpOrderServiceImpl)service;
			dbCount = orderService.getListCount();
		}
		
		
		
		//총 페이지 수 계산
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		}else{
			pageCount = dbCount/pageSize+1;
		}
		
		//요청 페이지 계산
		if(rpage != null){
			reqPage = Integer.parseInt(rpage);
			startCount = (reqPage-1) * pageSize+1;
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = pageSize;
		}
		
		param.put("start", String.valueOf(startCount));
		param.put("end", String.valueOf(endCount));	
		param.put("dbCount", String.valueOf(dbCount));
		param.put("pageSize", String.valueOf(pageSize));
		param.put("reqPage", String.valueOf(reqPage));
		
		return param;
	}
	
	
	
	public Map<String, String> getPageResult2(String rpage, String serviceName, DpObjectService service){
		Map<String, String> param = new HashMap<String,String>();
		
		//페이징 처리 - startCount, endCount 구하기
				int startCount = 0;
				int endCount = 0;
				int pageSize = 6;	//한페이지당 게시물 수
				int reqPage = 1;	//요청페이지	
				int pageCount = 1;	//전체 페이지 수
				int dbCount = 0;    //DB에서 가져온 전체 행수
		
		
		if(serviceName.equals("recipe_cf")) {
			recipeService = (DpRecipeServiceImpl)service;
			dbCount = recipeService.getTotalPage("cf");
		} 
		if(serviceName.equals("recipe_ncf")) {
			recipeService = (DpRecipeServiceImpl)service;
			dbCount = recipeService.getTotalPage("ncf");
		} 
		if(serviceName.equals("recipe_de")) {
			recipeService = (DpRecipeServiceImpl)service;
			dbCount = recipeService.getTotalPage("de");
		} 
		
		if(serviceName.equals("package_cf")) {
			packageService = (DpPackageServiceImpl)service;
			dbCount = packageService.getTotalPage("cf");
		}
		
		if(serviceName.equals("package_ncf")) {
			packageService = (DpPackageServiceImpl)service;
			dbCount = packageService.getTotalPage("ncf");
		} 
		
		if(serviceName.equals("package_de")) {
			packageService = (DpPackageServiceImpl)service;
			dbCount = packageService.getTotalPage("de");
		}
		
		//총 페이지 수 계산
				if(dbCount % pageSize == 0){
					pageCount = dbCount/pageSize;
				}else{
					pageCount = dbCount/pageSize+1;
				}
				
				//요청 페이지 계산
				if(rpage != null){
					reqPage = Integer.parseInt(rpage);
					startCount = (reqPage-1) * pageSize+1;
					endCount = reqPage *pageSize;
				}else{
					startCount = 1;
					endCount = pageSize;
				}
				
				param.put("start", String.valueOf(startCount));
				param.put("end", String.valueOf(endCount));	
				param.put("dbCount", String.valueOf(dbCount));
				param.put("pageSize", String.valueOf(pageSize));
				param.put("reqPage", String.valueOf(reqPage));
				
				return param;
	}
	
	public Map<String, String> getPageResult3(String rpage, String serviceName, DpObjectService service){
		Map<String, String> param = new HashMap<String,String>();
		
		//페이징 처리 - startCount, endCount 구하기
				int startCount = 0;
				int endCount = 0;
				int pageSize = 10;	//한페이지당 게시물 수
				int reqPage = 1;	//요청페이지	
				int pageCount = 1;	//전체 페이지 수
				int dbCount = 0;    //DB에서 가져온 전체 행수
		
		
		if(serviceName.equals("member")) {
			memberService = (DpMemberServiceImpl)service;
			dbCount = memberService.getListCount();
		} 
				
		
		if(serviceName.equals("comment")) {
			commentService = (DpCommentServiceImpl)service;
			dbCount = commentService.getListCount();
		} 
		
		
		//총 페이지 수 계산
				if(dbCount % pageSize == 0){
					pageCount = dbCount/pageSize;
				}else{
					pageCount = dbCount/pageSize+1;
				}
				
				//요청 페이지 계산
				if(rpage != null){
					reqPage = Integer.parseInt(rpage);
					startCount = (reqPage-1) * pageSize+1;
					endCount = reqPage *pageSize;
				}else{
					startCount = 1;
					endCount = pageSize;
				}
				
				param.put("start", String.valueOf(startCount));
				param.put("end", String.valueOf(endCount));	
				param.put("dbCount", String.valueOf(dbCount));
				param.put("pageSize", String.valueOf(pageSize));
				param.put("reqPage", String.valueOf(reqPage));
				
				return param;
	}
	
	public Map<String, String> getPageResult4(String rpage, String serviceName, DpObjectService service){
		Map<String, String> param = new HashMap<String,String>();
		
		//페이징 처리 - startCount, endCount 구하기
				int startCount = 0;
				int endCount = 0;
				int pageSize = 10;	//한페이지당 게시물 수
				int reqPage = 1;	//요청페이지	
				int pageCount = 1;	//전체 페이지 수
				int dbCount = 0;    //DB에서 가져온 전체 행수
		
		
		if(serviceName.equals("main")) {
			boardService = (DpBoardServiceImpl)service;
			dbCount = boardService.getListCount();
		} 
				
		
		
		
		//총 페이지 수 계산
				if(dbCount % pageSize == 0){
					pageCount = dbCount/pageSize;
				}else{
					pageCount = dbCount/pageSize+1;
				}
				
				//요청 페이지 계산
				if(rpage != null){
					reqPage = Integer.parseInt(rpage);
					startCount = (reqPage-1) * pageSize+1;
					endCount = reqPage *pageSize;
				}else{
					startCount = 1;
					endCount = pageSize;
				}
				
				param.put("start", String.valueOf(startCount));
				param.put("end", String.valueOf(endCount));	
				param.put("dbCount", String.valueOf(dbCount));
				param.put("pageSize", String.valueOf(pageSize));
				param.put("reqPage", String.valueOf(reqPage));
				
				return param;
	}
	
	
	
	
}

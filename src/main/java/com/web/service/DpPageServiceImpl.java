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
	 * ����¡ ó��
	 */
	
	public Map<String, String> getPageResult(String rpage, String serviceName, DpObjectService service) {
		Map<String, String> param = new HashMap<String,String>();
		
		//����¡ ó�� - startCount, endCount ���ϱ�
		int startCount = 0;
		int endCount = 0;
		int pageSize = 5;	//���������� �Խù� ��
		int reqPage = 1;	//��û������	
		int pageCount = 1;	//��ü ������ ��
		int dbCount = 0;    //DB���� ������ ��ü ���
		
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
		
		
		
		//�� ������ �� ���
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		}else{
			pageCount = dbCount/pageSize+1;
		}
		
		//��û ������ ���
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
		
		//����¡ ó�� - startCount, endCount ���ϱ�
				int startCount = 0;
				int endCount = 0;
				int pageSize = 6;	//���������� �Խù� ��
				int reqPage = 1;	//��û������	
				int pageCount = 1;	//��ü ������ ��
				int dbCount = 0;    //DB���� ������ ��ü ���
		
		
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
		
		//�� ������ �� ���
				if(dbCount % pageSize == 0){
					pageCount = dbCount/pageSize;
				}else{
					pageCount = dbCount/pageSize+1;
				}
				
				//��û ������ ���
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
		
		//����¡ ó�� - startCount, endCount ���ϱ�
				int startCount = 0;
				int endCount = 0;
				int pageSize = 10;	//���������� �Խù� ��
				int reqPage = 1;	//��û������	
				int pageCount = 1;	//��ü ������ ��
				int dbCount = 0;    //DB���� ������ ��ü ���
		
		
		if(serviceName.equals("member")) {
			memberService = (DpMemberServiceImpl)service;
			dbCount = memberService.getListCount();
		} 
				
		
		if(serviceName.equals("comment")) {
			commentService = (DpCommentServiceImpl)service;
			dbCount = commentService.getListCount();
		} 
		
		
		//�� ������ �� ���
				if(dbCount % pageSize == 0){
					pageCount = dbCount/pageSize;
				}else{
					pageCount = dbCount/pageSize+1;
				}
				
				//��û ������ ���
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
		
		//����¡ ó�� - startCount, endCount ���ϱ�
				int startCount = 0;
				int endCount = 0;
				int pageSize = 10;	//���������� �Խù� ��
				int reqPage = 1;	//��û������	
				int pageCount = 1;	//��ü ������ ��
				int dbCount = 0;    //DB���� ������ ��ü ���
		
		
		if(serviceName.equals("main")) {
			boardService = (DpBoardServiceImpl)service;
			dbCount = boardService.getListCount();
		} 
				
		
		
		
		//�� ������ �� ���
				if(dbCount % pageSize == 0){
					pageCount = dbCount/pageSize;
				}else{
					pageCount = dbCount/pageSize+1;
				}
				
				//��û ������ ���
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

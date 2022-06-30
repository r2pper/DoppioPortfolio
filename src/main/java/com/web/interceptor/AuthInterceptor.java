package com.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	
	/**
	 * This implementation always returns <code>true</code>.
	 */
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
									HttpServletResponse response, Object handler)
											throws Exception {
		
		//1. request 객체에서 세션정보 얻어오기
		HttpSession session = request.getSession();
		String sid = (String)session.getAttribute("sid");
		//2. 세션정보 체크 및 페이지 이동
		if(sid == null) {
			//response.sendRedirect("http://localhost:9000/mycgv/login.do");
			response.sendRedirect("http://localhost:9000/doppio/login/doppio_login.th?auth_result=fail");
			return false;
		}
		
		return true;
	}

}

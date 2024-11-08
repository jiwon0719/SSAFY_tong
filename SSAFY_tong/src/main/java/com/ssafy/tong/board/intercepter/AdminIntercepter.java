package com.ssafy.tong.board.intercepter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class AdminIntercepter implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		request.getMethod(); // 내가 어떤 방식으로 들어왔는지를 확인 GET, POST, PUT... 
		"GET".equalsIgnoreCase(request.getMethod()); // 길이, 문자 확인하는 친구
		
		if(!"admin".equals(session.getAttribute("loginUser"))) { // 순서에 따라서도 null 잡을 수 있다. 
			response.sendRedirect("list");
			return false;
		}
		return true;
	}
}
// 인터셉트 적용을 위해서는 설정파일 필요하다. 
package org.suhtapps.springintercepter.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.suhtapps.springintercepter.demo.exception.InvalidHeaderFieldException;

@Component
public class SpringInterceptorDemo implements HandlerInterceptor { 
//extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(StringUtils.isBlank(request.getHeader("student-auth-key"))) {
			throw new InvalidHeaderFieldException("Invalid Request");
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}

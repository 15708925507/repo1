package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.config.Config;

public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse  res=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		if(session.getAttribute(Config.MANAGER_ID)==null 
			||"".equals(session.getAttribute(Config.MANAGER_ID).toString())
			|| session.getAttribute(Config.LOGIN_SUCCESS)==null
			|| !Config.LOGIN_SUCCESS_VALUE.equals(session.getAttribute(Config.LOGIN_SUCCESS).toString())	
			){
			   res.sendRedirect("../login.jsp");return;
			}else{
				chain.doFilter(request, response);
			}
			
		    
	}
	
	
}

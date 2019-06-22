package com.discovery.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class myfilter implements Filter{
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) req;
		HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
		
		String url = httpServletRequest.getRequestURI();
		if (url != null && url.endsWith(".jsp")) {
			String contextPath = httpServletRequest.getContextPath();
			httpServletResponse.sendRedirect(contextPath + "/testIndex");
			return;
		}
		chain.doFilter(httpServletRequest, httpServletResponse);

	}
	
	public void destroy() {
		
	}
}

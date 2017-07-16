/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 登录过滤器
 * 
 * @author mxl
 * @version $ SessionFilter.java v1.0, 2017年5月7日 下午9:09:56 mxl Exp $
 */
public class SessionFilter extends OncePerRequestFilter {
	
	/**
	 * @see org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	
		String[] notFilter = new String[]{"login.html"};
		
		String uri = request.getRequestURI();
		
		// 是否过滤
		boolean doFilter = true;
		for (String s : notFilter) {
			if (uri.indexOf(s) != -1) {
				// 如果uri中包含不过滤的uri，则不进行过滤
				doFilter = false;
				break;
			}
		}
		if (doFilter) {
			// 执行过滤
			// 从session中获取登录者实体
			Object obj = request.getSession().getAttribute("user");
			
			if (null == obj) {
				
				request.getRequestDispatcher("/_login").forward(request ,
						response);
			} else {
				// 如果session中存在登录者实体，则继续
				filterChain.doFilter(request , response);
			}
		} else {
			// 如果不执行过滤，则继续
			filterChain.doFilter(request , response);
		}
		
	}
}

package com.web.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器处理表单传到servlet的乱码问题
 * @author gacl
 *
 */
public class CharacterEncodingFilter implements Filter {

	//存储系统使用的字符编码
	private String encoding=null;
	

	public void init(FilterConfig filterConfig) throws ServletException {
		//encoding在web.xml中指定
		this.encoding = filterConfig.getInitParameter("encoding");
	}


	public void doFilter(ServletRequest request, ServletResponse response,
						 FilterChain chain) throws IOException, ServletException {
		//解决表单提交时的中文乱码问题
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}


	public void destroy() {

	}
}



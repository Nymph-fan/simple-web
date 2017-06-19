package com.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author anyun
 * @date 2017/6/19
 * @time 11:58
 * @description
 */
public class FilterDemo01 implements Filter {


    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----过滤器初始化----");
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        //对request和response进行一些预处理
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("FilterDemo01执行前！！！");
        chain.doFilter(request, response);  //让目标资源执行，放行
        System.out.println("FilterDemo01执行后！！！");
    }

    public void destroy() {
        System.out.println("----过滤器销毁----");
    }
}

package com.javaweb.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @description: 过滤器链2
 */
public class MyFilterChain2 implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilterChain2 前置代码");
        System.out.println("MyFilterChain2 取 MyFilterChain1 设置的值为："+servletRequest.getAttribute("k"));
        filterChain.doFilter(servletRequest,servletResponse);
        servletRequest.setAttribute("k2","v2");
        System.out.println("MyFilterChain2 后置代码");
    }

    @Override
    public void destroy() {
    }
}

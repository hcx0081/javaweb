package com.javaweb.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @description: 过滤器链1
 */
public class MyFilterChain1 implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilterChain1 前置代码");
        servletRequest.setAttribute("k","v");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("MyFilterChain1 取 MyFilterChain2 设置的值为："+servletRequest.getAttribute("k2"));
        System.out.println("MyFilterChain1 后置代码");
    }

    @Override
    public void destroy() {
    }
}

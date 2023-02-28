package com.javaweb.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * {@code @Description:} 过滤器链2
 */
public class MyFilterChain2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilterChain2 前置代码");
        System.out.println("请求域中 k1 的值：" + servletRequest.getAttribute("k1"));
        filterChain.doFilter(servletRequest, servletResponse);
        servletRequest.setAttribute("k2", "v2");
        System.out.println("MyFilterChain2 后置代码");
    }
}
package com.javaweb.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * {@code @description:} 过滤器链1
 */
public class MyFilterChain1 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilterChain1 前置代码");
        servletRequest.setAttribute("k1", "v1");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("请求域中 k2 的值：" + servletRequest.getAttribute("k2"));
        System.out.println("MyFilterChain1 后置代码");
    }
}
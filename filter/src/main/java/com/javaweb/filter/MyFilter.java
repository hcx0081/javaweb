package com.javaweb.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * {@code @description:} 拦截路径为  /admin/*
 */
public class MyFilter implements Filter {
    /**
     * 初始化时过滤器调用
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) {
        // 获取Filter的名称
        System.out.println("filter-name：" + filterConfig.getFilterName());// MyFilter
        // 获取初始化参数
        System.out.println("初始化参数 初始化参数名1 的值：" + filterConfig.getInitParameter("初始化参数名1"));// 初始化参数值1
        System.out.println("初始化参数 初始化参数名2 的值：" + filterConfig.getInitParameter("初始化参数名2"));// 初始化参数值2
        // 获取ServletContext对象
        System.out.println(filterConfig.getServletContext());// org.apache.catalina.core.ApplicationContextFacade@53c7698d
    }
    
    /**
     * 拦截请求，过滤响应
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter 开始拦截----------");
        // ServletRequest没有getSession()方法，所以需要强转
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        
        Object user = session.getAttribute("user");
        if (user == null) {
            servletRequest.getRequestDispatcher("login.jsp").forward(servletRequest, servletResponse);
            // ((HttpServletResponse) servletResponse).sendRedirect("login.jsp");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
    
    /**
     * 销毁过滤器时调用
     */
    @Override
    public void destroy() {
    
    }
}
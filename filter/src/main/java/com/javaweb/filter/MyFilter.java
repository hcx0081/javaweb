package com.javaweb.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @description: 拦截路径为  /admin/*
 */
public class MyFilter implements Filter{

    /**
     * 过滤器对象在初始化时调用，可以配置一些初始化参数
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) {
        //1.获取Filter的名称<filter-name>的内容（web-xml中配置的名称）
        System.out.println("filter-name:" + filterConfig.getFilterName());//MyFilter
        //2.获取在web.xml中配置的<init-param>初始化参数
        System.out.println("初始化参数 初始化参数名1 的值是：" + filterConfig.getInitParameter("初始化参数名1"));//初始化参数值1
        System.out.println("初始化参数 初始化参数名2 的值是：" + filterConfig.getInitParameter("初始化参数名2"));//初始化参数值2
        //3.获取ServletContext对象
        System.out.println(filterConfig.getServletContext());//org.apache.catalina.core.ApplicationContextFacade@{一串数字字母}
    }

    /**
     * 用于拦截用户请求，如果和当前拦截器的拦截路径匹配，该方法会被调用
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
        //ServletRequest没有getSession()方法，所以需要强转
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();

        Object user = session.getAttribute("user");
        if (user == null) {
            //此时请求转发的是绝对路径；如果是相对路径，它则是去找 /admin/ 目录下的 login.jsp
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
            //((HttpServletResponse) servletResponse).sendRedirect("/login.jsp");
        } else {
            //让程序继续往下访问，放行（很重要）
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    /**
     * 过滤器对象在销毁时自动调用，释放资源
     */
    @Override
    public void destroy() {

    }
}

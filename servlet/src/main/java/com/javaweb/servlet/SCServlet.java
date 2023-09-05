package com.javaweb.servlet;
/**
 * {@code @description:} ${description}
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SCServlet", value = "/SCServlet")
public class SCServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        
        // 获取web.xml中配置的全局上下文初始化参数（属于整个Web项目）
        System.out.println("参数名1 的参数值为：" + servletContext.getInitParameter("参数名1"));// 参数值1
        System.out.println("参数名2 的参数值为：" + servletContext.getInitParameter("参数名2"));// 参数值2
        
        // 获取当前项目的项目路径，格式：/项目路径
        System.out.println("项目路径：" + servletContext.getContextPath());
        
        // 获取当前项目在服务器磁盘上的绝对路径
        System.out.println("项目的绝对路径：" + servletContext.getRealPath(""));// D:\IDEA\Workspace\javaweb\servlet\src\main\webapp
        System.out.println("项目的绝对路径：" + servletContext.getRealPath("/"));// D:\IDEA\Workspace\javaweb\servlet\src\main\webapp\
        System.out.println("项目的绝对路径：" + servletContext.getRealPath("index.jsp"));// D:\IDEA\Workspace\javaweb\servlet\src\main\webapp\index.jsp
        System.out.println("项目的绝对路径：" + servletContext.getRealPath("/index.jsp"));// D:\IDEA\Workspace\javaweb\servlet\src\main\webapp\index.jsp
        
        
        System.out.println(servletContext.getResourcePaths("/WEB-INF/"));// [/WEB-INF/web.xml]
        
        System.out.println(servletContext.getResource("index.jsp"));// jndi:/localhost/javaWeb/index.jsp
        System.out.println(servletContext.getResource("index.jsp1"));// null
        
        // 像Map一样存取数据
        servletContext.setAttribute("k", "v");
        System.out.println("参数名 k 的值为：" + servletContext.getAttribute("k"));// v
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
package com.javaweb.servlet;
/**
 * @description: ${description}
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SCServlet", value = "/SCServlet")
public class SCServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取 web.xml 中配置的全局（整个 web 工程）上下文参数  <context-param>
        ServletContext servletContext = getServletContext();
        System.out.println("参数名1 的参数值为："+servletContext.getInitParameter("参数名1"));//参数值1
        System.out.println("参数名2 的参数值为："+servletContext.getInitParameter("参数名2"));//参数值2

        //可以获取当前工程路径(名字)，格式：/工程路径(名字)   （前面的 ip、端口号和后面的资源路径则忽略）
        System.out.println("当前工程路径："+servletContext.getContextPath());

        //获取工程后在服务器磁盘上的绝对路径
        System.out.println("工程部署的路径："+servletContext.getRealPath("/"));

        //像 Map 一样存取数据
        servletContext.setAttribute("k","v");
        System.out.println("参数名 k 的值为："+servletContext.getAttribute("k"));//v
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package com.javaweb.servlet;
/**
 * @description: ${description}
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SetAndGetAttributeServlet", value = "/SetAndGetAttributeServlet")
public class SetAndGetAttributeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理请求响应中文乱码问题
        response.setContentType("text/html;charset=utf-8");

        HttpSession session = request.getSession();
        //session域数据的存储
        session.setAttribute("s","属性");
        //session域数据的获取
        Object sessionAttribute = session.getAttribute("s");

        response.getWriter().write("从Session中获取出s的值："+sessionAttribute);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

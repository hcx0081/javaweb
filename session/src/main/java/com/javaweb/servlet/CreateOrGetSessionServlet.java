package com.javaweb.servlet;
/**
 * @description: ${description}
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateOrGetSessionServlet", value = "/CreateOrGetSessionServlet")
public class CreateOrGetSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理请求响应中文乱码问题
        response.setContentType("text/html;charset=utf-8");

        //创建和获取 Session 会话对象
        HttpSession session = request.getSession();
        //判断当前的 Session 会话是否是新创建的
        boolean isNew = session.isNew();
        //获取 Session 会话的唯一标识——id
        String sessionId = session.getId();

        response.getWriter().write("得到的session它的id是："+sessionId+"<br>");
        response.getWriter().write("该session是否是新创建的："+isNew+"<br>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

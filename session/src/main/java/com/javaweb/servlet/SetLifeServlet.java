package com.javaweb.servlet;
/**
 * @description: ${description}
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SetLifeServlet", value = "/SetLifeServlet")
public class SetLifeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理请求响应中文乱码问题
        response.setContentType("text/html;charset=utf-8");

        HttpSession session = request.getSession();
        //设置Session的超时间隔
        session.setMaxInactiveInterval(3);

        //获取Session超时时长
        int inactiveInterval = session.getMaxInactiveInterval();
        response.getWriter().write("Session的超时时长为："+inactiveInterval+"秒");//3，即3秒钟
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

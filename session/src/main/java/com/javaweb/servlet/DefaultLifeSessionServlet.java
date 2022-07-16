package com.javaweb.servlet;
/**
 * @description: ${description}
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DefaultLifeSessionServlet", value = "/DefaultLifeSessionServlet")
public class DefaultLifeSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理请求响应中文乱码问题
        response.setContentType("text/html;charset=utf-8");

        //获取Session默认超时时长
        int maxInactiveInterval = request.getSession().getMaxInactiveInterval();
        response.getWriter().write("Session默认的超时时长为："+maxInactiveInterval+"秒");//1800，即30分钟
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

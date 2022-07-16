package com.javaweb.servlet;
/**
 * @description: ${description}
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PathCookieServlet", value = "/PathCookieServlet")
public class PathCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie=new Cookie("path0","path0");
        //设置该 Cookie 的有效访问目录路径
        cookie.setPath(request.getContextPath()+"/abc");
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

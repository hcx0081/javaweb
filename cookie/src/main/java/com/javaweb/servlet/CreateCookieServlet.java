package com.javaweb.servlet;
/**
 * @description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateCookieServlet", value = "/CreateCookieServlet")
public class CreateCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理请求响应中文乱码问题
        response.setContentType("text/html;charset=utf-8");

        //1、创建 cookie 对象
        Cookie cookie=new Cookie("k","v");
        Cookie cookie2=new Cookie("key","value");

        //2、通知浏览器客户端保存 cookie（切记不能忽略这行代码）
        response.addCookie(cookie);
        response.addCookie(cookie2);

        response.getWriter().write("cookie创建成功");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

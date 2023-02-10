package com.javaweb.servlet;
/**
 * @description:
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateCookieServlet", value = "/CreateCookieServlet")
public class CreateCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理响应中文乱码问题
        response.setContentType("text/html;charset=utf-8");
        
        // 1.创建Cookie对象
        Cookie cookie = new Cookie("k", "v");
        Cookie cookie2 = new Cookie("key", "value");
        
        // 2.通知浏览器客户端保存Cookie（切记不能忽略这行代码）
        response.addCookie(cookie);
        response.addCookie(cookie2);
        
        response.getWriter().write("Cookie创建成功");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
}
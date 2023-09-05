package com.javaweb.servlet;
/**
 * {@code @description:}
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/CreateCookieServlet", value = "/CreateCookieServlet")
public class CreateCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.创建Cookie对象
        Cookie cookie = new Cookie("k", "v");
        Cookie cookie2 = new Cookie("key", "value");
        
        cookie.setMaxAge(60 * 60);// 一小时后失效
        
        // 2.通知浏览器保存Cookie（切记不能忽略这行代码）
        response.addCookie(cookie);
        response.addCookie(cookie2);
        
        System.out.println("Cookie创建成功");
    }
}
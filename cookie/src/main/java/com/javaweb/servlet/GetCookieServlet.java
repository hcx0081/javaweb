package com.javaweb.servlet;
/**
 * @description: ${description}
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetCookieServlet", value = "/GetCookieServlet")
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* 处理响应中文乱码问题 */
        response.setContentType("text/html;charset=utf-8");
        
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            //getName() 用于返回 Cookie 的名称
            //getValue() 用于返回 Cookie 的值
            response.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "]<br>");
        }
        
        
        //查找想要的 Cookie
        Cookie wantCookie = null;
        for (Cookie cookie : cookies) {
            if ("k".equals(cookie.getName())) {
                wantCookie = cookie;
                break;
            }
        }
        //如果 wantCookie 不等于 null，也就是找到了需要的 Cookie
        if (wantCookie != null) {
            response.getWriter().write("<br>wantCookie=" + wantCookie + "<br>");
            response.getWriter().write("也就是Cookie[" + wantCookie.getName() + "=" + wantCookie.getValue() + "]");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
}
package com.javaweb.servlet;
/**
 * {@code @Description:} ${description}
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
        // 获取当前请求携带的所有Cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println("Cookie：" + cookie.getName() + "=" + cookie.getValue());
            }
        }
        // 查找指定Cookie
        Cookie wantCookie;
        for (Cookie cookie : cookies) {
            if ("k".equals(cookie.getName())) {
                wantCookie = cookie;
                System.out.println("wantCookie=" + wantCookie);
                System.out.println("Cookie：" + wantCookie.getName() + "=" + wantCookie.getValue());
                break;
            }
        }
    }
}
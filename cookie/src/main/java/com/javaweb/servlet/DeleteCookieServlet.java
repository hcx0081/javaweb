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

@WebServlet(name = "DeleteCookieServlet", value = "/DeleteCookieServlet")
public class DeleteCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* 方式一 */
        // 获取当前请求携带的所有Cookie
        Cookie[] cookies = request.getCookies();
        // 查找指定Cookie
        Cookie wantCookie;
        for (Cookie cookie : cookies) {
            if ("k".equals(cookie.getName())) {
                wantCookie = cookie;
                // 立即删除该Cookie
                wantCookie.setMaxAge(0);
                // 重新添加该Cookie，即修改该Cookie的有效时长
                response.addCookie(wantCookie);
                break;
            }
        }
        
        /* 方式二 */
        Cookie cookie = new Cookie("key", "value");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
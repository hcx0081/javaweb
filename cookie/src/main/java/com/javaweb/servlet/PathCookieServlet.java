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

@WebServlet(name = "PathServlet", value = "/PathServlet")
public class PathCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("path", "path");
        // 设置该Cookie的路径
        cookie.setPath(request.getContextPath() + "/abc");
        response.addCookie(cookie);
    }
}
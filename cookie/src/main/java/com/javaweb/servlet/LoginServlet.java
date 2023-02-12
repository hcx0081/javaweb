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

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String psd = request.getParameter("psd");
        System.out.println(username);
        System.out.println(psd);
        if ("zs".equals(username) && "123".equals(psd)) {// 登录成功，将Cookie保存在客户端，一小时内免用户名登录
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60);// 一小时内有效
            response.addCookie(cookie);
            System.out.println("登录成功");
        } else {// 登录失败
            System.out.println("登录失败");
        }
    }
}
package com.javaweb.servlet;
/**
 * {@code @Description:} ${description}
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DefaultLifeSessionServlet", value = "/DefaultLifeSessionServlet")
public class DefaultLifeSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取Session默认的超时间隔
        int maxInactiveInterval = request.getSession().getMaxInactiveInterval();
        System.out.println("Session默认的超时间隔：" + maxInactiveInterval + "秒");// 1800，即30分钟
    }
}
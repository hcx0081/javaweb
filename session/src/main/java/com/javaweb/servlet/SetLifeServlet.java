package com.javaweb.servlet;
/**
 * {@code @description:} ${description}
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SetLifeServlet", value = "/SetLifeServlet")
public class SetLifeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // 设置Session的超时间隔
        session.setMaxInactiveInterval(3);
        // 获取Session的超时间隔
        int inactiveInterval = session.getMaxInactiveInterval();
        
        System.out.println("Session的超时间隔：" + session.getId());
        System.out.println("Session的超时间隔：" + inactiveInterval + "秒");// 3，即3秒
    }
}
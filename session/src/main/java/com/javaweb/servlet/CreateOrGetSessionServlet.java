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

@WebServlet(name = "CreateOrGetSessionServlet", value = "/CreateOrGetSessionServlet")
public class CreateOrGetSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建和获取Session对象
        HttpSession session = request.getSession();
        // 获取Session的唯一标识
        String sessionId = session.getId();
        // 判断当前Session是否是新创建的
        boolean isNew = session.isNew();
        
        System.out.println("Session的id：" + sessionId);
        System.out.println("Session是否是新创建的：" + isNew);
    }
}
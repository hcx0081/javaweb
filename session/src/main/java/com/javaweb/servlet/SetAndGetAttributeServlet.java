package com.javaweb.servlet;
/**
 * @description: ${description}
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SetAndGetAttributeServlet", value = "/SetAndGetAttributeServlet")
public class SetAndGetAttributeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("k", "v");
        Object sessionAttribute = session.getAttribute("k");
        System.out.println("Session中k的值：" + sessionAttribute);
    }
}
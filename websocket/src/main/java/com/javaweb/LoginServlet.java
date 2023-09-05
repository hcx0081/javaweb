package com.javaweb;
/**
 * {@code @description:} ${Description}
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final String PASSWORD = "12345";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (PASSWORD.equals(password)) {
            request.getSession().setAttribute("username", username);
            response.sendRedirect("chat.jsp");
        } else {
            response.getWriter().print("<script>alert(\"密码错误\");window.location.href='login.jsp'</script>");
        }
    }
}
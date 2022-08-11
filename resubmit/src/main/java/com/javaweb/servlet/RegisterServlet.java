package com.javaweb.servlet;
/**
 * @description: ${description}
 */

import com.google.code.kaptcha.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取kaptcha生成存放在Session中的验证码
        String verifyCode = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        //马上删除Session域中的验证码
        request.getSession().removeAttribute(verifyCode);

        String code = request.getParameter("code");

        String username = request.getParameter("username");

        //如果kaptcha生成存放在Session中的验证码不是空且跟忽略大小写的输入进来的验证码一致
        if (verifyCode != null && verifyCode.equalsIgnoreCase(code)) {
            System.out.println("保存到数据库：" + username);
            //解决问题一：使用重定向来解决
            response.sendRedirect("success.jsp");
        }else {
            System.out.println("请不要重复提交表单");
        }

        /*try {
            Thread.sleep(5000);//问题二、网络延迟等原因，用户以为提交失败，就会多点了几次提交操作，也会造成表单重复提交
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //request.getRequestDispatcher("success.jsp").forward(request,response);//问题一、按下刷新键会导致表单重复提交
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

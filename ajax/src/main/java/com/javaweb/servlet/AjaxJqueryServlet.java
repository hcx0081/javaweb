package com.javaweb.servlet;
/**
 * @description: ${description}
 */

import com.google.gson.Gson;
import com.javaweb.pojo.Person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AjaxJqueryServlet", value = "/AjaxJqueryServlet")
public class AjaxJqueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("AjaxJqueryServlet");
        Person person = new Person(1,"hcx");
        Gson gson = new Gson();
        //将person对象转换为json字符串
        String jsonString = gson.toJson(person);

        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

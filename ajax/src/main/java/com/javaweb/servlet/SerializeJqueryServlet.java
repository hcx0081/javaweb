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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SerializeJqueryServlet", value = "/SerializeJqueryServlet")
public class SerializeJqueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("SerializeJqueryServlet");

        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println(hobbies[0]);
        System.out.println(hobbies[1]);

        Person person =new Person(id,name);
        Gson gson = new Gson();
        //将person对象转换为json字符串
        String jsonString = gson.toJson(person);

        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

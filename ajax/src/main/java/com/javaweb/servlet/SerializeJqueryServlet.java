package com.javaweb.servlet;
/**
 * {@code @description:} ${description}
 */

import com.google.gson.Gson;
import com.javaweb.pojo.Person;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SerializeJqueryServlet", value = "/SerializeJqueryServlet")
public class SerializeJqueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("SerializeJqueryServlet");
        
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println(hobbies[0]);
        System.out.println(hobbies[1]);
        
        Person person = new Person(id, name);
        Gson gson = new Gson();
        // 将person对象转换为json字符串
        String jsonString = gson.toJson(person);
        
        response.getWriter().write(jsonString);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
    }
}
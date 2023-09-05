package com.javaweb.servlet;
/**
 * {@code @description:} ${description}
 */

import com.google.gson.Gson;
import com.javaweb.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetJsonJqueryServlet", value = "/GetJsonJqueryServlet")
public class GetJsonJqueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("GetJsonJqueryServlet");
        Person person = new Person(1, "zs");
        Gson gson = new Gson();
        // 将person对象转换为json字符串
        String jsonString = gson.toJson(person);
        
        response.getWriter().write(jsonString);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
}
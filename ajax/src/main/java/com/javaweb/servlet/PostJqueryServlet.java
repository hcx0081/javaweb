package com.javaweb.servlet;
/**
 * @description: ${description}
 */

import com.google.gson.Gson;
import com.javaweb.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PostJqueryServlet", value = "/PostJqueryServlet")
public class PostJqueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("PostJqueryServlet");
        Person person = new Person(1, "hcx");
        Gson gson = new Gson();
        //将person对象转换为json字符串
        String jsonString = gson.toJson(person);

        response.getWriter().write(jsonString);
    }
}

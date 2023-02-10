package com.javaweb.servlet;
/**
 * @Description: ${Description}
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EntryServlet", value = "/EntryServlet")
public class EntryServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("init");
    }
    
    @Override
    public void destroy() {
        System.out.println("destroy");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get");
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post");
    }
}
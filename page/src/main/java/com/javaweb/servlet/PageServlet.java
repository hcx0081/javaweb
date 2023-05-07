package com.javaweb.servlet;
/**
 * {@code @Description:} 实现分页功能
 */

import com.javaweb.pojo.Book_Info;
import com.javaweb.pojo.Page;
import com.javaweb.service.BookService;
import com.javaweb.service.Impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "PageServlet", value = "/PageServlet")
public class PageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        BookService bookService = new BookServiceImpl();
        
        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
        Page<Book_Info> page = null;
        try {
            page = bookService.page(pageNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("page", page);
        request.getRequestDispatcher("bookList.jsp").forward(request, response);
    }
}
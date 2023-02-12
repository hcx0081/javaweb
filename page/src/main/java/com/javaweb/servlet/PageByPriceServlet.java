package com.javaweb.servlet;
/**
 * @description: 根据搜索价格区间分页
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

@WebServlet(name = "PageByPriceServlet", value = "/PageByPriceServlet")
public class PageByPriceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bookService = new BookServiceImpl();
        
        Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
        
        Integer min;
        Integer max;

/*        //如果获取表单中的输入值为 空
        if (request.getParameter("min")==""){
            //赋值为0
            min=0;
        }else {
            min = Integer.valueOf(request.getParameter("min"));
        }

        //如果获取表单中的输入值为 空
        if (request.getParameter("max")==""){
            //赋值为最大值
            max=Integer.MAX_VALUE;
        }else {
            max = Integer.valueOf(request.getParameter("max"));
        }*/
        
        
        Page<Book_Info> page = null;
        
        if (request.getParameter("min") == "" || request.getParameter("max") == "") {  // 如果获取表单中的输入值为 空
            try {
                // 直接查询所有信息并分页
                page = bookService.page(pageNo);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else { // 如果获取表单中的输入值是正常的
            min = Integer.valueOf(request.getParameter("min"));
            max = Integer.valueOf(request.getParameter("max"));
            try {
                page = bookService.pageByPrice(pageNo, min, max);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        
        if (page.getUrl() == "PageServlet?") {
            /*因为是 请求转发 ，所以可以共享 request 域中的数据*/
            request.getRequestDispatcher("PageServlet").forward(request, response);
        } else {
            request.setAttribute("page", page);
            request.getRequestDispatcher("bookList.jsp").forward(request, response);
        }
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    
    }
}
package com.javaweb.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

@WebServlet(name = "DownloadServlet", value = "/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //1. 获取要下载的文件名
        String downloadFilename = request.getParameter("name");


        //2. 读取要下载的文件内容（通过ServletContext对象可以读取）
        ServletContext servletContext = getServletContext();

        //3. 通过响应头告诉客户端返回的数据类型
            //获取指定目录下的指定文件名的文件类型
        String mimeType = servletContext.getMimeType("file/" + downloadFilename);
        System.out.println("下载的文件类型：" + mimeType);
            //设置下载的文件类型
        response.setContentType(mimeType);


        //4. 还要告诉客户端收到的数据是用于下载使用，依旧是使用响应头
            //通知浏览器以下载的方式（附件）打开
            // Content-Disposition 响应头，表示收到的数据怎么处理
            // attachment 表示附件的意思，表示下载使用
            /* filename 表示指定下载的文件名（无需添加后缀），
               添加后缀的话浏览器会将最后一个小数点的后缀删除，
               例如 filename=1.jpg.png ，浏览器就会提示下载 1.jpg.jpg 文件
               若有中文，则显示不出来
               使用 URLEncoder.encode("文件名","UTF-8") 将下载的文件名改成 UTF-8 形式
            */
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(downloadFilename,"UTF-8"));


        //5. 将下载的文件内容回传给客户端
        InputStream resourceAsStream = servletContext.getResourceAsStream("file/" + downloadFilename);
            //获取输出流
        OutputStream outputStream = response.getOutputStream();
            //把输入流里面的数据读取复制给输出流，输出给客户端
        IOUtils.copy(resourceAsStream, outputStream);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

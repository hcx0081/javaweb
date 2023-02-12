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
        // 1.获取需要下载的文件名称
        String downloadFilename = request.getParameter("name");
        
        // 2.读取需要下载的文件内容（通过ServletContext对象读取）
        ServletContext servletContext = getServletContext();
        // 获取需要下载的文件的输入流
        InputStream resourceAsStream = servletContext.getResourceAsStream("file/" + downloadFilename);
        
        // 3.通过响应头通知客户端响应数据的MIME类型
        // 获取指定目录下的指定文件的MIME类型
        String mimeType = servletContext.getMimeType("file/" + downloadFilename);
        System.out.println("下载的文件的类型：" + mimeType);
        // 设置响应体的MIME类型
        response.setContentType(mimeType);
        
        // 4.通过响应头通知客户端响应数据是用于下载
        // 通知浏览器以附件的形式下载保存
        /*
         * Content-Disposition头字段：服务端响应数据的响应形式
         *      attachment：以附件的形式响应，表示客户端需要下载
         *      filename：指定下载的文件名称（无需添加后缀），如果添加后缀浏览器会将最后一个小点的后缀删除
         *      例如：filename=1.jpg.png，浏览器就会提示下载1.jpg.jpg文件
         *      若有中文，则无法显示，可以使用URLEncoder.encode("文件名", "UTF-8")将下载的文件名称的字符集编码修改为UTF-8
         *  */
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(downloadFilename, "UTF-8"));
        
        // 5.通过响应体将需要下载的文件内容输出给客户端
        // 获取响应输出流
        OutputStream outputStream = response.getOutputStream();
        // 将输入流中的数据读取复制到输出流中
        IOUtils.copy(resourceAsStream, outputStream);
    }
}
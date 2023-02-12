package com.javaweb.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UploadServlet", value = "/UploadServlet")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* 解决文件名中文乱码 */
        request.setCharacterEncoding("utf-8");
        
        // ServletInputStream inputStream = request.getInputStream();
        // byte[] buffer = new byte[1024000];
        // int read = inputStream.read(buffer);
        // System.out.println(new String(buffer, 0, read));
        
        
        if (ServletFileUpload.isMultipartContent(request)) {
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                // 解析请求，获取每一个表单项FileItem
                List<FileItem> fileItems = servletFileUpload.parseRequest(request);
                // 循环判断每一个表单项是普通表单项还是文件表单项
                for (FileItem fileItem : fileItems) {
                    if (fileItem.isFormField()) {
                        // 普通表单项
                        System.out.println("表单项的name：" + fileItem.getFieldName());
                        System.out.println("表单项的value：" + fileItem.getString("UTF-8"));// 解决乱码
                    } else {
                        // 文件表单项
                        System.out.println("表单项的name：" + fileItem.getFieldName());
                        System.out.println("上传的文件内容：" + fileItem.getString("UTF-8"));
                        System.out.println("上传的文件的名称：" + fileItem.getName());
                        // 将文件保存到 E:\ 下
                        fileItem.write(new File("E:\\" + fileItem.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
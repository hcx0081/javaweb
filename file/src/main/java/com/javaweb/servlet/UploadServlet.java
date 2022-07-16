package com.javaweb.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        /*解决文件名中文乱码*/
        request.setCharacterEncoding("utf-8");
        
        /*ServletInputStream inputStream = request.getInputStream();
        byte[] buffer = new byte[1024000];
        int read = inputStream.read(buffer);
        System.out.println(new String(buffer, 0, read));*/


        //1、先判断上传的数据是否是多段数据（只有多段数据才是文件上传的）
        // isMultipartContent() 是静态方法，所以不用创建 ServletFileUpload 类的实例对象即可被调用
        if (ServletFileUpload.isMultipartContent(request)) {

            //创建 FileItemFactory 工厂实现类，因为 FileItemFactory 是接口，所以 new DiskFileItemFactory() 实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类 ServletFileUpload 类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                //解析上传的数据，得到每一个表单项 FileItem
                List<FileItem> fileItems = servletFileUpload.parseRequest(request);
                //循环判断，每一个表单项是普通类型还是上传文件
                for (FileItem fileItem : fileItems) {
                    if (fileItem.isFormField()) {
                        //普通表单项
                        System.out.println("表单项的 name 属性值：" + fileItem.getFieldName());
                        //参数 UTF-8 解决乱码
                        System.out.println("表单项的 value 属性值：" + fileItem.getString("UTF-8"));
                    } else {
                        //上传的文件
                        System.out.println("上传的文件名：" + fileItem.getName());
                        //将文件保存到 E:\ 下
                        fileItem.write(new File("E:\\" + fileItem.getName()));

                        System.out.println("上传的文件内容：" + fileItem.getString("UTF-8"));
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}

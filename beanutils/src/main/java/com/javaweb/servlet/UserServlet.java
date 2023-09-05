package com.javaweb.servlet;
/**
 * {@code @description:} ${description}
 */

import com.javaweb.pojo.User;
import com.javaweb.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User user = new User();
            System.out.println("填充之前：" + user);// 填充之前：User{username='null', password='null', phone='null'}
            
            BeanUtils.populate(user, request.getParameterMap());
            System.out.println("填充之后：" + user);// 填充之后：User{username='zs', password='123', phone='123'}
            /*
             * 如果修改User类中的setUsername()为setUsername123()，则填充不了，username=null
             * setusername() 可以
             * setuserName() 不行
             * */
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        
        
        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());
        System.out.println("填充之后：" + user);// 填充之后：User{username='zs', password='123', phone='123'}
    }
}
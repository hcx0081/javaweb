package com.javaweb.servlet;
/**
 * @description: ${description}
 */

import com.javaweb.pojo.User;
import com.javaweb.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        try {
//            User user = new User();
//            System.out.println("注入之前："+user);//注入之前：User{username='null', password='null', phone='null'}
//
//            BeanUtils.populate(user,request.getParameterMap());
//            System.out.println("注入之后："+user);//注入之后：User{username='hcx', password='123', phone='123'}
//            /*
//            * 依赖注入
//            * 例如如果修改了User类中的setUsername()为setUsername123()的话，则注入不了，username=null
//            * setusername() 可以
//            * setuserName() 不行
//            * */
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }


        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());
        System.out.println("注入之后：" + user);//注入之后：User{username='hcx', password='123', phone='123'}


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

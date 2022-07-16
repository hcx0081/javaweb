package com.javaweb.servlet;
/**
 * @description: ${description}
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteCookieServlet", value = "/DeleteCookieServlet")
public class DeleteCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取所有 Cookie
        Cookie[] cookies = request.getCookies();

        //查找想要的 Cookie
        Cookie wantCookie=null;
        for (Cookie cookie : cookies) {
            if ("k".equals(cookie.getName())){
                wantCookie=cookie;
                break;
            }
        }
        //如果 wantCookie 不等于 null，也就是找到了需要的 Cookie
        if (wantCookie!=null){
            //设置 cookie 值在客户端存在的最长时间，0 代表马上删除 Cookie
            wantCookie.setMaxAge(0);
            //重新添加该 Cookie，即重新给该 Cookie 赋值，修改它的存活时间
            response.addCookie(wantCookie);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

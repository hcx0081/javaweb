package com.javaweb.listener;
/**
 * {@code @Description:} ${Description}
 */

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener, ServletContextAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Web项目启动");
    }
    
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("项目域中添加域参数");
    }
}
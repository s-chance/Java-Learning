package com.entropy.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //这里主要进行资源初始化的工作
        /*//获取ServletContext对象
        ServletContext servletContext = sce.getServletContext();
        //加载资源文件
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        //获取真实路径
        String realPath = servletContext.getRealPath(contextConfigLocation);

        //加载至内存
        try {
            FileInputStream fileInputStream = new FileInputStream(realPath);
            System.out.println(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
        System.out.println("ServletContext创建完成");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext销毁完成");
    }
}

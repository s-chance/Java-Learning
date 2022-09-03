package com.entropy.test;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/path")
public class PathInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        //获取文件的服务器路径
        //web目录下
        String webPath = servletContext.getRealPath("index.jsp");
        System.out.println(webPath);

        //WEB-INF目录下
        String infPath = servletContext.getRealPath("/WEB-INF/web.xml");
        System.out.println(infPath);

        //src目录下
        String srcPath = servletContext.getRealPath("/WEB-INF/classes/com/entropy/test/PathInfo.class");
        System.out.println(srcPath);
    }
}

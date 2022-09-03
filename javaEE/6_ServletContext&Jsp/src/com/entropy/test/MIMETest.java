package com.entropy.test;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mime")
public class MIMETest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ServletContext获取MIME类型
        //获取ServletContext
        ServletContext servletContext = this.getServletContext();
        //定义文件名
        String filename = "example.mp3";
        //获取MIME类型
        String mimeType = servletContext.getMimeType(filename);
        System.out.println("mimeType = " + mimeType);
    }
}

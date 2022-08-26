package com.entropy.test.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/char")
public class ResponseChar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取流之前设置编码
//        resp.setCharacterEncoding("utf-8");

        //设置服务器采取的解码方式
        resp.setHeader("content-type","text/html;charset=utf-8");
//        resp.setContentType("text/html;charset=utf-8");

        //获取字符输出流
        PrintWriter pw = resp.getWriter();
        pw.write("<h1>你好</h1>");
        pw.write("<h1>hello</h1>");
    }
}

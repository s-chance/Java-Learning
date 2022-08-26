package com.entropy.test.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/respSend")
public class ResponseSend extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("初始端接受到无法处理的请求,准备重定向");
        //设置重定向状态码
        resp.setStatus(302);
        //设置响应头location
        resp.setHeader("location", "/5_Http_Request_Response_war_exploded/respReceive");
        //重定向
        resp.sendRedirect("/5_Http_Request_Response_war_exploded/respReceive");
    }
}

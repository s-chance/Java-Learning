package com.entropy.test.request;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/send")
public class RequestSend extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("send发送端被访问");
        //转发到receive接受端

        //存储数据到request域中,以类似于键值对的形式存储
        req.setAttribute("msg", "hello");

        //获取servletContext域,相比request域,servletContext域范围是整个web应用
        //基础方法同request域对象
        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("global", "context");

        //RequestDispatcher  getRequestDispatcher(String path)通过request对象获取请求转发器对象
        //forward(ServletRequest request, ServletResponse response)使用RequestDispatcher对象进行转发
        req.getRequestDispatcher("/receive").forward(req, resp);
    }
}

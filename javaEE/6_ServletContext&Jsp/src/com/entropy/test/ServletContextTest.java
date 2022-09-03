package com.entropy.test;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/context")
public class ServletContextTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过request对象获取ServletContext对象
        ServletContext servletContext = req.getServletContext();
        System.out.println("servletContext from request = " + servletContext);

        //通过HttpServlet获取
        ServletContext context = this.getServletContext();
        System.out.println("servletContext from HttpServlet = " + context);

        //由于ServletContext对象在一个web应用中是唯一的,因此重复获取的ServletContext对象都是同一个对象
    }
}

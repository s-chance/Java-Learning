package com.entropy.test.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reqLine")
public class RequestLineTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getMethod()获取请求方式
        String method = req.getMethod();
        System.out.println("请求方式:"+method);
        //getContextPath()获取虚拟目录
        String contextPath = req.getContextPath();
        System.out.println("虚拟目录:"+contextPath);
        //getServletPath()获取Servlet路径
        String servletPath = req.getServletPath();
        System.out.println("Servlet路径:"+servletPath);
        //getQueryString()获取get方式的请求参数
        String queryString = req.getQueryString();
        System.out.println("get方式的请求参数:"+queryString);
        //getRequestURL()获取请求的URL
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("请求的URL:"+requestURL);
        //getRequestURI()获取请求的URI
        String requestURI = req.getRequestURI();
        System.out.println("请求的URI:"+requestURI);
        //getProtocol()获取Http协议版本
        String protocol = req.getProtocol();
        System.out.println("Http协议版本:"+protocol);
        //getRemoteAddr()获取客户机的IP地址
        String remoteAddr = req.getRemoteAddr();
        System.out.println("客户机的IP地址"+remoteAddr);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}



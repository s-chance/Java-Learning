package com.entropy.test.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/function")
public class RequestFunction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置流的编码,防止出现中文乱码
        req.setCharacterEncoding("utf-8");

        //getParameter(String s)获取前端指定name属性名对应的属性值,参数s对应前端参数的name的属性名
        String username = req.getParameter("username");
        System.out.println(username);
        System.out.println();
        //getParameterValues(String s)获取前端重复的name属性名各自对应的属性值,并封装成数组
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
        System.out.println();
        //getParameterNames()获取所有请求的参数名称
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String element = parameterNames.nextElement();
            System.out.println(element);
            String parameter = req.getParameter(element);
            System.out.println(parameter);
        }
        System.out.println();
        //getParameterMap()获取所有参数的map集合
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> keySet = parameterMap.keySet();
        for (String s : keySet) {
            String[] strings = parameterMap.get(s);
            System.out.println(s);
            for (String string : strings) {
                System.out.println(string);
            }
            System.out.println();
        }
    }
}

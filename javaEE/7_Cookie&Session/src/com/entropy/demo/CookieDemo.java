package com.entropy.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookieDemo")
public class CookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        Cookie[] cookies = req.getCookies();
        //记录特定cookie的状态
        boolean isCookieExists = false;
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("lastTime".equals(name)) {
                    isCookieExists = true;

                    //获取上一次访问记录的时间
                    String value = cookie.getValue();
                    System.out.println("解码前:" + value);
                    value = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后:" + value);
                    resp.getWriter().write("<h1>欢迎回来，您上次访问时间为"+value+"</h1>");
                    resp.getWriter().write("<h2>Welcome Back!</h2>");

                    //更新cookie时间
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String format = sdf.format(date);
                    System.out.println("URL编码前:" + format);
                    format = URLEncoder.encode(format, "UTF-8");
                    System.out.println("URL编码后:" + format);
                    //cookie重新设置编码后的值
                    cookie.setValue(format);
                    //设置存活时间
                    cookie.setMaxAge(60*60*24*30); //30天
                    resp.addCookie(cookie);
                    break;
                }
            }
        }
        //第一次访问
        if (cookies == null || cookies.length == 0 || isCookieExists == false) {
            //获取时间,生成cookie
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = sdf.format(new Date());
            System.out.println("编码前:"+format);
            format = URLEncoder.encode(format, "utf-8");
            System.out.println("编码后:"+format);

            //生成一个记录访问时间的cookie
            Cookie lastTime = new Cookie("lastTime", format);
            //设置存活时间
            lastTime.setMaxAge(60*60*24*30); //30天
            resp.addCookie(lastTime);

            resp.getWriter().write("<h1>首次访问，热烈欢迎</h1>");
            resp.getWriter().write("<h1>This is your first visit</h1>");
        }
    }
}

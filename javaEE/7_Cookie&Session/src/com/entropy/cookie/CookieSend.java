package com.entropy.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieSend")
public class CookieSend extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建Cookie,并以键值对的形式绑定数据
        Cookie cookie = new Cookie("msg", "this-is-a-cookie");
        //通过response发送Cookie
        resp.addCookie(cookie);

        //发送第二个Cookie
        Cookie secondCookie = new Cookie("second", "the-second-Cookie");
        resp.addCookie(secondCookie);

        //setMaxAge(int seconds)设置Cookie存活时间
        //参数为正数表示具体的存活时间(秒)
        //参数为零相当于直接删除Cookie
        //参数为负数相当于默认设置
        Cookie live = new Cookie("live", "存活时间");
        live.setMaxAge(60); //一分钟
        resp.addCookie(live);

        //setPath(String path)设置cookie的共享范围
        //一般跨项目访问的话,路径设置为"/"即可
        Cookie together = new Cookie("together", "we-are-family");
        together.setPath("/"); //之后就能跨web项目获取cookie的共享数据
        resp.addCookie(together);
    }
}

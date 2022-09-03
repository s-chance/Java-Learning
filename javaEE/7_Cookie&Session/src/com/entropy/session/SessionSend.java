package com.entropy.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/sessionSend")
public class SessionSend extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Session
        HttpSession session = req.getSession();
        //存储数据
        session.setAttribute("msg", "this is a session");

        //删除数据
        session.setAttribute("flag", "a cat");
        session.removeAttribute("flag");

        //获取SessionId
        String id = session.getId();
        System.out.println("发送端SessionId = " + id);

        //修改JSESSIONID存活时间实现Session持久化
        Cookie jsessionid = new Cookie("JSESSIONID", session.getId());
        jsessionid.setMaxAge(60*60); //一小时
        resp.addCookie(jsessionid);
    }
}

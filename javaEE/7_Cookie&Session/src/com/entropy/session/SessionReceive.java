package com.entropy.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sessionReceive")
public class SessionReceive extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session
        HttpSession session = req.getSession();
        Object msg = session.getAttribute("msg");
        System.out.println("msg = " + msg);

        //测试被删除的数据
        Object flag = session.getAttribute("flag");
        System.out.println("flag = " + flag);

        //销毁Session,重新生成Session
        System.out.println("接收端被销毁前的SessionId:" + session.getId());
        session.invalidate();
        HttpSession newSession = req.getSession();
        System.out.println("接收端重新生成的SessionId:" + newSession.getId());
    }
}

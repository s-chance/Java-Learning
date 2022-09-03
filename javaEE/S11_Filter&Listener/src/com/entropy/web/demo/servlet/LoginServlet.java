package com.entropy.web.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String verifyCode = req.getParameter("verifyCode");

        String code = (String)req.getSession().getAttribute("verifyCode");

        //为了方便演示这里仅做验证码处理
        if (verifyCode.equals(code)) {
            req.removeAttribute("msg");
            List list = new ArrayList();
            list.add(name);
            list.add(password);


            req.getSession().setAttribute("name", name);
            System.out.println(name);

            req.getSession().setAttribute("user", list);

            req.getRequestDispatcher("/index.jsp").forward(req, resp);

        } else {
            req.setAttribute("msg", "验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}

package com.entropy.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置request编码
        req.setCharacterEncoding("utf-8");
        //获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String verify = req.getParameter("verify");
        String remember = req.getParameter("remember");

        //获取Session域中的验证码
        HttpSession session = req.getSession();
        String verifyCode = (String) session.getAttribute("verifyCode");
        //删除缓存的验证码
        session.removeAttribute("verifyCode");

        //检测验证码
        if (verify != null && verify.equals(verifyCode)) {
            //验证码通过,删除验证码错误提示
            session.removeAttribute("verifyMistake");
            //检测用户名与密码
            if ("admin".equals(username) && "admin123".equals(password)) {
                //删除错误提示
                session.removeAttribute("infoMistake");
                //验证完成,存储用户信息
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                session.setAttribute("remember", remember);

                //持久化Session,记录登录状态
                if (remember != null) {
                    Cookie jsessionid = new Cookie("JSESSIONID", session.getId());
                    jsessionid.setMaxAge(60*60); //一小时
                    resp.addCookie(jsessionid);
                }


                //进入成功登录页面
                resp.sendRedirect(req.getContextPath() + "/success.jsp");
            } else {
                //设置错误提示信息
                session.setAttribute("infoMistake", "用户名或密码错误");
                //转发到登录页面
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        } else {
            //设置错误提示信息
            session.setAttribute("verifyMistake", "验证码错误");
            //转发到登录页面
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}

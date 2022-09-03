package com.entropy.web.servlet;

import com.entropy.service.UserService;
import com.entropy.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取id
        String id = req.getParameter("id");
        //调用service
        UserService userService = new UserServiceImpl();
        userService.deleteById(id);
        //重定向
        resp.sendRedirect(req.getContextPath()+"/page");
    }
}

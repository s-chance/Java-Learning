package com.entropy.web.servlet;

import com.entropy.service.UserService;
import com.entropy.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteSelected")
public class DeleteSelectedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取指定参数对应的所有数据
        String[] ids = req.getParameterValues("uid");
        //调用service
        UserService userService = new UserServiceImpl();
        userService.deleteSelected(ids);
        //重定向
        resp.sendRedirect(req.getContextPath()+"/page");
    }
}

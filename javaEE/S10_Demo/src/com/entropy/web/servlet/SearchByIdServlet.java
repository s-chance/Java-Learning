package com.entropy.web.servlet;

import com.entropy.pojo.User;
import com.entropy.service.UserService;
import com.entropy.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/searchById")
public class SearchByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取id
        String id = req.getParameter("id");
        //调用service,查询到要修改的用户数据,实现数据回显
        UserService userService = new UserServiceImpl();
        User user = userService.searchById(id);
        //存入request域
        req.setAttribute("user", user);

        //转发数据
        req.getRequestDispatcher("/update.jsp").forward(req, resp);
    }
}

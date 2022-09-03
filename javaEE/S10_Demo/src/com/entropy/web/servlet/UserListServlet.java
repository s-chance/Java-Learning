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
import java.util.List;

@WebServlet("/userList")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用UserService服务接口完成查询
        UserService userService = new UserServiceImpl();
        List<User> users = userService.searchAll();

        //存入request域
        req.setAttribute("users", users);

        //转发数据到jsp页面
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }
}

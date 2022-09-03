package com.entropy.web.servlet;

import com.entropy.pojo.Page;
import com.entropy.pojo.User;
import com.entropy.service.UserService;
import com.entropy.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/page")
public class PageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //获取参数
        //当前页
        String pageNow = req.getParameter("pageNow");
        //当前页记录数
        String pageSize = req.getParameter("pageSize");

        //初始默认数据
        if (pageNow == null || "".equals(pageNow)) {
            pageNow = "1";
        }
        if (pageSize == null || "".equals(pageSize)) {
            pageSize = "5";
        }

        //获取条件查询参数
        Map<String, String[]> map = req.getParameterMap();

        //调用service
        UserService userService = new UserServiceImpl();
        Page<User> page = userService.searchByPage(pageNow, pageSize, map);

        //page对象数据存入request域
        req.setAttribute("page", page);
        //查询条件存入request域
        req.setAttribute("map", map);

        //转发数据
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
}

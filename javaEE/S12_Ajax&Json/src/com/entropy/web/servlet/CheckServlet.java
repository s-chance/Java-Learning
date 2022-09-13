package com.entropy.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/check")
public class CheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");

        //设置响应格式为json
        resp.setContentType("application/json;charset=UTF-8");
//        resp.setContentType("text/html;charset=UTF-8");

        Map<String, Object> map = new HashMap<>();

        if ("admin".equals(name) || "管理者".equals(name)) {
            //用户名重复
            map.put("exist", true);
            map.put("msg", "该用户名已注册");
        } else {
            map.put("exist", false);
            map.put("msg", "该用户名可以使用");
        }

        //map转为json
        ObjectMapper objectMapper = new ObjectMapper();
        //map传输msg提示信息给客户端
        objectMapper.writeValue(resp.getWriter(), map);
    }
}

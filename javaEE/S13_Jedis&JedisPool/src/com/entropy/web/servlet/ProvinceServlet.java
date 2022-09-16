package com.entropy.web.servlet;

import com.entropy.pojo.Province;
import com.entropy.service.ProvinceService;
import com.entropy.service.impl.ProvinceServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/province")
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用service查询
        ProvinceService provinceService = new ProvinceServiceImpl();

        //从MySQL直接查询
//        List<Province> provinces = provinceService.searchAll();

        //redis改造后序列化已经在service层完成, 故不需要再在servlet序列化
//        //序列化为json
//        ObjectMapper objectMapper = new ObjectMapper();
//        String json = objectMapper.writeValueAsString(provinces);

        //通过redis查询
        String json = provinceService.searchAllByRedis();
        System.out.println(json);

        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);
    }
}

package com.entropy.test.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/agent")
public class UserAgentTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String agent = req.getHeader("user-agent");
        if (agent.contains("Chrome")) {
            System.out.println("Chrome");
        } else if (agent.contains("Firefox")) {
            System.out.println("Firefox");
        }

        //referer防盗链测试(实际正确拼写应该是referrer)
        String referer = req.getHeader("referer");
        if (referer != null) {
            if (referer.contains("access")) {
                //通过检查,允许访问
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("权限验证通过");
            } else {
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("权限验证失败,请确保您有网站管理员的授权许可");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

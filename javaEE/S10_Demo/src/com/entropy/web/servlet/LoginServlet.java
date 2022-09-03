package com.entropy.web.servlet;

import com.entropy.pojo.User;
import com.entropy.service.UserService;
import com.entropy.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

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
        //获取填写的验证码数据
        String verifyInfo = req.getParameter("verifyInfo");
        //批量获取数据
        Map<String, String[]> map = req.getParameterMap();

        //验证码校验,获取生成的验证码
        HttpSession session = req.getSession();
        String verifyCode = (String) session.getAttribute("verifyCode");
        //删除系统生成的验证码,防止二次利用
        session.removeAttribute("verifyCode");

        if (!verifyInfo.equals(verifyCode)) {
            //验证码不通过
            req.setAttribute("verifyFailed", "验证码错误");
            //转发到登录页面
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            //直接跳过后面程序的执行
            return;
        }

        //将User对象封装到JavaBean中(这里的实体类称为JavaBean),方便之后获取数据
        User user = new User();
        try {
            //map是之前从前端批量获取的数据
            //这里会将数据映射到user对象中的get和set方法中,即封装数据到JavaBean中
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserService userService = new UserServiceImpl();
        User login = userService.login(user);
        if (login != null) {
            //用户信息验证通过
            session.removeAttribute("verifyFailed");
            session.setAttribute("userInfo", login);

            //这里进行重定向
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
        } else {
            req.setAttribute("verifyFailed", "用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}

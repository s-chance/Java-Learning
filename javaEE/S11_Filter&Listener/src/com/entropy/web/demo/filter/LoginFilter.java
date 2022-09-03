package com.entropy.web.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //这里强转主要是为了获取URI路径,原有的接口不支持这个getRequestURI方法
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uri = request.getRequestURI();
        //设置直接放行的资源,如登录页面和一些非服务器动态生成的静态资源
        //相当于白名单
        if (uri.contains("/login") || uri.contains("/verify") || uri.contains("/login.jsp")
                || uri.contains("/css/") || uri.contains("/fonts/") || uri.contains("/js/")
                || uri.contains("/images/")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            //判断当前访问的用户是否处于已登录的状态
            Object user = request.getSession().getAttribute("user");
            if (user != null) {
                //已登录,放行
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                //未登录,跳转到登录页面
                request.setAttribute("msg", "您还未登录,请登录");
                request.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}

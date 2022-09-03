package com.entropy.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*") // *表示对所有对服务器资源的访问都会进行拦截
public class FilterTest implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init...正在初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("doFilter执行");

        //放行请求
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("重新回到doFilter");
    }

    @Override
    public void destroy() {
        System.out.println("destroy...正在销毁");
    }
}

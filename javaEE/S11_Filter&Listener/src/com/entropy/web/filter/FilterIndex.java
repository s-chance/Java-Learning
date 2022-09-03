package com.entropy.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/index.jsp") //拦截所有对index.jsp的特定请求

//直接访问index.jsp时进行拦截,通过servlet程序转发的方式访问可以绕过这种拦截
//@WebFilter(value = "/index.jsp", dispatcherTypes = DispatcherType.REQUEST)

//只有通过转发的方式访问index.jsp时才会进行拦截
//@WebFilter(value = "/index.jsp", dispatcherTypes = DispatcherType.FORWARD)

//dispatcherTypes可以同时设置多种,例如同时设置直接访问和转发访问都会被拦截
//@WebFilter(value = "/index.jsp", dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})

public class FilterIndex implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截对index.jsp的特定请求");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

package com.entropy.web.demo.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class WordFilter implements Filter {

    //存放敏感词集合
    private List<String> list = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        try {
            //获取文件真实路径
            ServletContext servletContext = filterConfig.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词.txt");
            //读取文件,利用转换流设置编码
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(realPath), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            //将文件的数据按行添加到list中
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
            bufferedReader.close();
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //创建代理对象,增强getParameter方法
        servletRequest.setCharacterEncoding("UTF-8");
        ServletRequest getParameterProxy = (ServletRequest) Proxy.newProxyInstance(servletRequest.getClass().getClassLoader(), servletRequest.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //使用代理模式将ServletRequest获取的参数进行替换
                        if (method.getName().equals("getParameter")) {
                            String invoke = (String) method.invoke(servletRequest, args);
                            if (invoke != null) {
                                for (String s : list) {
                                    if (invoke.contains(s)) {
                                        invoke = invoke.replaceAll(s, "***");
                                    }
                                }
                            }
                            return invoke;
                        }
                        return method.invoke(servletRequest, args);
                    }
                });
        //放行,传入增强后的ServletRequest对象
        filterChain.doFilter(getParameterProxy, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

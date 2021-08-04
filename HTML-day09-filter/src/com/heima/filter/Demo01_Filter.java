package com.heima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Enumeration;

//过滤的地址，访问demo01的时候才过滤
//@WebFilter("/demo01")
//@WebFilter("/*") //过滤所有资源
//@WebFilter("*.do") //匹配扩展名，"/*.do" 这种写法是错误的
//@WebFilter({"/demo01","/demo02"})// 可以匹配多个地址
public class Demo01_Filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String user = filterConfig.getInitParameter("user");
        System.out.println(user);
        Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String s = initParameterNames.nextElement();
            String initParameter = filterConfig.getInitParameter(s);
            System.out.println(initParameter);
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器：请求的时候执行");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("过滤器：响应的时候执行");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}

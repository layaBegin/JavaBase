package com.heima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
/*
DispatcherType.FORWARD 拦截转发
DispatcherType.REQUEST 直接请求，重定向就是一次新的请求

 */
//@WebFilter(filterName = "Demo02Filter",urlPatterns = "/demo02",dispatcherTypes = {DispatcherType.FORWARD ,DispatcherType.REQUEST,DispatcherType.INCLUDE})
public class Demo02Filter implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("过滤器：请求的时候执行");
        chain.doFilter(req,resp);
        System.out.println("过滤器：响应的时候执行");
    }


    public void destroy() {

    }


}

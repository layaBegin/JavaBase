package com.heima.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
1,继承HttpServlet
2，重写父类方法doGet 或者doPost
3，配置servlet 的访问地址
方式1：通过web.xml
方式2：通过@webservlet
4，
 */
//@WebServlet("/demo02")
@WebServlet("/demo03")
public class Demo03_lifeCycleServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("每次请求都会执行");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("结束时执行");

    }
}

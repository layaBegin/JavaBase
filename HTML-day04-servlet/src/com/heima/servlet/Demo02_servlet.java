package com.heima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
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
//@WebServlet(name = "demo02",urlPatterns = "/demo02")
@WebServlet({"/demo02","/d02secondUrl"})//访问的url可以配置多条
public class Demo02_servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置网页的类型和编码
        resp.setContentType("text/html; charset=UTF-8");
        //获取一个打印流，用于输出到浏览器
        PrintWriter writer = resp.getWriter();

        writer.println("<h2>使用注解的方式开发</h2>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

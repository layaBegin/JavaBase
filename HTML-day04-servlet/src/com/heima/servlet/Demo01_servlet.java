package com.heima.servlet;

import javax.servlet.ServletException;
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
public class Demo01_servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置网页的类型和编码
        resp.setContentType("text/html;charset=UTF-8");
        //获取一个打印流，用于输出到浏览器
        PrintWriter writer = resp.getWriter();
        writer.println("这是我的第一个servlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

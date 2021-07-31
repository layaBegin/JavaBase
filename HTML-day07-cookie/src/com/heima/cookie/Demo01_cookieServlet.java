package com.heima.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/demo01")
public class Demo01_cookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        Cookie man = new Cookie("name", "孙悟空");
        //设置cookie 过期时间，默认关闭过期
        man.setMaxAge(600);
        man.setPath(request.getContextPath()+"/demo02");
        response.addCookie(man);
        Cookie age = new Cookie("age", "15");
        //设置cookie 过期时间，默认关闭过期
        age.setMaxAge(60*5);
        age.setPath(request.getContextPath()+"/demo02");
        response.addCookie(age);
        PrintWriter writer = response.getWriter();
        writer.println("添加了cookie信息");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

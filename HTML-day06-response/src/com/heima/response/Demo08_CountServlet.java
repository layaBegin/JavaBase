package com.heima.response;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

//上下文域的作用，统计当前登录的人数
@WebServlet("/demo08")
public class Demo08_CountServlet extends HttpServlet {
    //重写声明周期的初始化方法
    @Override
    public void init() throws ServletException {
        ServletContext application = this.getServletContext();
        application.setAttribute("count",new AtomicInteger(0));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取上下文对象
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        ServletContext application = this.getServletContext();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("sunwukong".equalsIgnoreCase(username) && "123".equals(password)){
            AtomicInteger count = (AtomicInteger)application.getAttribute("count");
            count.incrementAndGet();
            writer.println("您是第"+ count + "个登录的用户");

        }else {
            writer.println("登录失败，<a href=index.jsp>请重试</a>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

package com.heima.servlet05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/demo01")
public class Demo01_requestLine extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        /*writer.println("获取请求的方法"+ request.getMethod()+ "<hr/>");
        writer.println("请求的URI"+ request.getRequestURI()+ "<hr/>");
        writer.println("请求的URL"+ request.getRequestURL()+ "<hr/>");
        writer.println("获取一个请求头：" + request.getHeader("host"));
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String key = headerNames.nextElement();
            String header = request.getHeader(key);
            writer.println("请求头名字"+ key +"值："+header+"<hr/>");
        }*/
        String header = request.getHeader("user-agent");
        writer.println(header);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}

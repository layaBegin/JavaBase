package com.heima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/demo01")
public class Demo01_Ajax_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        System.out.println("name:"+name);
        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((key,value)->{
            System.out.println("键："+ key + ",value:"+value[0]);
        });
        System.out.println("请求方式："+request.getMethod());
        if ("zhangshan".equalsIgnoreCase(name)){
            //不要用换行的那个api，"这样 字符串后面会跟\r\n"
            out.print("用户名重复");
        }else {
            out.print("用户名可用");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

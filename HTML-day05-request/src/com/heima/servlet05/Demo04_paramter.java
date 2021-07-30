package com.heima.servlet05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/demo04")
public class Demo04_paramter extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        //使用post提交表单会乱码，默认采用欧洲编码，需要改成 utf-8
        request.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        String name = request.getParameter("name");
        writer.println(name);
        String gender = request.getParameter("gender");
        writer.println(gender + "<hr/>");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            writer.println(request.getParameter(parameterNames.nextElement())+"<hr/>");
        }
        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((key,value)->{
            writer.println("键："+ key+" 值："+ Arrays.toString(value)+"<hr/>");
        });

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}

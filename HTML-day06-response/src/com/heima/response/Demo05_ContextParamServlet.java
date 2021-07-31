package com.heima.response;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

//1.读取web.xml 中全局配置参数
//2,使用配置的方式设置servlet的访问地址
public class Demo05_ContextParamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        //获取上下文对象
        ServletContext servletContext = this.getServletContext();
        writer.println(servletContext+"<hr/>");
        //局部变量使用servletConfig中的方法读取
        String user = this.getInitParameter("name");
        writer.println("局部初始参数："+user +"<hr/>");
        //获取全局配置参数
        String name = servletContext.getInitParameter("name");
        writer.println("全局配置参数："+name);
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String key = initParameterNames.nextElement();
            String value = (String)servletContext.getInitParameter(key);
            writer.println("键为："+key + " 值是："+value);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

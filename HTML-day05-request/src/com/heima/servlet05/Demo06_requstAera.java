package com.heima.servlet05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//请求的转发
@WebServlet("/one")
public class Demo06_requstAera extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user","Newboy");

       /* //转发和重定向不能同时使用，否则会报500错误
        request.getRequestDispatcher("two").forward(request,response);*/
        //重定向
        response.sendRedirect(request.getContextPath()+"/two");

        //String user = (String)request.getAttribute("user");
       /* response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("请求区域中的值："+user+ "<hr/>");*/

       /* request.removeAttribute("user");
        user = (String)request.getAttribute("user");
        writer.println("请求区域中的值："+user+ "<hr/>");*/

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

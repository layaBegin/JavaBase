package com.heima.servlet05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/two")
public class Demo06_requstAera2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = (String)request.getAttribute("user");
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = response.getWriter();
        writer.println("<h2>这是two servlet</h2>");
        writer.println("获取参数：" + user);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

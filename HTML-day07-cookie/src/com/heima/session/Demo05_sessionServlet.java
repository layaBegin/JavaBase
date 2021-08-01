package com.heima.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

@WebServlet("/demo05")
public class Demo05_sessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        String id = session.getId();
        boolean aNew = session.isNew();
        writer.println("会话是：" + session + "<hr/>");
        writer.println("会话id是：" + id + "<hr/>");
        writer.println("是否是新的：" + aNew+ "<hr/>");
        long creationTime = session.getCreationTime();
        writer.println("creationTime:" + creationTime + "<hr/>");
        writer.println("Timestamp:" + new Timestamp(creationTime) + "<hr/>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

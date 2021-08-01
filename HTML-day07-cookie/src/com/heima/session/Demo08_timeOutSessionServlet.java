package com.heima.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/demo08")
public class Demo08_timeOutSessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        //获取最大非活动时间间隔
        int maxInactiveInterval = session.getMaxInactiveInterval();
        writer.println("maxInactiveInterval:" + maxInactiveInterval + "<hr/>");
        //设置会话最大非活动时间
        //session.setMaxInactiveInterval(5);
        String id = session.getId();
        writer.println("会话id:" + id + "<hr/>");
        //立即失效
        //session.invalidate();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

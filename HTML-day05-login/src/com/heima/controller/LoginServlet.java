package com.heima.controller;

import com.heima.entity.User;
import com.heima.service.UserServie;
import com.heima.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserServie userServie = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.汉字编码
        request.setCharacterEncoding("utf-8");
        //2,获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //3，调用业务层实现登录
        User user = userServie.login(username, password);
        //4，登录成功跳转到success 的servlet
        if (user !=null){
            request.setAttribute("user",user);
            request.getRequestDispatcher("success").forward(request,response);
        }
        //5，登录失败跳转到失败页面
        else {
            response.sendRedirect("failure.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

package com.heima.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Demo04_loginCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        response.setHeader("remember",remember);
        if ("zhangshan".equalsIgnoreCase(username) && "123".equals(password)){
            if ("on".equals(remember)){
                Cookie cUser = new Cookie("username",username);
                cUser.setMaxAge(60*60*24*7);
                cUser.setPath(request.getContextPath()+"/login.html");
                response.addCookie(cUser);
                Cookie cookie = new Cookie("password",password);
                cookie.setMaxAge(60*60*24*7);
                cookie.setPath(request.getContextPath()+"/login.html");
                response.addCookie(cookie);
            }
            response.sendRedirect("success.html");
        }else {
            response.sendRedirect("failure.html");
        }






    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

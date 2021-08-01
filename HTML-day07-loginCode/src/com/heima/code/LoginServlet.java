package com.heima.code;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //1,获取会话域
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("code");
        String vcode = request.getParameter("vcode");
        String username = request.getParameter("name");
        String password = request.getParameter("password");

        if (vcode.equalsIgnoreCase(code)){
            session.removeAttribute("vcode");
            if ("zhangshan".equals(username) && "123".equals(password)){
                response.sendRedirect("welcome");
            }else {
                out.println("<script>");
                out.println("alert('用戶名或密碼錯誤');");
                out.println("location.href='login.html';");
                out.println("</script>");
            }
        }else {
            out.println("<script>");
            out.println("alert('验证码错误');");
            out.println("location.href='login.html';");
            out.println("</script>");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

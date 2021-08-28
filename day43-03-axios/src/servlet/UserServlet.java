package servlet;

import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet("/user")
public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        if ("zhangshan".equals(name)){
            out.print("用户名已存在");
        }else {
            out.print("恭喜可以注册");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}

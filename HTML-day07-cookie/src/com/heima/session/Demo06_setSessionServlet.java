package com.heima.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

@WebServlet("/demo06")
public class Demo06_setSessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("向会话中添加商品");
        HttpSession session = request.getSession();
        session.setAttribute("product","洗衣机");

       /* //手动 创建JSSESSIONID，可以让浏览器关闭后，服务器还能获取sesson
        Cookie cookie = new Cookie("JSSESSIONID", session.getId());
        response.addCookie(cookie);*/

       //如果浏览器关闭cookie 处理：将JSSESSIONID 放地址栏传送
        String demo03 = response.encodeRedirectURL("demo03");
        response.sendRedirect(demo03);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

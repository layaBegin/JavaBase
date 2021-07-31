package com.heima.response;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/demo07")
public class Demo07_RealPathServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取上下文对象
        response.setContentType("text/html; charset=UTF-8");
        ServletContext application = this.getServletContext();
        String realPath = application.getRealPath("/WEB-INF/404.jpg");
        PrintWriter writer = response.getWriter();
        writer.println("服务器上的真实地址为："+realPath);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

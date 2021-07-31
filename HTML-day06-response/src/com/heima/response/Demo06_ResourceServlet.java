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
import java.util.Enumeration;

@WebServlet("/demo06")
public class Demo06_ResourceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取上下文对象
        ServletContext application = this.getServletContext();
        // /相当于web目录，WEB-INF 下的资源不能被外部直接访问，必须转成二进制流写出
        InputStream inputStream = application.getResourceAsStream("/WEB-INF/404.jpg");
        ServletOutputStream outputStream = response.getOutputStream();
        /*byte[] bytes = new byte[1024];
        int len ;
        while ((len = inputStream.read(bytes)) != 0){
            outputStream.write(bytes,0,len);
        }*/

        //使用IO工具复制io流
        IOUtils.copy(inputStream, outputStream);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

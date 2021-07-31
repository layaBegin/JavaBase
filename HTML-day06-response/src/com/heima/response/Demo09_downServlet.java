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
import java.net.URLEncoder;
import java.util.concurrent.atomic.AtomicInteger;

//上下文域的作用，统计当前登录的人数
@WebServlet("/down")
public class Demo09_downServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取上下文对象
        ServletContext application = this.getServletContext();
        String filename = request.getParameter("filename");
        /**
         * 如需所有文件都采用下载的方式，需要设置response请求头
         * 1,因为 request请求头中的数据 浏览器会自动进行编码，
         * 2，response 接收响应头的数据，浏览器会自动进行解码
         * 所以这里要对应增加编码，否则汉字乱码
         */
        String encode = URLEncoder.encode(filename,"utf-8");
        System.out.println("文件名："+filename);
        System.out.println("编码后文件名："+encode);
        response.setHeader("Content-Disposition","attachment;filename="+encode);
        InputStream inputStream = application.getResourceAsStream("/download/"+filename);
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(inputStream, outputStream);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

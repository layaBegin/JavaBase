package com.heima.servlet;

import com.heima.entity.Contact;
import com.heima.entity.PageBean;
import com.heima.service.ContactService;
import com.heima.service.impl.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/contact")
public class ConnectServlet extends HttpServlet {
    ContactServiceImpl  contactService = new ContactServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("contact servlet 执行");

        Map<String, String[]> parameterMap = request.getParameterMap();
        String currentPage = parameterMap.get("currentPage")[0];
        String size = parameterMap.get("size")[0];
        System.out.println("currentpage:"+currentPage);
        System.out.println("size:"+size);

        PageBean pageBean = contactService.getPageBean(Integer.parseInt(currentPage), Integer.parseInt(size));
        System.out.println("pageBean:" + pageBean);
        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

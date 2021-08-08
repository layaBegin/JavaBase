package com.heima.servlet;

import com.heima.entity.Contact;
import com.heima.service.ContactService;
import com.heima.service.impl.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/query")
public class QueryServlet extends HttpServlet {
    ContactService  contactService = new ContactServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入update Servlet");
        String id = request.getParameter("id");
        Contact contact = contactService.findContactById((Integer.parseInt(id)));
        HttpSession session = request.getSession();
        session.setAttribute("contact",contact);
        request.getRequestDispatcher("updateForm.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

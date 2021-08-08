package com.heima.servlet;

import com.heima.entity.Contact;
import com.heima.service.ContactService;
import com.heima.service.impl.ContactServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    ContactService  contactService = new ContactServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        Integer count = contactService.deleteContact(Integer.parseInt(id));
        if (count > 0){
            out.println("<script>");
            out.println("alert('删除成功');");
            out.println("location.href='index.jsp';");
            out.println("</script>");
            //  response.sendRedirect("/contact");
        }else {
            out.println("<script>");
            out.println("alert('删除失败');");
            out.println("</script>");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

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
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    ContactService  contactService = new ContactServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println("add servlet 执行");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Contact contact = new Contact();
        try {
            BeanUtils.populate(contact,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Integer count = contactService.addContact(contact);
        System.out.println("添加联系人 被影响的行数："+contact);
        if (count > 0){
            out.println("<script>");
            out.println("alert('添加成功');");
            out.println("location.href='index.jsp';");
            out.println("</script>");
            //  response.sendRedirect("/contact");
        }else {
            out.println("<script>");
            out.println("alert('添加失败');");
            out.println("</script>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

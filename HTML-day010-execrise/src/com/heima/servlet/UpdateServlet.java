package com.heima.servlet;

import com.heima.entity.Contact;
import com.heima.service.ContactService;
import com.heima.service.impl.ContactServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletContext;
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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    ContactService  contactService = new ContactServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println("进入update Servlet");
        HttpSession session = request.getSession();
        System.out.println("session:"+session);
        Contact contact = (Contact)session.getAttribute("contact");
        System.out.println("contact:"+contact);
        Map<String, String[]> parameterMap = request.getParameterMap();
        HashMap<String, String[]> stringHashMap = new HashMap<>(parameterMap);
        stringHashMap.put("id", new String[]{contact.getId().toString()});
        stringHashMap.forEach((s1,s2)->{
            System.out.println("键：" + s1 + "," + "值：" + s2);
        });
        try {
            BeanUtils.populate(contact,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Integer count = contactService.updateContact(contact);
        if (count > 0){
            out.println("<script>");
            out.println("alert('修改成功');");
            out.println("location.href='index.jsp';");
            out.println("</script>");
            //  response.sendRedirect("/contact");
        }else {
            out.println("<script>");
            out.println("alert('修改失败');");
            out.println("</script>");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

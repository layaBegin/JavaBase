package com.heima.servlet05;

import com.heima.entity.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/demo05")
public class Demo05_beanUtils extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        //使用post提交表单会乱码，默认采用欧洲编码，需要改成 utf-8
        request.setCharacterEncoding("utf-8");
        User user = new User();
        writer.println("复制前："+ user +"<hr/>");
        Map<String, String[]> stringMap = request.getParameterMap();
        try {
            BeanUtils.populate(user, stringMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        writer.println("复制后："+ user);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

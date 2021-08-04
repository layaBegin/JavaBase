package com.heima.controller;

import com.heima.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1000, "猪八戒", true, 65));
        studentList.add(new Student(2000, "白骨精", false, 85));
        studentList.add(new Student(3000, "嫦娥", true, 90));
        studentList.add(new Student(4000, "唐僧", true, 87));
        studentList.add(new Student(5000, "蜘蛛精", false, 85));
        request.setAttribute("studentList",studentList);
        request.getRequestDispatcher("/demo04.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

package com.heima.controller;

import com.heima.entity.Book;
import com.heima.service.BookService;
import com.heima.service.impl.BookServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addbook")
public class AddBookServlet extends HttpServlet {
    BookService bookService = new BookServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.请求设置编码
        request.setCharacterEncoding("utf-8");
        //2,
        Book book = new Book();
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            BeanUtils.populate(book,parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        int row = bookService.addBook(book);
        if (row != 0){
            response.sendRedirect("success.html");
        }else {
            response.sendRedirect("index.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

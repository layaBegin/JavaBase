package com.heima.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heima.entity.Area;
import com.heima.service.impl.AreaServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/area")
public class servlet extends HttpServlet {

    AreaServiceImpl areaService = new AreaServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid = request.getParameter("pid");
        List<Area> cityByPid = areaService.findCityByPid(Integer.parseInt(pid));
        String s = new ObjectMapper().writeValueAsString(cityByPid);
        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(s);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

package com.heima.controller;

import com.heima.entity.Route;
import com.heima.service.Impl.RouteServiceImpl;
import com.heima.service.RouteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/route")
public class RouteServlet extends HttpServlet {
    RouteService routeService = new RouteServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Route> allRoutes = routeService.findAllRoutes();
        request.setAttribute("routes",allRoutes);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

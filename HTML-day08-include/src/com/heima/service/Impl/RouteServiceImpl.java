package com.heima.service.Impl;

import com.heima.dao.Impl.RouteDaoImpl;
import com.heima.dao.RouteDao;
import com.heima.entity.Route;
import com.heima.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {
    RouteDao routeDao = new RouteDaoImpl();
    @Override
    public List<Route> findAllRoutes() {
        List<Route> allRoutes = routeDao.findAllRoutes();
        return allRoutes;
    }
}

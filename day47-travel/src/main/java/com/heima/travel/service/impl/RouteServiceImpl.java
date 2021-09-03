package com.heima.travel.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heima.travel.dao.RouteDao;
import com.heima.travel.domain.Route;
import com.heima.travel.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteDao routeDao;

    @Override
    public PageInfo<Route> findRouteByCid(int cid, int pageNum) {
        PageHelper.startPage(pageNum,3);

        List<Route> routeByCid = routeDao.findRouteByCid(cid);
        PageInfo<Route> routePageInfo = new PageInfo<>(routeByCid);
        return routePageInfo;
    }
}

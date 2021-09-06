package com.heima.travel.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heima.travel.dao.RouteDao;
import com.heima.travel.domain.Category;
import com.heima.travel.domain.Route;
import com.heima.travel.domain.RouteImg;
import com.heima.travel.domain.Seller;
import com.heima.travel.service.RouteService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteDao routeDao;

    @Override
    public PageInfo<Route> findRouteByCid(int cid, int pageNum,String rname) {
        PageHelper.startPage(pageNum,3);
        if (!rname.isEmpty()){
            cid = 0;
        }
        List<Route> routeByCid = routeDao.findRouteByCid(cid,rname);
        PageInfo<Route> routePageInfo = new PageInfo<>(routeByCid);
        return routePageInfo;
    }

    @Override
    public Route findRouteByRid(Integer rid) throws InvocationTargetException, IllegalAccessException {
        Map<String, Object> params = routeDao.findRouteByRid(rid);
        List<RouteImg> listImage = routeDao.findRouteImageByRid(rid);
        Route route = new Route();
        Category category = new Category();
        Seller seller = new Seller();
        BeanUtils.populate(route,params);
        BeanUtils.populate(seller,params);
        BeanUtils.populate(category,params);
        route.setRouteImgList(listImage);
        route.setCategory(category);
        route.setSeller(seller);
        return route;
    }

    public Route findRoute(int rid){
        return routeDao.findRoute(rid);
    }


}

package com.heima.travel.service;

import com.github.pagehelper.PageInfo;
import com.heima.travel.domain.Route;
import com.heima.travel.domain.RouteImg;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public interface RouteService {

    /**根据cid 查询当前页路线
     *     PageInfo 相当于以前的PageBean，
     */
    PageInfo<Route> findRouteByCid(int cid,int pagenum,String rname);

    Route findRouteByRid(Integer rid) throws InvocationTargetException, IllegalAccessException;
    Route findRoute(int rid);

}

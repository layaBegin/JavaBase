package com.heima.travel.controller;

import com.github.pagehelper.PageInfo;
import com.heima.travel.domain.Route;
import com.heima.travel.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping(value = "/route",produces="application/json;charset=utf-8")
public class RouteController {

    @Autowired
    private RouteService routeService;

    /**
     *
     * @param cid 默认值 0，@RequestParam(defaultValue = "0")
     * @param currentPage , 默认值1， 用 @RequestParam(defaultValue = "1")
     * @return
     */
    @RequestMapping("/find")
    public PageInfo<Route> findRouteByCid(@RequestParam(defaultValue = "0") Integer cid, @RequestParam(defaultValue = "1") Integer currentPage,@RequestParam(defaultValue = "") String rname){
        return routeService.findRouteByCid(cid,currentPage,rname);
    }


    @RequestMapping("/findRouteByRid")
    public Route findRouteByRid(Integer rid) throws InvocationTargetException, IllegalAccessException {
        return routeService.findRouteByRid(rid);
    }
}

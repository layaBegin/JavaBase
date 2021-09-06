package com.heima.travel.dao;

import com.heima.travel.domain.Route;
import com.heima.travel.domain.RouteImg;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface RouteDao {

    //如果要使用动态sql。一个参数也要加@Param
    List<Route> findRouteByCid(@Param("cid") Integer cid,@Param("rname") String rname);

    @Select("select * from tab_route r inner join tab_category c on r.`cid`=c.`cid` " +
            "inner join tab_seller s on r.`sid`=s.`sid` where rid=#{rid}")
    Map<String,Object> findRouteByRid(Integer rid);
    @Select("SELECT * FROM tab_route_img WHERE rid=#{rid}")
    List<RouteImg> findRouteImageByRid(Integer rid);
    @Select("SELECT * FROM tab_route WHERE rid=#{rid}")
    Route findRoute(int rid);
}

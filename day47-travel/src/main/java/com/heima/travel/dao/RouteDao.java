package com.heima.travel.dao;

import com.heima.travel.domain.Route;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RouteDao {

    //如果要使用动态sql。一个参数也要加@Param
    List<Route> findRouteByCid(@Param("cid") Integer cid);
}

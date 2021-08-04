package com.heima.dao;

import com.heima.entity.Route;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RouteDao {
    /**
     * 查询所有旅游线路
     * @return
     */
    @Select("select * from route")
    List<Route> findAllRoutes();
}

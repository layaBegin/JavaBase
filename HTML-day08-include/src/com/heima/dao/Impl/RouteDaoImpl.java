package com.heima.dao.Impl;

import com.heima.dao.RouteDao;
import com.heima.entity.Route;
import com.heima.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RouteDaoImpl implements RouteDao {


    /**
     * 查询所有旅游线路
     *
     * @return
     */
    @Override
    public List<Route> findAllRoutes() {
        SqlSession session = MyBatisUtils.getSession();
        RouteDao mapper = session.getMapper(RouteDao.class);
        List<Route> allRoutes = mapper.findAllRoutes();

        return allRoutes;
    }
}

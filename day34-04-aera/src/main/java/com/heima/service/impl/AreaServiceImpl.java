package com.heima.service.impl;

import com.heima.dao.AreaDao;
import com.heima.entity.Area;
import com.heima.service.AreaService;
import com.heima.utils.DaoInstanceFactory;

import java.util.List;

public class AreaServiceImpl implements AreaService {

    @Override
    public List<Area> findCityByPid(Integer pid){
        AreaDao bean = DaoInstanceFactory.getBean(AreaDao.class);
        List<Area> cityByPid = bean.findCityByPid(pid);
        return cityByPid;
    }

}

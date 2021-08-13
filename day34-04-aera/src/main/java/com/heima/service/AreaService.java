package com.heima.service;

import com.heima.entity.Area;

import java.util.List;

public interface AreaService {

    List<Area> findCityByPid(Integer pid);

}

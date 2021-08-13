package com.heima.dao;

import com.heima.entity.Area;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AreaDao {
    //@Select("SELECT * FROM `area` WHERE pid = #{pid}")
    List<Area> findCityByPid(Integer pid);
}

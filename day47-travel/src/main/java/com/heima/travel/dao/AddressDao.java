package com.heima.travel.dao;

import com.heima.travel.domain.Address;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AddressDao  {

    @Select("select * from  tab_address where uid=#{uid}")
    List<Address> findAddressByUid(Integer uid);

    //根据地址id查找地址对象
    @Select("select * from  tab_address where aid=#{aid}")
    Address findByAid(Integer aid);


}

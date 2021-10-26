package com.heima.dao;



import com.heima.model.Contract;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ContractDao extends BaseMapper<Contract> {

    @Select("SELECT * FROM co_contract c WHERE DATE_FORMAT(c.`ship_time`,'%Y-%m')=#{shipTime}")
    public List<Contract> findByShipTime(String shipTime);

    @Select("SELECT SUM(p.`amount`) `value` ,p.`factory_name` `name`   FROM co_contract_product p GROUP BY p.`factory_name`")
    public List<Map<String,Object>> getAmount();
    @Select("SELECT DATE_FORMAT(s.`time`,'%H') h,COUNT(*) num FROM st_sys_log s GROUP BY DATE_FORMAT(s.`time`,'%H')")
    public List<Map<Object,Object>> getLog();

    @Select("SELECT i.`A1` `name`,IFNULL(temp.num,0) `value` FROM st_online_info i LEFT JOIN\n" +
            " (SELECT DATE_FORMAT(s.`time`,'%H') h,COUNT(*) num FROM st_sys_log s GROUP BY DATE_FORMAT(s.`time`,'%H')) temp\n" +
            " ON i.`A1` = temp.h")
    public List<Map<Object,Object>> getHour();
}



package com.heima.travel.dao;

import com.heima.travel.domain.OrderItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface OrderItemDao {

    @Insert("insert into tab_orderitem values(null,#{itemtime},#{state},#{num},#{subtotal},#{rid},#{oid})")
    void save(OrderItem orderItem);

    @Update("update tab_orderitem set state=1 where oid=#{oid}")
    void updateSate(String oid);
}

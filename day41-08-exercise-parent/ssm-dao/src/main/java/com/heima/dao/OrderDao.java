package com.heima.dao;

import com.heima.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {
    /**
     * 如果参数出现在 if 等 sql函数中，参数必须指定 @Param("xxx")
     * @param address
     * @return
     */
    List<Order> findUserAndOrder(@Param("address") String address);
}

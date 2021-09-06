package com.heima.travel.service;

import com.heima.travel.domain.Address;
import com.heima.travel.domain.Order;
import com.heima.travel.domain.User;

import java.util.Map;

public interface OrderService {

    Order save(User user, Address address);

    /**
     *
     * @param param 微信传过来的 参数，包含订单号 和 订单状态
     */
    void updateState(Map<String ,Object> param);

    boolean isPay(String oid);
}

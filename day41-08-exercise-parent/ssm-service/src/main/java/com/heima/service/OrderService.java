package com.heima.service;

import com.heima.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> findUserAndOrder(String address);

}

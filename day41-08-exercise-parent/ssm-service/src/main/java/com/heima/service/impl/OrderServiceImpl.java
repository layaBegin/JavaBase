package com.heima.service.impl;

import com.heima.dao.OrderDao;
import com.heima.entity.Order;
import com.heima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public List<Order> findUserAndOrder(String address) {
        return orderDao.findUserAndOrder(address);
    }
}

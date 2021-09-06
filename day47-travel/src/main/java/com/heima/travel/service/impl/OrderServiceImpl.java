package com.heima.travel.service.impl;

import com.heima.travel.dao.OrderDao;
import com.heima.travel.dao.OrderItemDao;
import com.heima.travel.domain.*;
import com.heima.travel.service.OrderService;
import com.heima.travel.utils.CartUtils;
import com.heima.travel.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private CartUtils cartUtils;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderItemDao orderItemDao;
    @Override
    public Order save(User user, Address address) {
        Cart cart = cartUtils.getCartFromRedis(user);
        Order order = new Order();
        order.setUid(user.getUid());
        order.setTelephone(address.getTelephone());
        order.setContact(address.getContact());
        order.setState(0);//0 未完成，1 已完成
        order.setAddress(address.getAddress());
        order.setTotal(cart.getCartTotalMoney());
        order.setOid(UuidUtils.simpleUuid());
        order.setOrdertime(new Date());
        orderDao.save(order);
        order.setUser(user);
        List<OrderItem> orderItemList = new ArrayList<>();

        LinkedHashMap<Integer, CartItem> cartItemMap = cart.getCartItemMap();
        for (CartItem cartItem : cartItemMap.values()){
            OrderItem orderItem = new OrderItem();
            orderItem.setOid(order.getOid());
            orderItem.setRid(cartItem.getRoute().getRid());
            orderItem.setSubtotal(cartItem.getSubTotal());
            orderItem.setItemtime(new Date());
            orderItem.setState(0);
            orderItem.setNum(cartItem.getNum());
            orderItemDao.save(orderItem);
            orderItemList.add(orderItem);
        }
        order.setOrderItemList(orderItemList);
        return order;
    }

    @Override
    public void updateState(Map<String, Object> param) {

        String oid = (String) param.get("out_trade_no");
        String state = (String) param.get("result_code");
        if ("SUCCESS".equalsIgnoreCase(state)){
            orderDao.updateSate(oid);
            orderItemDao.updateSate(oid);
        }else {
            throw new RuntimeException("支付失败");
        }
    }

    @Override
    public boolean isPay(String oid) {
        Order order = orderDao.findOrderByOid(oid);
        return order.getState() == 1 ? true : false;
    }


}

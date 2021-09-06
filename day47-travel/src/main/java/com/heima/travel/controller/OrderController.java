package com.heima.travel.controller;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.heima.travel.domain.*;
import com.heima.travel.service.AddressService;
import com.heima.travel.service.OrderService;
import com.heima.travel.utils.CartUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private AddressService addressService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CartUtils cartUtils;
    @RequestMapping("/address")
    public ResultInfo prepareOrder(HttpSession session){

        User user = (User) session.getAttribute("user");
        List<Address> addressList = addressService.findAddressByUid(user.getUid());
        Cart cart = cartUtils.getCartFromRedis(user);
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("addressList",addressList);
        map.put("cart",cart);
        return new ResultInfo(true,map);
    }

    @RequestMapping("/save")
    public ResultInfo saveOrder(Integer aid,HttpSession session){
        User user = (User) session.getAttribute("user");
        Address address = addressService.findByAid(aid);
        Order order = orderService.save(user, address);
        return new ResultInfo(true,order);
    }


}

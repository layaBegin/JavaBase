package com.heima.controller;

import com.heima.entity.Order;
import com.heima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/find")
    public ModelAndView findUserAndOrder(String address){
        List<Order> userAndOrder = orderService.findUserAndOrder(address);
        return new ModelAndView("list","orderList",userAndOrder);

    }
}

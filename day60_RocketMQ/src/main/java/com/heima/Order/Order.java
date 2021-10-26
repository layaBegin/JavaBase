package com.heima.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private long id; //订单id

    private String desc; //订单描述信息


    //这个方法是模拟多个订单
    public static List<Order> buildOrders(){
        List<Order> list = new ArrayList<Order>();
        Order order1a = new Order(4L, "创建订单a");
        Order order2a = new Order(5L, "创建订单b");
        Order order3a = new Order(6L, "创建订单c");
        list.add(order1a);
        list.add(order2a);
        list.add(order3a);

        Order order1b = new Order(4L, "支付a");
        Order order2b = new Order(5L, "支付b");
        Order order3b = new Order(6L, "支付c");
        list.add(order1b);
        list.add(order2b);
        list.add(order3b);


        Order order1c = new Order(4L, "完成a");
        Order order2c = new Order(5L, "完成b");
        Order order3c = new Order(6L, "完成c");
        list.add(order1c);
        list.add(order2c);
        list.add(order3c);
        return list;
    }
}

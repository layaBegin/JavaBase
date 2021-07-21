package com.heima8.dao;

import com.heima8.pojo.Orders;
import com.heima8.pojo.Role;
import com.heima8.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrdersMapper {
    Orders findOrdersByIdWithUser(int oId);
    List<Orders> findOrders();

    User findUserByIdWithOrders(int id);

    List<Role> findRoleByNameWithUser(@Param("rname1") String rname1, @Param("rname2") String rname2);

    Orders findOrderById(Integer i);
    Orders findOrderByUid(Integer i);

    User findUserByUid(Integer i);

    //嵌套查询
    Orders findOrdersByIdWithUser2(Integer i);
    //嵌套查询，id为41 的用户和对应的订单
    User findUserByIdWithOrders2(Integer i);
}

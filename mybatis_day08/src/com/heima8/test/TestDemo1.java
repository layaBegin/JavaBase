package com.heima8.test;

import com.heima8.dao.OrdersMapper;
import com.heima8.pojo.Orders;
import com.heima8.pojo.Role;
import com.heima8.pojo.User;
import com.heima8.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestDemo1 {

    //多表查询
    @Test
    public void test01() throws Exception {
        SqlSession session = MybatisUtils.openSession();
        OrdersMapper om = session.getMapper(OrdersMapper.class);
        Orders orders = om.findOrdersByIdWithUser(1);
        /*List<Orders> orders = om.findOrders();
        for (int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i));
        }*/
        System.out.println(orders);
        MybatisUtils.commitAndClose(session);
    }

    @Test
    public void test02() throws Exception {
        SqlSession session = MybatisUtils.openSession();
        OrdersMapper om = session.getMapper(OrdersMapper.class);
        User user = om.findUserByIdWithOrders(41);

        System.out.println(user);
        MybatisUtils.commitAndClose(session);
    }

    @Test
    public void test03() throws Exception {
        SqlSession session = MybatisUtils.openSession();
        OrdersMapper om = session.getMapper(OrdersMapper.class);
        List<Role> list = om.findRoleByNameWithUser("院长","总裁");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        MybatisUtils.commitAndClose(session);
    }

    //分步骤查询
    @Test
    public void test04() throws Exception {
        SqlSession session = MybatisUtils.openSession();
        OrdersMapper om = session.getMapper(OrdersMapper.class);
        Orders orders =  om.findOrderById(1);
        User user = om.findUserByUid(orders.getUid());
        orders.setUser(user);
        System.out.println(orders);
        MybatisUtils.commitAndClose(session);
    }

    //嵌套查询
    @Test
    public void test05() throws Exception {
        SqlSession session = MybatisUtils.openSession();
        OrdersMapper om = session.getMapper(OrdersMapper.class);
        Orders orders = om.findOrdersByIdWithUser2(1);
        System.out.println(orders);
        MybatisUtils.commitAndClose(session);
    }


    @Test
    public void test022() throws Exception {
        SqlSession session = MybatisUtils.openSession();
        OrdersMapper om = session.getMapper(OrdersMapper.class);
        User user = om.findUserByIdWithOrders2(41);

        System.out.println(user);
        MybatisUtils.commitAndClose(session);
    }


    //懒加载，订单为1 的用户
    @Test
    public void test055() throws Exception {
        SqlSession session = MybatisUtils.openSession();
        OrdersMapper om = session.getMapper(OrdersMapper.class);
        Orders orders = om.findOrdersByIdWithUser2(1);
        //懒加载，当要调用getUser 的时候加载User
        //User user = orders.getUser();
//        System.out.println(orders);
        MybatisUtils.commitAndClose(session);
    }

}

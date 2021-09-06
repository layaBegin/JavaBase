package com.heima.test;

import com.github.pagehelper.PageInfo;
import com.heima.travel.domain.Route;
import com.heima.travel.domain.User;
import com.heima.travel.service.RouteService;
import com.heima.travel.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestUser {

    /*@Autowired
    private UserService userService;
    @Test
    public void testUser(){
        User user = new User(0,"litty","123","123456765",null);
        userService.register(user);

    }*/

    @Autowired
    private RouteService routeService;

   /* @Test
    public void testRoute(){
        PageInfo<Route> pageInfo = routeService.findRouteByCid(1, 1);
        System.out.println("总记录数："+ pageInfo.getTotal());
        System.out.println("总页数："+ pageInfo.getPages());
        System.out.println("当前页："+ pageInfo.getPageNum());
        System.out.println("页面的大小："+ pageInfo.getPageSize());
        System.out.println("页面的数据："+ pageInfo.getList());
    }*/
}

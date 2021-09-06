package com.heima.travel.controller;

import com.heima.travel.domain.*;
import com.heima.travel.service.RouteService;
import com.heima.travel.utils.CartUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.util.LinkedHashMap;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartUtils cartUtils;

    @Autowired
    private RouteService routeService;

    @RequestMapping("/addToCart")
    public ResultInfo addToCart(Integer num, Integer rid, HttpSession session){
        User user = (User) session.getAttribute("user");
        Cart cart = cartUtils.getCartFromRedis(user);
        LinkedHashMap<Integer, CartItem> cartItemMap = cart.getCartItemMap();
        CartItem cartItem = cartItemMap.get(rid);
        if (cartItem == null){
            cartItem = new CartItem();
            cartItem.setNum(num);
            Route route = routeService.findRoute(rid);
            cartItem.setRoute(route);
            cartItemMap.put(rid,cartItem);
        }else {
            cartItem.setNum(cartItem.getNum() + num);
        }
        cartUtils.setCartToRedis(user,cart);
        session.setAttribute("cartItem",cartItem);//用来显示购物项
        return new ResultInfo(true,"添加成功");
    }

    @RequestMapping("/showCartItem")
    public ResultInfo showCartItem(HttpSession session){
        CartItem cartItem = (CartItem) session.getAttribute("cartItem");
        return new ResultInfo(true,"添加成功",cartItem);
    }

    @RequestMapping("/findAll")
    public ResultInfo findAllInCart(HttpSession session){
        User user = (User) session.getAttribute("user");
        Cart cart = cartUtils.getCartFromRedis(user);
        return new ResultInfo(true,"找到购物车成功",cart);

    }

    @RequestMapping("/delete")
    public ResultInfo deleteInCart(Integer rid,HttpSession session){
        User user = (User) session.getAttribute("user");
        Cart cart = cartUtils.getCartFromRedis(user);
        LinkedHashMap<Integer, CartItem> cartItemMap = cart.getCartItemMap();
        cartItemMap.remove(rid);
        cartUtils.setCartToRedis(user,cart);
        return new ResultInfo(true,cart);

    }
}

package com.heima.travel.utils;

import com.heima.travel.domain.Cart;
import com.heima.travel.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class CartUtils {
    @Autowired
    RedisTemplate<String,Cart> redisTemplate;

    public void setCartToRedis(User user, Cart cart){
        redisTemplate.opsForValue().set("cart_"+user.getUsername(),cart);
    }

    public Cart getCartFromRedis(User user){
        ValueOperations<String, Cart> stringCartValueOperations = redisTemplate.opsForValue();
        Cart cart = stringCartValueOperations.get("cart_" + user.getUsername());
        if (cart == null){
            cart = new Cart();
        }
        return  cart;
    }

    public void removeCart(User user){
        redisTemplate.delete("cart_"+user.getUsername());
    }
}

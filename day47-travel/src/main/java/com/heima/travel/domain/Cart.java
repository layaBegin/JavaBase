package com.heima.travel.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
@Data
public class Cart implements Serializable {

    private int cartNum;//购物数量

    private double cartTotalMoney;//总金额
    //使用LinkedHashMap 存储购物项，增删方便
    private LinkedHashMap<Integer,CartItem> cartItemMap = new LinkedHashMap<>();

    public int getCartNum() {
        cartNum = 0;
        for (CartItem cartItem : cartItemMap.values()){
            cartNum += cartItem.getNum();
        };
        return cartNum;
    }

    public double getCartTotalMoney() {
        cartTotalMoney = 0;
        for (CartItem cartItem : cartItemMap.values()){
            cartTotalMoney += cartItem.getSubTotal();
        };
        return cartTotalMoney;
    }

    public LinkedHashMap<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(LinkedHashMap<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }
}

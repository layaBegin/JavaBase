package com.heima.travel.domain;

import lombok.Data;

import java.io.Serializable;

//购物项
@Data
public class CartItem implements Serializable {

    private Route route;
    private int num;//数量
    private double subTotal;//小计



    public double getSubTotal() {
       this.subTotal = route.getPrice() * num;
        return this.subTotal;
    }


}

package com.heima.service.impl;

import com.heima.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    public CustomerServiceImpl(){

    }
    //如果有有参构造，必须加上无参构造
    public CustomerServiceImpl(String name){

    }
    @Override
    public void saveCustomer() {
        System.out.println("保存了客户");
    }

    public void init(){
        System.out.println("执行初始化方法");
    }

    public void destroy(){
        System.out.println("执行销毁方法");
    }
}

package com.heima.service.impl;

import com.heima.service.AccountService;
import org.springframework.stereotype.Service;


public class AccountServiceImpl implements AccountService {
    @Override
    public void saveAccount(String name) {
        System.out.println("保存了账户：" + name);
    }
}

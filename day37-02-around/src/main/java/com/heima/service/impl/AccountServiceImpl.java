package com.heima.service.impl;

import com.heima.service.AccountService;
import org.springframework.stereotype.Service;


public class AccountServiceImpl implements AccountService {
    @Override
    public int saveAccount(String name) {
        if ("zhangshan".equals(name)){
            throw new RuntimeException("垃圾");
        }
        System.out.println("保存了账户：" + name);
        return 1;
    }

    @Override
    public void update() {
        System.out.println("更新，无参数");

    }
}

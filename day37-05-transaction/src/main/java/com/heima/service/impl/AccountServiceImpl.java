package com.heima.service.impl;

import com.heima.dao.AccountDao;
import com.heima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public void transfer(String fromAccount, String toAccount, double money) {
        accountDao.updateAccount(fromAccount,-money);
        System.out.println(1/0);
        accountDao.updateAccount(toAccount,money);
        System.out.println("转账成功 ");
    }
}

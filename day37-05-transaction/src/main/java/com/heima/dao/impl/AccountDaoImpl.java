package com.heima.dao.impl;

import com.heima.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int updateAccount(String name,Double money) {
        int count = jdbcTemplate.update("update account set money=money+? where name=?", money, name);
        return count;
    }
}

package com.heima.dao.impl;

import com.heima.entity.User;
import com.heima.dao.UserDao;
import com.heima.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

public class UserDaoImpl implements UserDao {
    @Override
    public User findUser(String username, String password) {
        SqlSession session = MyBatisUtils.getSession();
        UserDao mapper = session.getMapper(UserDao.class);
        User user = mapper.findUser(username, password);
        session.close();
        return user;
    }
}

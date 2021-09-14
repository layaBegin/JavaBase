package com.heima.service;

import com.heima.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAllUer();

    Integer save(User user);

}

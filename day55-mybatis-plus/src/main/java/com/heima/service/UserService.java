package com.heima.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.User;

public interface UserService extends IService<User> {

    Integer updateOrder();
}

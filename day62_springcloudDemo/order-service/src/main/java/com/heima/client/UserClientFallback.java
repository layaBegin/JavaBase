package com.heima.client;

import com.heima.user.pojo.User;
import org.springframework.stereotype.Component;

@Component // 生成bean
public class UserClientFallback implements UserClient {

    @Override
    // 对应接口的降级逻辑
    public User findOne(Long id) {
        User user = new User();
        user.setId(1L);
        user.setName("用户异常");
        return user;
    }
}

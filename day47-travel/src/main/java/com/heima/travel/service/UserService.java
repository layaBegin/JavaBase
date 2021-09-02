package com.heima.travel.service;

import com.heima.travel.domain.ResultInfo;
import com.heima.travel.domain.User;

public interface UserService {

    User findUserByUsername(String username);

    ResultInfo register(User user);


    ResultInfo sendSms(String telephone,String authCode);
    ResultInfo login(String username,String password,String authCode);

}

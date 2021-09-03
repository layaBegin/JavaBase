package com.heima.travel.service.impl;

import com.heima.travel.dao.UserDao;
import com.heima.travel.domain.ResultInfo;
import com.heima.travel.domain.User;
import com.heima.travel.service.UserService;
import com.heima.travel.utils.Md5Utils;
import com.heima.travel.utils.SmsUtils;
import com.heima.travel.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    public ResultInfo register(User user){
        User userByUsername = userDao.findUserByUsername(user.getUsername());

        if (userByUsername != null){
            return new ResultInfo(false,"用户名已存在");
        }
        User userBytelephone = userDao.findUserBytelephone(user.getTelephone());
        if (userBytelephone != null){
            return new ResultInfo(false,"手机号已存在");
        }
        String salt = UuidUtils.simpleUuid();
        String strpPassword = user.getUsername() + user.getPassword() + salt;
        String md5 = Md5Utils.getMd5(strpPassword);
        user.setSalt(salt);
        user.setPassword(md5);
        Integer integer = userDao.saveUser(user);
        if (integer > 0){
            return new ResultInfo(true,"注册成功");
        }else {
            return new ResultInfo(false,"注册失败");

        }
    }

    @Override
    public ResultInfo sendSms(String telephone, String authCode) {
        System.out.println("authCode:"+authCode);
        //String code = SmsUtils.send(telephone, "黑马旅游网", "SMS_205126318", authCode);
        String code = "ok";//调试用
        if ("ok".equalsIgnoreCase(code)){
            ValueOperations valueOperations = redisTemplate.opsForValue();
            //redis 存储短信验证码
            valueOperations.set("sms_"+telephone,authCode,1, TimeUnit.MINUTES);
            return new ResultInfo(true,"发送成功");
        }else {
            return new ResultInfo(false,"发送失败");

        }
    }

    @Override
    public ResultInfo login(String username, String password, String authCode, HttpSession session) {
        User user = this.findUserByUsername(username);
        ValueOperations valueOperations = redisTemplate.opsForValue();
        String authCodeRedis = (String) valueOperations.get("sms_" + user.getTelephone());
        //首先验证验证码
        if (authCodeRedis == null || !authCodeRedis.equalsIgnoreCase(authCode)){
            return new ResultInfo(false,"验证码错误");
        }
        String password1 = user.getPassword();
        String salt = user.getSalt();
        String strpPassword = username + password + salt;
        String md5 = Md5Utils.getMd5(strpPassword);
        if (!md5.equalsIgnoreCase(password1)){
            return new ResultInfo(false,"用户名或密码错误");
        }
        session.setAttribute("user",user);
        return new ResultInfo(true,"登录成功");
    }
}

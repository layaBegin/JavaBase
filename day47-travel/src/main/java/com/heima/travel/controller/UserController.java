package com.heima.travel.controller;

import com.heima.travel.domain.ResultInfo;
import com.heima.travel.domain.User;
import com.heima.travel.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@RestController //默认应该返回json格式，但我们导入了xml依赖，所以以xml格式返回了，不过vue本身可以解析xml
@RequestMapping(value="/user",produces = "application/json;charset=utf-8") //指定格式就可以返回json 格式了
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping("/register")
    public ResultInfo register(@RequestBody Map<String,Object> param) throws InvocationTargetException, IllegalAccessException {
        Map<String,Object> mapUser = (Map<String,Object>) param.get("user");//不能直接转成User对象
        String smsCode = (String) param.get("smsCode");
        User user = new User();
        BeanUtils.populate(user,mapUser);
        ValueOperations valueOperations = redisTemplate.opsForValue();
        String key = "sms_"+user.getTelephone();
        String authCode = (String) valueOperations.get(key);
        if (authCode == null){
            return new ResultInfo(false,"验证码已过期");

        }else if (!authCode.equalsIgnoreCase(smsCode)){
            return new ResultInfo(false,"验证码错误");
        }
        return userService.register(user);
    }

    @RequestMapping("/checkUsername")
    public ResultInfo checkUsername(String username){
        User userByUsername = userService.findUserByUsername(username);
        if (userByUsername != null){
            return  new ResultInfo(false,"用户名不可用");
        }else {
            return  new ResultInfo(true,"用户名可用");
        }
    }

    @RequestMapping("/sendSms")
    public ResultInfo sendSms(String telephone){
        String authcode = RandomStringUtils.randomNumeric(6);
        ResultInfo resultInfo = userService.sendSms(telephone, authcode);

        return resultInfo;
    }

    @RequestMapping("/sendSmsByUsername")
    public ResultInfo sendSmsByUsername(String username){
        if (username == null){
            return new ResultInfo(false,"用户名不能为空");
        }
        User userByUsername = userService.findUserByUsername(username);
        if (userByUsername == null){
            return new ResultInfo(false,"用户名不存在");
        }else {
            String telephone = userByUsername.getTelephone();
            String authcode = RandomStringUtils.randomNumeric(6);
            return userService.sendSms(telephone, authcode);
        }

    }


    @RequestMapping("/login")
    public ResultInfo login(@RequestBody Map<String,Object> param){
        String username = (String) param.get("username");
        String password = (String) param.get("password");
        String authCode = (String) param.get("authCode");
        if (username == null){
            return new ResultInfo(false,"用户名不能为空");
        }
        if (password == null){
            return new ResultInfo(false,"密码不能为空");
        }
        if (authCode == null){
            return new ResultInfo(false,"验证码不能为空");
        }

        return userService.login(username,password,authCode);

    }
}

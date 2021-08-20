package com.heima.convert;

import com.heima.entity.Address;
import com.heima.entity.User;
import org.springframework.core.convert.converter.Converter;

public class UserConvert implements Converter<String,User> {
    /**
     *
     */
    @Override
    public User convert(String source) {
        String[] split = source.split(",");
        User user = new User();
        user.setName(split[0]);
        user.setAge(Integer.parseInt(split[1]));
        Address address = new Address();
        address.setProvince(split[2]);
        address.setCity(split[3]);
        user.setAddress(address);
        return user;
    }



}

package com.heima.demo02_test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static List<User> list = new ArrayList<>();
    static {
        list.add(new User("zhangshan",20));
        list.add(new User("lishi",25));
    }

    public void  register(User user){
        list.add(user);
    }



}

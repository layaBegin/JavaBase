package com.heima.demo02_test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class Demo01_JUnitTest {

    @Test
    public void testRegister(){
        Test1 test1  = new Test1();
        test1.register(new User("wangwu",18));
        Assert.assertEquals("测试是否注册成功",3,Test1.list.size());
    }

    @After
    public void testAfter(){
        Test1.list.remove(new User("wangwu",18) );
        System.out.println(Test1.list.size());
    }

}

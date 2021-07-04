package com.heima.demo01_test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Demo02_JUnitTest {
    List<String> list = new ArrayList<>();
    @Before
    public void testStudy(){
        list.add("aaa");
    }
    @Test
    public void testAdd(){
        System.out.println(list.size());
        /**
         * 断言
         */
        Assert.assertEquals("断言是否相等",1, list.size());
    }

    @After
    public void test1(){
        list.remove("aaa");
    }

}

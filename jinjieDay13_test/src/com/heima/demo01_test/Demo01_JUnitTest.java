package com.heima.demo01_test;

import org.junit.Test;

public class Demo01_JUnitTest {
    @Test
    public void testStudy(){
        Student student = new Student();
        student.study();
    }
    @Test
    public void testAdd(){
        Student student = new Student();
        System.out.println(student.add());
    }

}

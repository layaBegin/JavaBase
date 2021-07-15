package com.heima.reflect;

public class SQLCon implements LzConnection{
    @Override
    public void connection() {
        System.out.println("更换驱动执行连接");
    }
}

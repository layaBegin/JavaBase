package com.heima.reflect;

public class MysqlConnection implements LzConnection{
    @Override
    public void connection() {
        System.out.println("mysql执行连接");
    }
}

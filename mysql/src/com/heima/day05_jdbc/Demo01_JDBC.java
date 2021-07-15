package com.heima.day05_jdbc;

import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

/*
JDBC 入门案例
1，不关注实现，必须要有实现
2，导入驱动
 */
public class Demo01_JDBC {
    public static void main(String[] args) throws Exception {
        //1,注册驱动（让实现类生效）
        /*
        1)DriverManager.registerDriver(new com.mysql.jdbc.Driver())
        2)new Driver;
        #完全限定名，包名+类名
        #类加载会将这个类的字节码加载到内存中，这个类的静态代码块就会执行；
        节省内存和时间
        3) Class.forname("com.mysql.jdbc.Driver");
         */
        //让类加载，节省内存和时间
        Class.forName("com.mysql.jdbc.Driver");
        //2,创建连接
        /*
        #获取连接需要3个参数
        1，url 网址
        2，uername + password
        #url 介绍
        网络编程：计算机与计算机之间的数据交换
            网络3要素：协议，ip，port
            协议：通讯的规范，通讯的两端都要支持同一种协议
            ip：再一个网络中，唯一标识一台计算机
            port：在同一个计算机中唯一标识一个进程（一个成勋至少一个进程）;
        1.网址的格式
            协议://ip:port/资源位置?参数 （https://www.baidu.com:443(可以省略)）
            协议：->jdbc:mysql(主协议：子协议 主协议不变，子协议根据数据库软件决定)
            ip —>localhost 因为mysql 装在本机，如果装在其他计算机，则需要其他计算机的ip
            port（3306）mysql 占用的默认端口
        2，jdbc连接 mysql 写法
            jdbc:mysql://localhost:3306/数据仓库
            如果ip = localhost 并且 port = 3306 可以不写
            jdbc:musql:///数据仓库名





         */
        String url = "jdbc:mysql://localhost:3306/day02_3";
        String user = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, user, password);
        //3，创建执行sql 的对象
        Statement statement = connection.createStatement();
        String sql = "select * from dept";
        ResultSet resultSet = statement.executeQuery(sql);
        //4,处理结果
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("id:"+id + ","+ "name:"+ name);
        }
        //5，释放连接
        resultSet.close();
        statement.close();
        connection.close();

    }
}

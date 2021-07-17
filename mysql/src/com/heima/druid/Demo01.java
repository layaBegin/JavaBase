package com.heima.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.heima.utils.JDBCUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/*
阿里德鲁伊连接池
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();
        ClassLoader classLoader = Demo01.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("druid.properties");
        properties.load(resourceAsStream);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        String sql = "select * from user";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String name = resultSet.getString("name");
            System.out.println(name);
        }
        JDBCUtils.release(resultSet,preparedStatement,connection);

    }
}

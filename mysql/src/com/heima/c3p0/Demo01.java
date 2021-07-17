package com.heima.c3p0;

import com.heima.utils.JDBCUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo01 {
    public static void main(String[] args) throws SQLException {
        /*
        DataSource 接口 sun公司提供的标准

         */
        //创建一个连接池（数据源）
        ComboPooledDataSource ds = new ComboPooledDataSource();
        Connection connection = ds.getConnection();
        String sql = "select * from user";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String name = resultSet.getString("name");
            System.out.println(name);
        }
        /*
        连接用完要还给连接池
            close 方法被增强了（底层动态代理）
                1）以前时释放资源
                2）现在是将连接还给连接池
         */
        JDBCUtils.release(resultSet,preparedStatement,connection);
    }
}

package com.heima.c3p0;

import com.heima.utils.JDBCUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo02 {
    public static void main(String[] args) throws SQLException {
        /*
        DataSource 接口 sun公司提供的标准

         */
        //创建一个连接池（数据源）
        //ComboPooledDataSource ds = new ComboPooledDataSource();
        //备用连接池（数据源）
        ComboPooledDataSource ds1 = new ComboPooledDataSource("beitai");
        for (int i = 0; i < 6; i++) {
            Connection connection = ds1.getConnection();
            System.out.println(connection);
            if (i == 4){
                connection.close();
            }
        }
    }
}

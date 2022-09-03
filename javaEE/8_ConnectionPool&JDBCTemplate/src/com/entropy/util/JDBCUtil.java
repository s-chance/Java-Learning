package com.entropy.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
    private static DataSource dataSource;

    //预加载配置文件
    static {
        try {
            Properties properties = new Properties();
            properties.load(JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接池
    public static DataSource getDataSource() {
        return dataSource;
    }

    //获取连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    ////归还资源到连接池,针对增删改操作的关闭方式
    public static void close(Statement statement, Connection connection) {
        //利用方法重载简化代码
        close(null, statement, connection);
    }

    ////归还资源到连接池,针对查询的关闭方式
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                //归还连接
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

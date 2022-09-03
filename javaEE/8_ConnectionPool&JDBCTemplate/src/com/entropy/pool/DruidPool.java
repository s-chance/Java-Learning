package com.entropy.pool;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidPool {
    public static void main(String[] args) throws Exception {
        //定义配置文件
        Properties properties = new Properties();
        //加载配置文件
        InputStream resource = DruidPool.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(resource);
        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //获取连接
        Connection connection = dataSource.getConnection();
        System.out.println("connection = " + connection);
    }
}

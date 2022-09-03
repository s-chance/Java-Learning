package com.entropy.pool;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Pool {
    @Test
    public void test1() throws SQLException {
        //创建连接池
        DataSource datasource = new ComboPooledDataSource();
        //获取连接
        Connection connection = datasource.getConnection();
        System.out.println("connection = " + connection);
    }

    //测试连接,使用默认配置,最大连接数为10个
    @Test
    public void test2() throws SQLException {
        DataSource dataSource = new ComboPooledDataSource();
        //超过配置文件最大连接数的连接无法获取到,但中途可以释放连接,然后重新获取释放的连接
        for (int i = 0; i < 11; i++) {
            Connection connection = dataSource.getConnection();
            System.out.println("第"+(i+1)+"个connection = " + connection);
            if (i==9) {
                //释放连接
                connection.close();
            }
            //若配置最多10个连接,可以发现这里释放资源之后获取到的第11个连接是来自前面10个连接中的
        }
    }

    //指定获取c3p0连接池,这里配置最大连接数为8个
    @Test
    public void test3() throws SQLException {
        DataSource dataSource = new ComboPooledDataSource("c3p0");
        for (int i = 0; i < 8; i++) {
            Connection connection = dataSource.getConnection();
            System.out.println("第"+(i+1)+"个connection = " + connection);
        }
    }
}

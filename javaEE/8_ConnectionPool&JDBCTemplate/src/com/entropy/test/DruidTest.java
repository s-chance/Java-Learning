package com.entropy.test;

import com.entropy.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidTest {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            //获取连接
            connection = JDBCUtil.getConnection();

            //获取预处理的数据库操作对象
            String sql = "insert into user(name,password) values (?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, "fay");
            ps.setInt(2, 565);

            int rows = ps.executeUpdate();
            System.out.println("rows = " + rows);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //归还资源到连接池
            JDBCUtil.close(ps, connection);
        }
    }
}

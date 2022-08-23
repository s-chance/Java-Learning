package com.entropy.test;

import com.entropy.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtilTest {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            //获取连接
            connection = JDBCUtil.getConnection();
            //获取预处理的数据库操作对象
            String sql = "select * from user where name like ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1,"%m%");
            //执行sql
            resultSet = ps.executeQuery();
            //处理结果集
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("password"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //释放资源
            JDBCUtil.close(connection, ps, resultSet);
        }
    }
}

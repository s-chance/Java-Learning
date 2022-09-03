package com.entropy.test;

import com.entropy.util.JDBCUtil;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {
    public static void main(String[] args) {
        //创建JdbcTemplate对象,只需要提供配置好的连接池即可
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());
        //编写sql语句,直接调用jdbcTemplate提供的方法即可
        String sql = "update user set password=424 where id = ?";
        //增删改操作调用update方法
        int update = jdbcTemplate.update(sql, 2);
        System.out.println("update = " + update);
    }
}

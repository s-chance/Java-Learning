package com.entropy.test;

import com.entropy.pojo.Emp;
import com.entropy.util.JDBCUtil;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());

    //修改id为1的数据的salary为10000
    @Test
    public void test1() {
        String sql = "update emp set salary = ? where id = ?";
        int update = jdbcTemplate.update(sql, 10000, 1);
        System.out.println("update = " + update);
    }

    //新增数据
    @Test
    public void test2() {
        String sql = "insert into emp(id, name,age,sex) values (?,?,?,?)";
        int update = jdbcTemplate.update(sql, 0, "z", 28, "男");
        System.out.println("update = " + update);
    }

    //删除数据
    @Test
    public void test3() {
        String sql = "delete from emp where id = ? and name = ?";
        int update = jdbcTemplate.update(sql, 0, "z");
        System.out.println("update = " + update);
    }

    //查询记录并封装为Map集合 调用queryForMap方法
    @Test
    public void test4() {
        String sql = "select * from emp where id = ?";
        //queryForMap一次只能封装一条记录
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, 1);
        System.out.println("map = " + map);
    }

    //查询所有记录并封装为List集合  调用queryForList方法
    @Test
    public void test5() {
        String sql = "select * from emp";
        //实际上是把每条记录都先封装成Map集合再把全部记录封装成List集合
        //这样保护了键值对的存储方式,保证数据的规范性
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : maps) {
            System.out.println("map = " + map);
        }
    }

    //查询所有记录并封装为自定义的类,利用RowMapper接口
    @Test
    public void test6() {
        String sql = "select * from emp";
        List<Emp> empList = jdbcTemplate.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                Emp emp = new Emp();
                //根据数据表的字段获取数据
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String sex = resultSet.getString("sex");
                double salary = resultSet.getDouble("salary");
                //将获取到的数据存入实体类进行封装
                emp.setId(id);
                emp.setName(name);
                emp.setAge(age);
                emp.setSex(sex);
                emp.setSalary(salary);
                return emp;
            }
        });

        for (Emp emp : empList) {
            System.out.println("emp = " + emp);
        }
    }

    //反射方式实现自定义封装数据,利用BeanPropertyRowMapper
    //虽然反射方式减少了大量代码,但同时也降低了封装的效率
    @Test
    public void test6_2() {
        String sql = "select * from emp";
        List<Emp> empList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : empList) {
            System.out.println("emp = " + emp);
        }
    }

    //查询记录总数 调用queryForObject方法
    @Test
    public void test7() {
        String sql = "select count(id) from emp";
        //queryForObject方法适用于查询结果只有1个参数的情况
        //聚合函数一般就使用queryForObject方法处理
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println("count = " + count);
    }
}

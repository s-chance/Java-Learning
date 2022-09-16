package com.entropy.dao.impl;

import com.entropy.dao.ProvinceDao;
import com.entropy.pojo.Province;
import com.entropy.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());

    //查询所有信息
    @Override
    public List<Province> searchAll() {
        String sql = "select * from province";
        List<Province> provinces = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        if (provinces == null || provinces.size() <= 0) {
            return null;
        }
        return provinces;
    }
}

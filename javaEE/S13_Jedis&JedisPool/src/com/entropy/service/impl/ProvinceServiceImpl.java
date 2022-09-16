package com.entropy.service.impl;

import com.entropy.dao.ProvinceDao;
import com.entropy.dao.impl.ProvinceDaoImpl;
import com.entropy.pojo.Province;
import com.entropy.service.ProvinceService;
import com.entropy.util.JedisPoolUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {

    private ProvinceDao provinceDao = new ProvinceDaoImpl();

    //查询所有信息
    @Override
    public List<Province> searchAll() {
        return provinceDao.searchAll();
    }

    //redis缓存查询
    @Override
    public String searchAllByRedis() {

        //从redis中查询数据

        //获取连接
        Jedis jedis = JedisPoolUtil.getJedis();
        String province = jedis.get("province");

        //判断数据是否存在, 若不存在则从MySQL数据库查询数据并存储
        if (province == null || province.length() == 0) {
            System.out.println("redis还未存储任何数据...");

            //从MySQL查询数据
            List<Province> provinces = provinceDao.searchAll();

            //存储数据之前先将数据序列化为json
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                province = objectMapper.writeValueAsString(provinces);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            //将数据存储到redis中
            jedis.set("province", province);

            //归还连接
            jedis.close();
        } else {
            System.out.println("查询成功");
        }
        return province;
    }
}

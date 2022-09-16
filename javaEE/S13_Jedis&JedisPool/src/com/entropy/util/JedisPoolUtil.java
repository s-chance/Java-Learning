package com.entropy.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisPoolUtil {
    private static JedisPool jedisPool;

    //配置文件预加载
    static {
        //读取配置
        InputStream resource = JedisPoolUtil.class.getClassLoader().getResourceAsStream("jedis.properties");
        //创建对象
        Properties properties = new Properties();
        //关联文件
        try {
            properties.load(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取数据, 并进行设置
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));

        //初始化JedisPool
        jedisPool = new JedisPool(jedisPoolConfig, properties.getProperty("host"), Integer.parseInt(properties.getProperty("port")));
    }

    //获取连接
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}

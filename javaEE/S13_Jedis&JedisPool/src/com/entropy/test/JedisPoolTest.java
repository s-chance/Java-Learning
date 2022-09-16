package com.entropy.test;

import com.entropy.util.JedisPoolUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolTest {
    @Test
    public void test1() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //设置最大允许连接数
        jedisPoolConfig.setMaxTotal(50);
        //设置最大空闲连接数
        jedisPoolConfig.setMaxIdle(10);

        //创建连接池
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "localhost", 6379);

        //getResource()方法获取连接
        Jedis jedis = jedisPool.getResource();

        jedis.set("pool", "success");

        //归还连接
        jedis.close();
    }

    //测试JedisPool工具类
    @Test
    public void test2() {
        Jedis jedis = JedisPoolUtil.getJedis();

        jedis.set("util", "jedisPool");

        jedis.close();
    }
}

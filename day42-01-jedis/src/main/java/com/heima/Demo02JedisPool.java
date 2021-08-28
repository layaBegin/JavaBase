package com.heima;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

/**
 * jedis连接池的基本操作
 */
public class Demo02JedisPool {
    public static void main(String[] args) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxWaitMillis(2000);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"localhost",6379);
        Jedis jedis = jedisPool.getResource();
        jedis.lpush("students","孙悟空","猪八戒","shaheshang");
        List<String> students = jedis.lrange("students", 0, -1);
        System.out.println(students);
        jedis.close();
    }


}

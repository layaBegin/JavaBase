package com.heima.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

public class JedisUtils {

    private static JedisPool jedisPool;
    static {
        /**
         * 读取配置文件，
         */
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jedis");
        String maxTotal = resourceBundle.getString("jedis.maxTotal");
        String maxWaitMillis = resourceBundle.getString("jedis.maxWaitMillis");
        String host = resourceBundle.getString("jedis.host");
        String port = resourceBundle.getString("jedis.port");

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.parseInt(maxTotal));
        jedisPoolConfig.setMaxWaitMillis(Integer.parseInt(maxWaitMillis));
        jedisPool = new JedisPool(jedisPoolConfig,host,Integer.parseInt(port));
    }
    public  static Jedis getJedis(){
        return jedisPool.getResource();
    }
}

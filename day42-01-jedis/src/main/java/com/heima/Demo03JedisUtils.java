package com.heima;


import com.heima.utils.JedisUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;

/**
 * jedis连接池的基本操作
 */
public class Demo03JedisUtils {
    public static void main(String[] args) {
        Jedis jedis = JedisUtils.getJedis();
        jedis.hset("user","name","zhangshan");
        jedis.hset("user","sex","男");
        Map<String, String> users = jedis.hgetAll("user");
        users.forEach((key,value)->{
            System.out.println("key:"+key+",value:"+value);
        });

        jedis.close();
    }


}

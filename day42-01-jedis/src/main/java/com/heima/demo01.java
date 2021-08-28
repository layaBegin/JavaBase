package com.heima;

import redis.clients.jedis.Jedis;
/*
jedis 基本操作
 */
public class demo01 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("company","heima");
        jedis.close();
    }
}

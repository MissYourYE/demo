package com.dubm.apply.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest {

    @Test
    public void test() {
        Jedis jedis = new Jedis("47.114.6.31", 6379);
        jedis.set("test1", "v1");
        String str = jedis.get("test1");
        System.out.println(str);
        jedis.close();
    }

    @Test
    public void testPool() {
        JedisPool jedisPool = new JedisPool("47.114.6.31", 6379);
        Jedis jedis = jedisPool.getResource();
        String str = jedis.get("test1");
        System.out.println(str);
        jedis.close();
        jedisPool.close();
    }

}

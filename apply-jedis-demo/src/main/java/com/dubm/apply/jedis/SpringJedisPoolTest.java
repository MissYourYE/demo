package com.dubm.apply.jedis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

import java.util.Map;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringJedisPoolTest {

    @Autowired
    JedisPool jedisPool;

    @Test
    public void test(){
        Jedis jedis = jedisPool.getResource();
//        Set<String> keys = jedis.keys("*");
//        Map<String, String> user = jedis.hgetAll("user1");
        RedisMsgPubSubListener redisMsgPubSubListener = new RedisMsgPubSubListener();
        jedis.subscribe(redisMsgPubSubListener,"testch");
        jedis.close();
    }
}

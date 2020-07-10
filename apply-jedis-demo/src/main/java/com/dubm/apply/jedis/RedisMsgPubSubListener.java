package com.dubm.apply.jedis;

import redis.clients.jedis.JedisPubSub;

public class RedisMsgPubSubListener extends JedisPubSub {

    @Override
    public void onMessage(String channel, String message) {
        System.out.println(message);
    }

}

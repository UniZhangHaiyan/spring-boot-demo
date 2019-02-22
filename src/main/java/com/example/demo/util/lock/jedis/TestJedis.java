package com.example.demo.util.lock.jedis;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.Arrays;
import java.util.List;

/**
 * TestJedis
 *
 * @author zhanghaiyan 2019/2/12
 * @description
 * @modifier
 */
public class TestJedis {
    static ShardedJedisPool jedisPool;
    static {
        //设置连接池的相关配置
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(2);
        poolConfig.setMaxIdle(1);
        poolConfig.setMaxWaitMillis(2000);
        poolConfig.setTestOnBorrow(false);
        poolConfig.setTestOnReturn(false);

        //设置Redis信息
        String host = "127.0.0.1";
        JedisShardInfo shardInfo1 = new JedisShardInfo(host, 6379, 500);
        JedisShardInfo shardInfo2 = new JedisShardInfo(host, 6380, 500);
        JedisShardInfo shardInfo3 = new JedisShardInfo(host, 6381, 500);

        //初始化ShardedJedisPool
        List<JedisShardInfo> infoList = Arrays.asList(shardInfo1, shardInfo2, shardInfo3);
        jedisPool = new ShardedJedisPool(poolConfig, infoList);
    }

    public static void main(String[] args) {
        ShardedJedis shardedJedis = jedisPool.getResource();
        shardedJedis.setnx("zhy", "1234");
        System.out.println(shardedJedis.get("zhy"));
        if (shardedJedis != null){
            shardedJedis.close();
        }
    }
}

package com.example.demo.util.lock.jedis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * ShardedJedisPoolConfigure
 *
 * @author zhanghaiyan 2019/2/21
 * @description
 * @modifier
 */
@Configuration
public class ShardedJedisPoolConfigure {

    //jedisPoolConfig
    //jedisShardInfo
    //jedisPool

    /**
     * 最大连接数
     */
    @Value("${customer.redis.pool.max-active}")
    private int maxTotal;

    /**
     * 最大空闲数
     */
    @Value("${customer.redis.pool.max-idle}")
    private int maxIdle;

    /**
     * 最长等待时间
     */
    @Value("${customer.redis.pool.max-wait}")
    private int maxWaitMillis;

    /**
     * redis地址组
     */
    @Value("${customer.redis.cluster}")
    private String cluster;

    /**
     * 超时时间
     */
    @Value("${customer.redis.timeout}")
    private int timeout;

    /**
     * redis连接池配置bean注册
     *
     * @return
     */
    @Bean("jedisPoolConfig")
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setMaxIdle(maxIdle);
        return jedisPoolConfig;
    }

    @Bean
    public ShardedJedisPool shardedJedisPool(JedisPoolConfig jedisPoolConfig) {
        List<JedisShardInfo> jedisShardInfoList = new ArrayList<>();
        String[] clusterArray = cluster.split(",");
        for (String item : clusterArray) {
            String[] hostPort = item.split(":");
            JedisShardInfo jedisShardInfo = new JedisShardInfo(hostPort[0], Integer.valueOf(hostPort[1]), timeout);
            jedisShardInfoList.add(jedisShardInfo);
        }
        return new ShardedJedisPool(jedisPoolConfig, jedisShardInfoList);
    }

}

package com.example.demo.util.lock.jedis.cache.customer;

import com.example.demo.util.lock.jedis.cache.serial.ISerialization;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.io.IOException;

/**
 * CacheDelegationImpl
 *
 * @author zhanghaiyan 2019/2/13
 * @description
 * @modifier
 */
@Component
public class CacheDelegationImpl implements ICacheDelegation {

    @Autowired
    private ISerialization serialization;

    @Autowired
    private ShardedJedisPool shardedJedisPool;


    @Override
    public <V> Long setnx(String key, Optional<V> value) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(key), "key is null");
        try {
            byte[] data = serialization.serialize(value);
            if (data != null) {
                try (ShardedJedis shardedJedis = shardedJedisPool.getResource()) {
                    return shardedJedis.setnx(key.getBytes(), data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void del(String key) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(key), "key is null");
        try (ShardedJedis shardedJedis = shardedJedisPool.getResource()) {
            shardedJedis.del(key.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public <V> Optional<V> getset(String key, Optional<V> value) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(key), "key is null");
        Optional<V> result = null;
        try {
            byte[] data = serialization.serialize(value);
            if (data != null) {
                byte[] rs = null;
                try (ShardedJedis shardedJedis = shardedJedisPool.getResource()) {
                    rs = shardedJedis.getSet(key.getBytes(), data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (rs != null) {
                    result = (Optional<V>) serialization.deserialize(rs);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public <V> Optional<V> get(String key) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(key), "key is null");
        Optional<V> result = null;
        byte[] data = null;
        try (ShardedJedis shardedJedis = shardedJedisPool.getResource()) {
            data = shardedJedis.get(key.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (data != null) {
            try {
                result = (Optional<V>) serialization.deserialize(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}

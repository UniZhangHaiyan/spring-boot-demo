package com.example.demo.util.lock.jedis.cache.customer;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * LockCacheImpl
 *
 * @author zhanghaiyan 2019/2/13
 * @description
 * @modifier
 */
@Component
public class LockCacheImpl implements ILockCache {

    @Autowired
    private ICacheDelegation cacheDelegation;

    @Override
    public <V> Long setnx(String key, V value) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(key), "key is null");
        try {
            return cacheDelegation.setnx(key, Optional.fromNullable(value));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void remove(String key) {
        Long oldExpireTime = query(key);
        if (System.currentTimeMillis() < oldExpireTime) {
            cacheDelegation.del(key);
        }
    }

    @Override
    public <V> V getset(String key, V value) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(key), "key is null");
        Optional<V> result = null;
        try {
            result = cacheDelegation.getset(key, Optional.fromNullable(value));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result == null) {
            return null;
        }
        return result.orNull();
    }

    @Override
    public <V> V query(String key) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(key), "key is null");
        Optional<V> result = null;
        try {
            result = cacheDelegation.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result == null) {
            return null;
        }
        return result.orNull();
    }
}

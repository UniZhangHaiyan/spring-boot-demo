package com.example.demo.util.lock.jedis;

import com.example.demo.util.lock.jedis.cache.customer.ILockCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Lock
 *
 * @author zhanghaiyan 2019/2/12
 * @description
 * @modifier
 */
@Component
public class Lock {

    /**
     * 默认最长等待时间
     */
    private static Long DEFAULT_MAX_WAIT_TIME = 5 * 1000L;

    /**
     * 默认锁最长持有时间
     */
    private static Long DEFAULT_MAX_DURATION_TIME = 30 * 60 * 1000L;

    @Autowired
    private ILockCache lockCache;

    /**
     * 加锁
     *
     * @param key          锁key
     * @param waitTime     获取锁等待时间 默认最长等待5s 防止程序无限等待 单位s
     * @param durationTime 锁的持续时间 默认最长锁定30m 单位s
     */
    public void lock(String key, Long waitTime, Long durationTime) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("key is null");
        }

        if (waitTime == null || waitTime > DEFAULT_MAX_WAIT_TIME) {
            waitTime = DEFAULT_MAX_WAIT_TIME;
        }

        if (durationTime == null || durationTime > DEFAULT_MAX_DURATION_TIME) {
            durationTime = DEFAULT_MAX_DURATION_TIME;
        }
        //现比较等待时间是否超限
        Long startTryTime = System.currentTimeMillis();
        try {
            while (true) {
                //等待时间超过设置值最退出循环
                if ((System.currentTimeMillis() - startTryTime) / 1000 > waitTime) {
                    System.out.println("获取锁超时");
                    //这里抛出异常阻断线程继续往下走
                    throw new RuntimeException("获取锁超时");
                }
                boolean result = tryLock(key, durationTime * 1000);
                if (result) {
                    System.out.println("获取锁成功");
                    //这里结束循环线程继续往下走
                    break;
                }

                //睡一会儿
                Thread.sleep(100);
                System.out.println("获取锁等待");
            }
        } catch (Exception e) {
            System.out.println("获取锁异常");
            throw new RuntimeException("获取锁异常");
        }
    }

    /**
     * 释放锁
     *
     * @param key
     */
    public void unlock(String key) {
        Long expireTime = lockCache.query(key);
        if (System.currentTimeMillis() < expireTime) {
            lockCache.remove(key);
        }
    }

    /**
     * 获取key的值
     *
     * @param key
     * @param <V>
     * @return
     */
    public <V> V query(String key) {
        return lockCache.query(key);
    }

    private Boolean tryLock(String key, Long durationTime) {
        //锁的过期时间
        Long expireTime = System.currentTimeMillis() + durationTime + 1;
        //set not exists
        Long result = lockCache.setnx(key, expireTime);
        if (result == 1) {
            return true;
        }
        Long oldExpireTime = lockCache.query(key);
        System.out.println("目前的-==>" + oldExpireTime);
        //只有过期才能尝试更新
        if (oldExpireTime != null && System.currentTimeMillis() > oldExpireTime) {
            Long currentReturnTime = lockCache.getset(key, expireTime);
            if (oldExpireTime != null && oldExpireTime.equals(currentReturnTime)) {
                return true;
            }
        }
        return false;
    }
}

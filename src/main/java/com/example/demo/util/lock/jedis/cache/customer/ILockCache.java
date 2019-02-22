package com.example.demo.util.lock.jedis.cache.customer;

/**
 * ILockCache
 *
 * @author zhanghaiyan 2019/2/13
 * @description
 * @modifier
 */
public interface ILockCache {
    /**
     * 设置锁当且当不存在key的琐时
     *
     * @param key
     * @param value
     * @param <V>
     * @return
     */
    <V> Long setnx(String key, V value);

    /**
     * 删除锁
     *
     * @param key
     */
    void remove(String key);

    /**
     * 设置锁且返回key 上次的value
     *
     * @param key
     * @param value
     * @param <V>
     * @return
     */
    <V> V getset(String key, V value);

    /**
     * 获取key的值
     *
     * @param key
     * @param <V>
     * @return
     */
    <V> V query(String key);
}

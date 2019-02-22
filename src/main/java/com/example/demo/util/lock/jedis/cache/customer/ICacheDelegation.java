package com.example.demo.util.lock.jedis.cache.customer;


import com.google.common.base.Optional;

/**
 * ICacheDelegation
 *
 * @author zhanghaiyan 2019/2/13
 * @description
 * @modifier
 */
public interface ICacheDelegation {
    /**
     * 设置锁当且当不存在key的琐时
     *
     * @param key
     * @param value
     * @param <V>
     * @return
     */
    <V> Long setnx(String key, Optional<V> value);

    /**
     * 删除锁
     *
     * @param key
     */
    void del(String key);

    /**
     * 设置锁且返回key 上次的value
     *
     * @param key
     * @param value
     * @param <V>
     * @return
     */
    <V> Optional<V> getset(String key, Optional<V> value);

    /**
     * 获取key的值
     *
     * @param key
     * @param <V>
     * @return
     */
    <V> Optional<V> get(String key);
}

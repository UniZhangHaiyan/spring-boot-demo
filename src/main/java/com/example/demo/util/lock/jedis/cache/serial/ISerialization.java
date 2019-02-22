package com.example.demo.util.lock.jedis.cache.serial;

import java.io.IOException;

/**
 * ISerialization
 *
 * @author zhanghaiyan 2019/2/13
 * @description 序列化/反序列化接口
 * @modifier
 */
public interface ISerialization {
    byte[] serialize(Object obj) throws IOException;

    Object deserialize(byte[] bytes) throws IOException;
}

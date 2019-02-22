package com.example.demo.util.lock.jedis.cache.serial;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * HessianSerialization
 *
 * @author zhanghaiyan 2019/2/13
 * @description 序列化
 * @modifier
 */
@Component
public class GeneralSerialization implements ISerialization {
    @Override
    public byte[] serialize(Object obj) throws IOException {
        Preconditions.checkNotNull(obj);
        byte[] results;
        ObjectOutputStream out = null;
        try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            out = new ObjectOutputStream(os);
            out.writeObject(obj);
            results = os.toByteArray();
        } finally {
            if (out != null) {
                out.close();
            }
        }
        return results;
    }

    @Override
    public Object deserialize(byte[] bytes) throws IOException {
        Preconditions.checkNotNull(bytes);
        Object obj = null;
        ObjectInputStream ois = null;
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes)) {
            ois = new ObjectInputStream(bis);
            obj = ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                ois.close();
            }
        }
        return obj;
    }
}

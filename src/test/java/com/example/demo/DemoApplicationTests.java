package com.example.demo;

import com.example.demo.util.lock.jedis.Lock;
import com.example.demo.util.lock.springredis.SpringBootRedisLock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    /**
     * 同样使用本地的redis服务，spring-boot的redis锁和自己实现的redis锁同样的key，却互不影响。还以为这俩是相通的
     */
    @Autowired
    private SpringBootRedisLock springBootRedisLock;

    @Autowired
    private Lock lock;

    @Test
    public void testSpringLock() {
        springBootRedisLock.lock("8017363909716979983282", 5L, 10 * 60 * 1000L);
    }

    @Test
    public void testUnlock() {
        springBootRedisLock.unlock("8017363909716979983282");
    }

    @Test
    public void testGet() {
        System.out.println(springBootRedisLock.query("8017363909716979983282"));
    }

    @Test
    public void testNextInt() {
        System.out.println(new Random().nextInt(1) + 1);
        System.out.println(new Random().nextInt(1));
    }

    @Test
    public void testCustomerLock() {
        lock.lock("zhy", 5L, 10 * 60 * 1000L);
    }

    @Test
    public void testCustomerUnlock() {
        lock.unlock("8017363909716979983282");
    }

    @Test
    public void testCustomerGetLock(){
        System.out.println((Long) lock.query("zhy"));
    }

    @Test
    public void tryCatch() {
        int b = 0;
        try {
            b = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("跑出");
        }

        System.out.println("下面继续走" + b);
    }
}


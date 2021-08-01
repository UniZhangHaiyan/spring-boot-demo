package com.example.demo.param;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName UserVaccinatePo
 * @Description 需要延时的对象，用户打疫苗，每五秒给3个人打疫苗
 * 需要实现Delayed方法
 * @Author zhanghaiyan
 * @Date 2021/8/1
 * @Modifier
 */
public class UserVaccinatePo implements Delayed {
    /**
     * 延时时间【毫秒】
     */
    private long time;
    /**
     * 打疫苗的用户
     */
    private String username;

    public UserVaccinatePo(long time, String username, TimeUnit unit) {
        this.time = System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(time, unit);//将源格式【unit】的时间转换为毫秒
        this.username = username;
    }
    /**
     * 获取队列中对象的时间与当前时间的差值
     * @param timeUnit
     * @return
     */
    @Override
    public long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(time - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    /**
     * 比较队列中的时间是否已经到了执行时间
     * @param delayed 队列中第一个对象
     * @return
     */
    @Override
    public int compareTo(Delayed delayed) {
        if (delayed == this) {
            return 0;
        }
        UserVaccinatePo vaccinatePo = (UserVaccinatePo) delayed;
        long duration = this.getDelay(TimeUnit.MILLISECONDS) - vaccinatePo.getDelay(TimeUnit.MILLISECONDS);
        return duration == 0 ? 0 : (duration < 0 ? -1 : 1);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

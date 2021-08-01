package com.example.demo.controller;

import com.example.demo.param.UserVaccinatePo;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName DelayQueueController
 * @Description jdk延时队列使用
 * @Author zhanghaiyan
 * @Date 2021/8/1
 * @Modifier
 */
@RestController
public class DelayQueueController {

    private DelayQueue<UserVaccinatePo> userVaccinatePoDelayQueue = new DelayQueue<>();
    private static List<String> userList = Lists.newArrayList();

    static {
        userList.add("xiaozhang");
        userList.add("xiaoming");
        userList.add("xiaohong");
        userList.add("wanggang");
        userList.add("limeimei");
        userList.add("lilei");
        userList.add("zhouhuajian");
        userList.add("guoqilin");
        userList.add("lixueqin");
        userList.add("zhangzhehan");
        userList.add("gongjun");
        userList.add("zhanghaiyan");
        userList.add("zhouye");
    }

    /**
     * 每5秒给3个用户打疫苗
     */
    @PostMapping("/userVaccinateOrder")
    public void userVaccinateOrder() {
        int groupSize = 0;
        long duration = 0l;
        for (String username : userList) {
            if (groupSize > 2) {
                groupSize = 0;
                duration += 5l;
            }
            userVaccinatePoDelayQueue.add(new UserVaccinatePo(duration, username, TimeUnit.SECONDS));
            groupSize++;
        }

        while (!userVaccinatePoDelayQueue.isEmpty()) {
            UserVaccinatePo userVaccinatePo = null;
            try {
                userVaccinatePo = userVaccinatePoDelayQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = simpleDateFormat.format(new Date(System.currentTimeMillis()));
            System.out.println(time + " 开始给：" + userVaccinatePo.getUsername() + " 打疫苗");
        }
    }

    public static void main(String[] args) {
        DelayQueueController delayQueueController = new DelayQueueController();
        delayQueueController.userVaccinateOrder();
    }

}

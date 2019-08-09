package com.example.demo.controller;

import com.example.demo.entity.Score;
import com.example.demo.entity.Student;
import com.example.demo.service.activity.IScoreService;
import com.example.demo.util.mq.RabbitMqConfig;
import com.rabbitmq.client.Channel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName ActivityController
 * @Description
 * @Author zhanghaiyan
 * @Date 2019/8/6
 * @Modifier
 */
@RestController
@RequestMapping("activity")
public class ActivityController {

    @Autowired
    private IScoreService scoreService;

    @PostMapping
    public int add(@RequestBody Score score) {
        return scoreService.saveScore(score);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") Long id) {
        return scoreService.removeScore(id);
    }

    @PutMapping
    public int put(@RequestBody Score score) {
        return scoreService.modify(score);
    }

    @GetMapping
    public List<Score> get(Score score) {
        return scoreService.findScoreList(score);
    }

    /**
     * 消费
     *
     * @param student 消息
     * @param channel 当消费者向RabbitMq注册时,会建立一个channel,
     *                RabbitMq通过basic.deliver方法往这个channel里投放消息,
     *                这个方法携带一个deliveryTag参数代表向该channel投放这条消息的唯一标识
     * @param tag     消息的唯一标识
     */
    @RabbitListener(queues = RabbitMqConfig.QUEUE_A)
    public void updateRelation(Student student, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        System.out.println("消息消费参数:" + student);
        try {
            if (StringUtils.isEmpty(student.getStudentCode())) {
                /**
                 * nack消息
                 * multiple=false 处理单条消息
                 * multiple=true 批量处理所有deliverTag消息tag的消息
                 * requeue=true 消息重新排队不丢弃
                 * requeue=false 将消息丢弃
                 */
                channel.basicNack(tag, false, false);
                //channel.basicReject(tag, false);
                return;
            }
            //ack消息
            channel.basicAck(tag, false);
            Score score = new Score();
            score.setStudentCode(student.getStudentCode());
            score.setId(1L);
            int flag = scoreService.modify(score);
            System.out.println("消费结果flag:" + flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.example.demo.service.crew.impl;

import com.example.demo.dao.IStudentMapperMapper;
import com.example.demo.entity.Student;
import com.example.demo.service.crew.IStudentService;
import com.example.demo.util.mq.RabbitMqConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @ClassName StudentServiceImpl
 * @Description
 * @Author zhanghaiyan
 * @Date 2019/8/6
 * @Modifier
 */
@Service
public class StudentServiceImpl implements IStudentService, RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    @Autowired
    private IStudentMapperMapper studentMapperMapper;

    private RabbitTemplate rabbitTemplate;

    /**
     * 构造方法注入
     *
     * @param rabbitTemplate
     */
    @Autowired
    public StudentServiceImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        //rabbitTemplate不是单例，不同的模版不同的回调确认
        rabbitTemplate.setConfirmCallback(this::confirm);

        //消息发送失败回调，每个rabbitTemplate只支持一个returnCallback
        rabbitTemplate.setReturnCallback(this::returnedMessage);

        rabbitTemplate.setMandatory(true);
    }

    @Override
    public int saveStudent(Student student) {
        return studentMapperMapper.insertStudent(student);
    }

    @Override
    public int removeStudent(Long studentId) {
        return studentMapperMapper.delete(studentId);
    }

    @Override
    public int modify(Student student) {
        int flag = studentMapperMapper.updateStudent(student);
        if (flag == 1) {
            CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
            student.setStudentCode("");
            System.out.println("student>>>发送消息开始:correlationData=" + correlationData);
            rabbitTemplate.convertAndSend(RabbitMqConfig.EXECHANGE_A, RabbitMqConfig.ROUTING_KEY_A, student, correlationData);
            System.out.println("student>>>发送消息成功");
        }
        return flag;
    }

    @Override
    public List<Student> findStudentList(Student student) {
        return studentMapperMapper.queryStudent(student);
    }

    @Override
    public Student findStudent(Student student) {
        return studentMapperMapper.queryStudentLimit1(student);
    }

    /**
     * 注意这个方法只是确认生产者是否将消息成功发送到broker服务器
     * 即只确认消息是否到达Exchange中
     *
     * @param correlationData
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(@Nullable CorrelationData correlationData, boolean ack, @Nullable String cause) {
        System.out.println("消息确认回调:correlationData=" + correlationData + ",cause=" + cause);
        if (ack) {
            System.out.println("消息发送成功");
        } else {
            System.out.println("消息发送失败,原因:" + cause);
        }
    }

    /**
     * 当消息从Exchange到Queue失败时才会触发该方法
     *
     * @param message    消息体
     * @param replyCode  应答码
     * @param replyText  应答文本
     * @param exchange   消息所在交换机
     * @param routingKey 消息路由key
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("消息: " + message);
        System.out.println("应答码: " + replyCode);
        System.out.println("应答文本: " + replyText);
        System.out.println("发送消息到: " + exchange + "交换机");
        System.out.println("发送消息的路由key: " + routingKey);
    }
}

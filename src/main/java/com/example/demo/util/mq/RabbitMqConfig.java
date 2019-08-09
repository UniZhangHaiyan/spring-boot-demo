package com.example.demo.util.mq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @ClassName RabbitMqConfig
 * @Description
 * @Author zhanghaiyan
 * @Date 2019/8/8
 * @Modifier
 */
@Configuration
public class RabbitMqConfig {

    /**
     * 主机
     */
    @Value("${spring.rabbitmq.host}")
    private String host;

    /**
     * 端口
     */
    @Value("${spring.rabbitmq.port}")
    private int port;

    /**
     * 用户名
     */
    @Value("${spring.rabbitmq.username}")
    private String username;

    /**
     * 密码
     */
    @Value("${spring.rabbitmq.password}")
    private String password;

    /**
     * 虚拟机
     */
    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;


    /**
     * 消息确认
     */
    @Value("${spring.rabbitmq.publisher-confirms}")
    private boolean publisherConfirms;

    /**
     * 消息失败返回
     */
    @Value("${spring.rabbitmq.publisher-returns}")
    private boolean publisherReturns;

    /**
     * 定义交换机A
     */
    public static final String EXECHANGE_A = "EXECHANGE_A";

    /**
     * 定义交换机B
     */
    public static final String EXECHANGE_B = "EXECHANGE_B";

    /**
     * 定义队列A
     */
    public static final String QUEUE_A = "QUEUE_A";

    /**
     * 定义队列B
     */
    public static final String QUEUE_B = "QUEUE_B";

    /**
     * 定义路由键A
     */
    public static final String ROUTING_KEY_A = "ROUTING_KEY_A";

    /**
     * 定义路由键B
     */
    public static final String ROUTING_KEY_B = "ROUTING_KEY_B";

    /**
     * 配置ConnectionFactory，指定连接rabbit server参数
     * 对应的xml:
     * <p>
     * <rabbit:connection-factory id="connectionFactory"
     * virtual-host="#{frameMqProps['rabbitmq.vhost']}"
     * username="#{frameMqProps['rabbitmq.username']}"
     * password="#{frameMqProps['rabbitmq.password']}"
     * host="#{frameMqProps['rabbitmq.host']}"
     * port="#{frameMqProps['rabbitmq.port']}"/>
     *
     * @return
     */
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setVirtualHost(virtualHost);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setPublisherConfirms(publisherConfirms);
        connectionFactory.setPublisherReturns(publisherReturns);
        return connectionFactory;
    }

    /**
     * 配置管理员管理rabbit
     * 对应xml:
     * <rabbit:admin id="connectAdmin" connection-factory="connectionFactory"/>
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        rabbitAdmin.setAutoStartup(true);
        return rabbitAdmin;
    }

    /**
     * json转换器，消息可以自动根据转换器转换格式，不配置时默认为java序列化，可以自行配置
     * 对应xml:
     * <bean id="messageConverter" class="org.springframework.amqp.support.converter.Jackson2JsonMessageConverter"/>
     *
     * @return
     */
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * 定义消息模版
     * 对应xml：
     * <rabbit:template id="rabbitTemplate"
     * connection-factory="connectionFactory"
     * message-converter="messageConverter"
     * exchange="#{frameMqProps['rabbitmq.exchange']}"/>
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    /**
     * 原型模式，因为一个RabbitTemplate只能有一个ConfirmCallback
     */
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }

    /**
     * 配置消费者监听的容器
     * 对应xml:
     * <bean id="rabbitListenerContainerFactory"
     * class="org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory">
     * <property name="messageConverter" ref="messageConverter"/>
     * <property name="connectionFactory" ref="connectionFactory"/>
     * <property name="concurrentConsumers" value="3"/>
     * <property name="maxConcurrentConsumers" value="10"/>
     * </bean>
     *
     * @param connectionFactory
     * @param messageConverter
     * @return
     */
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter messageConverter) {
        SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory = new SimpleRabbitListenerContainerFactory();
        rabbitListenerContainerFactory.setConnectionFactory(connectionFactory);
        rabbitListenerContainerFactory.setMessageConverter(messageConverter);
        rabbitListenerContainerFactory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return rabbitListenerContainerFactory;
    }

    /**
     * 生成直接交换机
     * 根据路由key投放消息到绑定的队列
     *
     * @return
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXECHANGE_A);
    }

    /**
     * 生成队列A
     *
     * @return
     */
    @Bean
    public Queue queue() {
        return new Queue(QUEUE_A);
    }

    /**
     * 将队列A通过路由键绑定到直接交换机上
     *
     * @param queue
     * @param directExchange
     * @return
     */
    @Bean
    public Binding binding(Queue queue, DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with(ROUTING_KEY_A);
    }
}

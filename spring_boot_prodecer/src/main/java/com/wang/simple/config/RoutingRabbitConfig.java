package com.wang.simple.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 一只永不言弃的小乌龟
 * @create 2020/11/1 2:51 下午
 */
@Configuration
public class RoutingRabbitConfig {

    public static final String ROUTE_KEY_1 = "#.orange";

    public static final String ROUTE_KEY_2 = "*.black";


    public static final String ROUT_EXCHANGE_BEAN = "rout_exchange_bean";

    public static final String ROUT_EXCHANGE_NAME = "rout_exchange";

    public static final String FIRST_QUEUE_BEAN = "first_rout_bean";

    public static final String FIRST_QUEUE_NAME = "first_rout";

    public static final String SECOND_QUEUE_BEAN = "second_rout_bean";

    public static final String SECOND_QUEUE_NAME = "second_rout";


    /**
     * 声明一个交换机,交换机类型为广播类型
     *
     * @return
     */
    @Bean(name = ROUT_EXCHANGE_BEAN)
    public Exchange simpleExchange() {
        return ExchangeBuilder.topicExchange(ROUT_EXCHANGE_NAME).durable(true).build();
    }


    /**
     * 声明第一个队列
     *
     * @return
     */
    @Bean(name = FIRST_QUEUE_BEAN)
    public Queue firstQueue() {
        return QueueBuilder.durable(FIRST_QUEUE_NAME).build();
    }

    /**
     * 声明第二个队列
     *
     * @return
     */
    @Bean(name = SECOND_QUEUE_BEAN)
    public Queue secondQueue() {
        return QueueBuilder.durable(SECOND_QUEUE_NAME).build();
    }

    /**
     * 绑定第一个队列
     *
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding bindingFirstQueue1(@Qualifier(FIRST_QUEUE_BEAN) Queue queue, @Qualifier(ROUT_EXCHANGE_BEAN) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTE_KEY_1).noargs();

    }


    /**
     * 绑定第二个队列
     *
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding bindingSecondQueue2(@Qualifier(SECOND_QUEUE_BEAN) Queue queue, @Qualifier(ROUT_EXCHANGE_BEAN) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTE_KEY_2).noargs();

    }
}

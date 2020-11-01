package com.wang.simple.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 一只永不言弃的小乌龟
 * @create 2020/11/1 10:52 上午
 */
@Configuration
public class SimpleRabbitConfig {

    public static final String ROUTE_NAME = "";

    public static final String EXCHANGE_NAME_BEAN = "exchange_simple_bean";
    public static final String EXCHANGE_NAME = "";
    public static final String QUEUE_NAME_BEAN = "queue_simple_bean";
    public static final String QUEUE_NAME = "queue_simple";


//    交换机

    /**
     * @return
     */
//    @Bean(name = EXCHANGE_NAME_BEAN)
//    public Exchange simpleExchange() {
//        return ExchangeBuilder
//    }

//    队列

    @Bean(name = QUEUE_NAME_BEAN)
    public Queue simpleQueue() {
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    /**
     * @param queue
     * @param exchange
     * @return
     */
//    @Bean
//    public Binding simpleBing(@Qualifier(QUEUE_NAME_BEAN) Queue queue, @Qualifier(EXCHANGE_NAME_BEAN) Exchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with(ROUTE_NAME).noargs();
//    }


}

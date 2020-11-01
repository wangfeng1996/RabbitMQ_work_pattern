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
public class PfRabbitConfig {

    public static final String ROUTE_NAME = "";

    public static final String PF_EXCHANGE_BEAN = "pf_exchange_bean";

    public static final String PF_EXCHANGE_NAME = "pf_exchange";

    public static final String FIRST_QUEUE_BEAN = "first_queue_bean";

    public static final String FIRST_QUEUE_NAME = "first_queue";

    public static final String SECOND_QUEUE_BEAN = "second_queue_bean";

    public static final String SECOND_QUEUE_NAME = "second_queue";


    /**
     * 声明一个交换机,交换机类型为广播类型
     *
     * @return
     */
    @Bean(name = PF_EXCHANGE_BEAN)
    public Exchange simpleExchange() {
        return ExchangeBuilder.fanoutExchange(PF_EXCHANGE_NAME).durable(true).build();
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
    public Binding bindingFirstQueue(@Qualifier(FIRST_QUEUE_BEAN) Queue queue, @Qualifier(PF_EXCHANGE_BEAN) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTE_NAME).noargs();

    }


    /**
     * 绑定第一个队列
     *
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding bindingSecondQueue(@Qualifier(SECOND_QUEUE_BEAN) Queue queue, @Qualifier(PF_EXCHANGE_BEAN) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTE_NAME).noargs();

    }

}

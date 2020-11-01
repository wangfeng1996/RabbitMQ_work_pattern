package com.wang.simple;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 一只永不言弃的小乌龟
 * @create 2020/11/1 11:28 上午
 */
@Component
public class SimpleListener {

    @RabbitListener(queues = "queue_simple")
    public void listen(String msg) {
        System.out.println("work2:" + msg);
    }

    @RabbitListener(queues = "queue_simple")
    public void listen2(String msg) {
        System.out.println("work1:" + msg);
    }


    @RabbitListener(queues = "first_queue")
    public void listen3(String msg) {
        System.out.println("first_queue:" + msg);
    }

    @RabbitListener(queues = "second_queue")
    public void listen4(String msg) {
        System.out.println("second_queue:" + msg);
    }


    @RabbitListener(queues = "second_rout")
    public void listen5(String msg) {
        System.out.println("second_rout:" + msg);
    }

    @RabbitListener(queues = "first_rout")
    public void listen6(String msg) {
        System.out.println("first_rout:" + msg);
    }

}

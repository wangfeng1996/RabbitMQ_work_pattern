package com.wang.simple;

import com.wang.ApplicationProducer;
import com.wang.simple.config.SimpleRabbitConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 一只永不言弃的小乌龟
 * @create 2020/11/1 10:50 上午
 */
@SpringBootTest(classes = ApplicationProducer.class)
@RunWith(SpringRunner.class)
public class SimpleTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void Test() throws InterruptedException {
        for (int i = 0; i <10 ; i++) {
            rabbitTemplate.convertAndSend(SimpleRabbitConfig.QUEUE_NAME, "hello world" + i);
        }
    }
}

package com.wang.rout;

import com.wang.ApplicationProducer;
import com.wang.simple.config.RoutingRabbitConfig;
import com.wang.simple.config.SimpleRabbitConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 一只永不言弃的小乌龟
 * @create 2020/11/1 4:05 下午
 */

@SpringBootTest(classes = ApplicationProducer.class)
@RunWith(SpringRunner.class)
public class RoutTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void Test() {
        rabbitTemplate.convertAndSend(RoutingRabbitConfig.ROUT_EXCHANGE_NAME,"a.b.c.orange","hello 我是路由转发的");
    }
}

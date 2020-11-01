package com.wang.pf;

import com.wang.ApplicationProducer;
import com.wang.simple.config.PfRabbitConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 一只永不言弃的小乌龟
 * @create 2020/11/1 2:50 下午
 */

@SpringBootTest(classes = ApplicationProducer.class)
@RunWith(SpringRunner.class)
public class PFTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void Test() throws InterruptedException {
        rabbitTemplate.convertAndSend(PfRabbitConfig.PF_EXCHANGE_NAME,PfRabbitConfig.ROUTE_NAME,"我是广播模式的交换机");
    }


}

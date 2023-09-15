package com.parom.rabbitmq.two.consumer;

import com.parom.rabbitmq.two.entity.DummyMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class SingleActiveConsumer {

    @RabbitListener(queues = "q.single", concurrency = "5")
    public void listenDummy(DummyMessage message) throws InterruptedException {
        log.info("Consuming {}", message);
        TimeUnit.SECONDS.sleep(1);
    }

}

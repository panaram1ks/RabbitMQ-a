package com.parom.rabbitmq.two.consumer;

import com.parom.rabbitmq.two.entity.DummyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

//@Service
public class DummyPrefetchConsumer {

    private final static Logger LOG = LoggerFactory.getLogger(DummyPrefetchConsumer.class);

    @RabbitListener(queues = "q.dummy", concurrency = "2")
    public void listenDummy(DummyMessage message) throws InterruptedException {
        LOG.info("Message is {}", message);
        TimeUnit.SECONDS.sleep(20);
    }

}

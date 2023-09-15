package com.parom.rabbitmq.two.consumer;

import com.parom.rabbitmq.two.entity.DummyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class DummyConsumer {

    private final static Logger LOG = LoggerFactory.getLogger(DummyConsumer.class);

    @RabbitListener(queues = "q.dummy")
    public void listenDummy(DummyMessage message) {
        LOG.info("Message is {}", message);
    }

}

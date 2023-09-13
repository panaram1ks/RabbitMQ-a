package com.course.rabbitmqconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

//@Service
public class FixedRateConsumer {

    public static final Logger LOG = LoggerFactory.getLogger(FixedRateConsumer.class);

    @RabbitListener(queues = "course.fixedrate", concurrency = "3-7")
    public void messaging(String message) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextLong(1000, 2000));
        LOG.info("{} : Consuming {}", Thread.currentThread().getName(), message);
    }

}

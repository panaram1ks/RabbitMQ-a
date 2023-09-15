package com.parom.rabbitmq.two.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class RabbitmqScheduler {

    private final static Logger LOG = LoggerFactory.getLogger(RabbitmqScheduler.class);

    @Autowired
    private RabbitListenerEndpointRegistry registry;

    @Scheduled(cron = "0 39 9 * * *")
    public void stopAll(){
        registry.getListenerContainers().forEach( container -> {
            LOG.info("Stopping listener container {}", container);
            container.stop();
        });
    }

    @Scheduled(cron = "0 40 9 * * *") // start container one second after midnight
    public void startAll(){
        registry.getListenerContainers().forEach( container -> {
            LOG.info("Starting listener container {}", container);
            container.start();
        });
    }

}

package com.course.rabbitmqproducer.scheduler;

import com.course.rabbitmqproducer.client.RabbitmqClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RabbitmqScheduler {

    private static final Logger LOG = LoggerFactory.getLogger(RabbitmqScheduler.class);

    @Autowired
    private RabbitmqClient client;


    @Scheduled(fixedDelay = 90000)
    public void sweepDirtyQueues() {
        try {
            var dirtyQueues = client.getAllQueues().stream()
                    .filter(q -> q.isDirty())
                    .collect(Collectors.toList());

            dirtyQueues.forEach(q -> LOG.info("Queue {} has {} unprocessed messagea", q.getName(), q.getMessages()));
        } catch (Exception e) {
            LOG.warn("Cannot sweep queue : {}", e.getMessage());
        }
    }

}

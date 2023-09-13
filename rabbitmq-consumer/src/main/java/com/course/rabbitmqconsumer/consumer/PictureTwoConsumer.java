package com.course.rabbitmqconsumer.consumer;

import com.course.rabbitmqconsumer.entity.Picture;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PictureTwoConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    private static final Logger LOG = LoggerFactory.getLogger(PictureTwoConsumer.class);

    @RabbitListener(queues = {
            "q.picture.image", "q.picture.vector", "q.picture.log", "q.picture.filter"
    })
    public void listen(Message messageAmqp) throws IOException {
        var jsonString = new String(messageAmqp.getBody());
        var picture = objectMapper.readValue(jsonString, Picture.class);
        LOG.info("Consuming picture : {} with routing key : {}", picture, messageAmqp.getMessageProperties().getReceivedRoutingKey());
    }

}

package com.course.rabbitmqconsumer.consumer;

import com.course.rabbitmqconsumer.entity.Picture;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MyPictureImageConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    private static final Logger LOG = LoggerFactory.getLogger(MyPictureImageConsumer.class);

    @RabbitListener(queues = "q.mypicture.image")
    public void listen(String message) throws IOException, IllegalAccessException {
        var picture = objectMapper.readValue(message, Picture.class);
        if (picture.getSize() > 9000) {
            throw new AmqpRejectAndDontRequeueException("Picture size too large : " + picture);
        }

        LOG.info("Picture type:{} , consumer:{}", picture.getType(), MyPictureImageConsumer.class.getSimpleName());
    }

}

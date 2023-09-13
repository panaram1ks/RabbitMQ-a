package com.course.rabbitmqconsumer.consumer;

import com.course.rabbitmqconsumer.entity.Employee;
import com.course.rabbitmqconsumer.entity.Picture;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PictureVectoreConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    private static final Logger LOG = LoggerFactory.getLogger(PictureVectoreConsumer.class);

    @RabbitListener(queues = "q.picture.vector")
    public void listen(String message) throws IOException {
        var picture = objectMapper.readValue(message, Picture.class);

        LOG.info("Picture type:{} , consumer:{}", picture.getType(), PictureVectoreConsumer.class.getSimpleName());
    }

}

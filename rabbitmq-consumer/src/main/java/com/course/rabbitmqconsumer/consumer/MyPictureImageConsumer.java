package com.course.rabbitmqconsumer.consumer;

import com.course.rabbitmqconsumer.entity.Picture;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MyPictureImageConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    private static final Logger LOG = LoggerFactory.getLogger(MyPictureImageConsumer.class);

    @RabbitListener(queues = "q.mypicture.image")
    public void listen(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException, IllegalAccessException {
        var picture = objectMapper.readValue(message, Picture.class);
        if (picture.getSize() > 9000) {
//            throw new AmqpRejectAndDontRequeueException("Picture size too large : " + picture);
            channel.basicReject(tag, false);
            return;

        }

        LOG.info("Picture type:{} , consumer:{}", picture.getType(), MyPictureImageConsumer.class.getSimpleName());
        channel.basicAck(tag, false);
    }

}

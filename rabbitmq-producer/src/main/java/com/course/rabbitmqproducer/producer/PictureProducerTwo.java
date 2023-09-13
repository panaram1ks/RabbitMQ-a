package com.course.rabbitmqproducer.producer;

import com.course.rabbitmqproducer.entity.Picture;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class PictureProducerTwo {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(Picture picture) throws IOException {
        var json = objectMapper.writeValueAsString(picture);
        var sb = new StringBuilder();

        // 1st word is picture source
        sb.append(picture.getSource());
        sb.append(".");

        // 2nd word is based on picture size
        if (picture.getSize() > 4000) {
            sb.append("large");
        } else {
            sb.append("small");
        }
        sb.append(".");

        // 3rd word is picture type
        sb.append(picture.getType());
        sb.append(".");

        rabbitTemplate.convertAndSend("x.picture2", sb.toString(), json);
    }

}

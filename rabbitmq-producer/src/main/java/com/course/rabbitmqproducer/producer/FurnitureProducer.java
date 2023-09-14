package com.course.rabbitmqproducer.producer;

import com.course.rabbitmqproducer.entity.Furniture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class FurnitureProducer {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(Furniture furniture) throws JsonProcessingException {
        var messageProperties = new MessageProperties();
        messageProperties.setHeader("color", furniture.getColor());
        messageProperties.setHeader("material", furniture.getMaterial());

        var json = objectMapper.writeValueAsString(furniture);
        var message = new Message(json.getBytes(), messageProperties);

        rabbitTemplate.send("x.promotion", "", message);
    }

}

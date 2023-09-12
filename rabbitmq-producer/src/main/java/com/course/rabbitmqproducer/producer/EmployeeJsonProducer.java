package com.course.rabbitmqproducer.producer;

import com.course.rabbitmqproducer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeJsonProducer {

    private RabbitTemplate rabbitTemplate;
    private ObjectMapper objectMapper;

    public EmployeeJsonProducer(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendMessage(Employee data) throws JsonProcessingException {
        var json = objectMapper.writeValueAsString(data);

        rabbitTemplate.convertAndSend("course.employee", json);
    }

}

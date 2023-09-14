package com.course.rabbitmqconsumer.consumer;

import com.course.rabbitmqconsumer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SpringEmployeeConsumer {

    private final static Logger LOG = LoggerFactory.getLogger(SpringEmployeeConsumer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "q.spring2.accounting.work")
    public void listenAccounting(String message) throws JsonProcessingException {
        var employee = objectMapper.readValue(message, Employee.class);
        LOG.info("On accounting, consuming {}", employee);
        if (StringUtils.isEmpty(employee.getName())) {
            throw new IllegalArgumentException("name is empty");
        }
        LOG.info("On accouninf, employee  is {}", employee);
    }

    @RabbitListener(queues = "q.spring2.marketing.work")
    public void listenMarketing(String message) throws JsonProcessingException {
        var employee = objectMapper.readValue(message, Employee.class);
        LOG.info("On marketing, consuming {}", employee);
        LOG.info("On marketign. employee  is {}", employee);
    }

}

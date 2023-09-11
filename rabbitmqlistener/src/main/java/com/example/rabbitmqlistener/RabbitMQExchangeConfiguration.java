package com.example.rabbitmqlistener;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeConfiguration {

    @Bean
    Exchange exchangeExchange() {
        return new TopicExchange("ExampleExchange");
    }

    @Bean
    Exchange exchange2ndExchange() {
        return ExchangeBuilder.directExchange("Exchange2ndExchange")
                .autoDelete()
                .internal()
                .build();
    }

    @Bean
    Exchange newExchange(){
        return ExchangeBuilder.topicExchange("TopicTestExchange")
                .autoDelete()
                .durable(true)
                .internal()
                .build();
    }

}

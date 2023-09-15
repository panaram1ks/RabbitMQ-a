package com.parom.rabbitmq.two.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqSchemaConfig {

//    @Bean
//    public FanoutExchange fanoutExchange() {
//        return new FanoutExchange("x.another-dummy", true, false);
//    }
//
//    @Bean
//    public DirectExchange directExchange() {
//        return new DirectExchange("test");
//    }
//
//    @Bean
//    public Queue queueAnotherDummy() {
//        return new Queue("q.another-dummy");
//    }
//
//    @Bean
//    public Binding bindingAnotherDummy() {
//        // first variant to create Binding
////        return new Binding("q.another-dummy", Binding.DestinationType.QUEUE, "x.another-dummy", "", null);
//        return BindingBuilder.bind(queueAnotherDummy()).to(fanoutExchange());
//    }



    @Bean // second way create all in one
    public Declarables rabbitmqSchema() {
        return new Declarables(
                new FanoutExchange("x.another-dummy", true, false),
                new Queue("q.another-dummy"),
                new Binding("q.another-dummy", Binding.DestinationType.QUEUE, "x.another-dummy", "", null)
        );
    }
}

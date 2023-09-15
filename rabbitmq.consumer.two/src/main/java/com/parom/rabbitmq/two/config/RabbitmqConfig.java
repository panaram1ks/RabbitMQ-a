package com.parom.rabbitmq.two.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return JsonMapper.builder().findAndAddModules().build();
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(@Autowired ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }


//    @Bean(name = "rabbitListenerContainerFactory")
//    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(
//            SimpleRabbitListenerContainerFactoryConfigurer configurer, ConnectionFactory connectionFactory) {
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        configurer.configure(factory, connectionFactory);
//
//        factory.setAfterReceivePostProcessors(new MessagePostProcessor() {
//
//            @Override
//            public Message postProcessMessage(Message message) throws AmqpException {
//                var type = message.getMessageProperties().getHeaders().get("type").toString();
//                String typeId = null;
//
//                if (StringUtils.equalsIgnoreCase(type, "invoice.paid")) {
//                    typeId = InvoicePaidMessage.class.getName();
//                } else if (StringUtils.equalsIgnoreCase(type, "invoice.created")) {
//                    typeId = InvoiceCreatedMessage.class.getName();
//                }
//
//                Optional.ofNullable(typeId).ifPresent(t -> message.getMessageProperties().setHeader("__TypeId__", t));
//
//                return message;
//            }
//
//        });
//
//        return factory;
//    }
//
//    @Bean
//    Jackson2JsonMessageConverter jsonMessageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
//
//    @Bean
//    RabbitTemplate rabbitTemplate(Jackson2JsonMessageConverter converter, ConnectionFactory connectionFactory) {
//        RabbitTemplate template = new RabbitTemplate(connectionFactory);
//        template.setMessageConverter(new Jackson2JsonMessageConverter());
//        return template;
//    }

}

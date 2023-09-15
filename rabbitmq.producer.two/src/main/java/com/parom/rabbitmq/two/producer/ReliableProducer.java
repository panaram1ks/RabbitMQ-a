package com.parom.rabbitmq.two.producer;

import com.parom.rabbitmq.two.entity.DummyMessage;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
@Value
public class ReliableProducer {

    RabbitTemplate rabbitTemplate;

    @PostConstruct
    private void registerCallback() {
        rabbitTemplate.setConfirmCallback((correlation, ack, reason) -> {
            if (correlation == null) {
                return;
            }
            if (ack) {
                log.warn("Message with correlation {} published", correlation.getId());
            } else {
                log.warn("Invalid exchange for message with correlation {} published", correlation.getId());
            }

        });

        rabbitTemplate.setReturnsCallback(returned -> {
            log.info("return callback");
            if (returned.getReplyText() != null && returned.getReplyText().equalsIgnoreCase("NO_ROUTE")) {
                var id = returned.getMessage().getMessageProperties().getHeader("spring_returned_message_correlation").toString();
                log.warn("Invalid routing key for message {}", id);
            }
        });
    }

    public void sendDummyWithInvalidRoutingKey(DummyMessage message) {
        var correlationData = new CorrelationData(Integer.toString(message.getPublishOrder()));
        rabbitTemplate.convertAndSend("x.dummy2", "invalid-routing-key", message, correlationData);
    }
    public void sendDummyWithInvalidExchange(DummyMessage message) {
        var correlationData = new CorrelationData(Integer.toString(message.getPublishOrder()));
        rabbitTemplate.convertAndSend("x.non-exist-exchange", "", message, correlationData);
    }

}

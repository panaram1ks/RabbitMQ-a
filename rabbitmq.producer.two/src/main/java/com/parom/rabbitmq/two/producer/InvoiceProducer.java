package com.parom.rabbitmq.two.producer;

import com.parom.rabbitmq.two.entity.InvoiceCancelledMessage;
import com.parom.rabbitmq.two.entity.InvoiceCreatedMessage;
import com.parom.rabbitmq.two.entity.InvoicePaidMessage;
import lombok.Value;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Value
@Service
public class InvoiceProducer {

    private final static String EXCHANGE = "x.invoice";

    RabbitTemplate rabbitTemplate;

    public void sendInvoiceCreated(InvoiceCreatedMessage message) {
        rabbitTemplate.convertAndSend(EXCHANGE, message.getInvoiceNumber(), message);
    }

    public void sendInvoicePaid(InvoicePaidMessage message) {
        rabbitTemplate.convertAndSend(EXCHANGE, message.getInvoiceNumber(), message);
    }

    public void sendInvoiceCancelled(InvoiceCancelledMessage message) {
        rabbitTemplate.convertAndSend(EXCHANGE, message.getInvoiceNumber(), message);
    }


}

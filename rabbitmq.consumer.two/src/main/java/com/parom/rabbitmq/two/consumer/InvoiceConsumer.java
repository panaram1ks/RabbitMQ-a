package com.parom.rabbitmq.two.consumer;

import com.parom.rabbitmq.two.entity.InvoiceCreatedMessage;
import com.parom.rabbitmq.two.entity.InvoicePaidMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RabbitListener(queues = "q.invoice")
public class InvoiceConsumer {

    @RabbitHandler
    public void handleInvoiceCreated(InvoiceCreatedMessage message) {
        log.info("Invoice created : {}", message);
    }

    @RabbitHandler
    public void handleInvoicePaid(InvoicePaidMessage message) {
        log.info("Invoice paid : {}", message);
    }

    @RabbitHandler(isDefault = true)
    public void handleDefault(Object message) {
        log.info("Handling default : {}", message);
    }
}

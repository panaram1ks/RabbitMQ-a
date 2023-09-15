package com.parom.rabbitmq.two;

import com.parom.rabbitmq.two.entity.InvoiceCancelledMessage;
import com.parom.rabbitmq.two.entity.InvoiceCreatedMessage;
import com.parom.rabbitmq.two.entity.InvoicePaidMessage;
import com.parom.rabbitmq.two.producer.InvoiceProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class Application implements CommandLineRunner {

    private final InvoiceProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 200; i++) {
            var invoiceNumber = "INV-" + (i % 60);
            var invoice = new InvoiceCreatedMessage(ThreadLocalRandom.current().nextInt(200), LocalDate.now(), "USD", invoiceNumber);
            producer.sendInvoiceCreated(invoice);
        }
    }


//    @Override
//    public void run(String... args) throws Exception {
//
//        var randomInvoiceNumber = "INV-" + ThreadLocalRandom.current().nextInt(100, 200);
//        var invoiceCreateMessage = new InvoiceCreatedMessage(152.26, LocalDate.now().minusDays(2), "USD", randomInvoiceNumber);
//        producer.sendInvoiceCreated(invoiceCreateMessage);
//
//        randomInvoiceNumber = "INV-" + ThreadLocalRandom.current().nextInt(200, 300);
//        var randomPaymentNumber = "PAY-" + ThreadLocalRandom.current().nextInt(800, 1000);
//        var invoicePaidMessage = new InvoicePaidMessage(randomInvoiceNumber, LocalDate.now(), randomPaymentNumber);
//        producer.sendInvoicePaid(invoicePaidMessage);
//
//        randomInvoiceNumber = "INV-" + ThreadLocalRandom.current().nextInt(300, 400);
//        var invoiceCancelledMessage = new InvoiceCancelledMessage(LocalDate.now(), randomInvoiceNumber, "Just a test");
//        producer.sendInvoiceCancelled(invoiceCancelledMessage);
//
//        log.info("Done");
//    }
}

package com.parom.rabbitmq.two;

import com.parom.rabbitmq.two.entity.InvoiceCreatedMessage;
import com.parom.rabbitmq.two.entity.InvoicePaidMessage;
import com.parom.rabbitmq.two.producer.InvoiceProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@RequiredArgsConstructor
public class Application implements CommandLineRunner {

    private final InvoiceProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        var randomInvoiceNumber = "INV-" + ThreadLocalRandom.current().nextInt(100, 200);
        var invoiceCreateMessage = new InvoiceCreatedMessage(152.26, LocalDate.now().minusDays(2), "USD", randomInvoiceNumber);
        producer.sendInvoiceCreated(invoiceCreateMessage);

        randomInvoiceNumber = "INV-" + ThreadLocalRandom.current().nextInt(200, 300);
        var randomPaymentNumber = "PAY-" + ThreadLocalRandom.current().nextInt(800, 1000);
        var invoicePaidMessage = new InvoicePaidMessage(randomInvoiceNumber, LocalDate.now(), randomPaymentNumber);
        producer.sendInvoicePaid(invoicePaidMessage);

        System.out.println("Done");
    }
}

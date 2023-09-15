package com.parom.rabbitmq.two;

import com.parom.rabbitmq.two.entity.DummyMessage;
import com.parom.rabbitmq.two.producer.ReliableProducer;
import com.parom.rabbitmq.two.producer.SingleActiveProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class Application implements CommandLineRunner {

    private final ReliableProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var dummyMessage1 = new DummyMessage("Invalid test", 10);
        var dummyMessage2 = new DummyMessage("Invalid test", 20);

        producer.sendDummyWithInvalidRoutingKey(dummyMessage1);
        producer.sendDummyWithInvalidExchange(dummyMessage2);
        log.info("Done");
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

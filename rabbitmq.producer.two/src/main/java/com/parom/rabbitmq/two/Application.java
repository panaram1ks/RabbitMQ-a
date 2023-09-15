package com.parom.rabbitmq.two;

import com.parom.rabbitmq.two.entity.DummyMessage;
import com.parom.rabbitmq.two.producer.DummyProducer;
import com.parom.rabbitmq.two.producer.MultiplePrefetchProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@RequiredArgsConstructor
public class Application implements CommandLineRunner {

    private final MultiplePrefetchProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        producer.simulateSchedule();
        producer.simulateTransaction();
        System.out.println("Done");
    }
}

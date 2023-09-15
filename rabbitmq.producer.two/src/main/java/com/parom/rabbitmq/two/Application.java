package com.parom.rabbitmq.two;

import com.parom.rabbitmq.two.entity.DummyMessage;
import com.parom.rabbitmq.two.producer.DummyProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalTime;

@SpringBootApplication
@RequiredArgsConstructor
public class Application implements CommandLineRunner {

    private final DummyProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var dummyMessage = new DummyMessage("Now is " + LocalTime.now(), 1);
        producer.sendDummy(dummyMessage);
    }
}

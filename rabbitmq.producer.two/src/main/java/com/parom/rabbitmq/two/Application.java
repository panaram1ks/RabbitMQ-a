package com.parom.rabbitmq.two;

import com.parom.rabbitmq.two.entity.DummyMessage;
import com.parom.rabbitmq.two.producer.DummyProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@RequiredArgsConstructor
public class Application implements CommandLineRunner {

    private final DummyProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 500; i++){
            var dummyMessage = new DummyMessage("Now is " + LocalTime.now(), i);
            producer.sendDummy(dummyMessage);
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("All sent");

    }
}

package com.course.rabbitmqproducer;

import com.course.rabbitmqproducer.entity.Employee;
import com.course.rabbitmqproducer.entity.Picture;
import com.course.rabbitmqproducer.producer.HumanResourceProducer;
import com.course.rabbitmqproducer.producer.PictureProducer;
import com.course.rabbitmqproducer.producer.PictureProducerTwo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@EnableScheduling
@RequiredArgsConstructor
public class RabbitmqProducerApplication implements CommandLineRunner {

    private final PictureProducerTwo producer;

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProducerApplication.class, args);
    }

    // valid sources
    private final List<String> SOURCES = List.of("mobile", "web");

    // valid types
    private final List<String> TYPES = List.of("jpg", "png", "svg");

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 20; i++) {
            var picture = Picture.builder()
                    .name("Picture " + i)
                    .size(ThreadLocalRandom.current().nextLong(1, 10000))
                    .source(SOURCES.get(i % SOURCES.size()))
                    .type(TYPES.get(i % TYPES.size()))
                    .build();

            producer.sendMessage(picture);
        }

    }

//    @Override
//    public void run(String... args) throws Exception {
//        for (int i = 0; i < 9; i++) {
//            Picture picture;
//            if (i % 2 == 0) {
//                picture = Picture.builder().type("png").name("name" + 1).source("link" + i).size(Math.round(Math.random() * 100)).build();
//            } else if (i % 3 == 0) {
//                picture = Picture.builder().type("svg").name("name" + 1).source("link" + i).size(Math.round(Math.random() * 100)).build();
//            } else {
//                picture = Picture.builder().type("jpg").name("name" + 1).source("link" + i).size(Math.round(Math.random() * 100)).build();
//            }
//            producer.sendMessage(picture);
//        }
//    }
}

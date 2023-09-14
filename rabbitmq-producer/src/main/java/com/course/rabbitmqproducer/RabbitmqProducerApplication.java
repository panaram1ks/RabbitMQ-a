package com.course.rabbitmqproducer;

import com.course.rabbitmqproducer.entity.Employee;
import com.course.rabbitmqproducer.entity.Picture;
import com.course.rabbitmqproducer.producer.MyPictureProducer;
import com.course.rabbitmqproducer.producer.RetryEmployeeProducer;
import com.course.rabbitmqproducer.producer.RetryPictureProducer;
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

//    private final RetryEmployeeProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProducerApplication.class, args);
    }

//    private final List<String> COLORS = List.of("white", "red", "green");
//    private final List<String> MATERIALS = List.of("wood", "plastic", "steel");
//
//    private final List<String> SOURCES = List.of("mobile", "web");
//    private final List<String> TYPES = List.of("jpg", "png", "svg");

    @Override
    public void run(String... args) throws Exception {

    }

//    @Override
//    public void run(String... args) throws Exception {
//        for (int i = 0; i < 10; i++) {
//            var employee = new Employee("emp " + i, null, LocalDate.now());
//
//            producer.sendMessage(employee);
//        }
//    }

//    @Override
//    public void run(String... args) throws Exception {
//        for (int i = 0; i < 20; i++) {
//            var furniture = new Furniture();
//            furniture.setColor(COLORS.get(i % COLORS.size()));
//            furniture.setName("Furniture " + i);
//            furniture.setMaterial(MATERIALS.get(i % MATERIALS.size()));
//            furniture.setPrice(i);
//
//            producer.sendMessage(furniture);
//        }
//
//    }

//    @Override
//    public void run(String... args) throws Exception {
//        for (int i = 0; i < 10; i++) {
//            Picture picture = new Picture();
//            picture.setName("Picture " + i);
//            picture.setSize(ThreadLocalRandom.current().nextLong(9500, 10000));
//            picture.setSource(SOURCES.get(i % SOURCES.size()));
//            picture.setType(TYPES.get(i % TYPES.size()));
//
//            producer.sendMessage(picture);
//        }
//    }
}

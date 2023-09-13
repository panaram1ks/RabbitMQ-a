package com.course.rabbitmqproducer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Furniture {

    private String color;
    private String material;
    private String name;
    private int price;
}

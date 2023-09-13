package com.course.rabbitmqconsumer.entity;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Picture {

    private String name;
    private String type;
    private String source;
    private long size;

}

package com.parom.rabbitmq.two.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DummyMessage {

    private String content;
    private int publishOrder;

}

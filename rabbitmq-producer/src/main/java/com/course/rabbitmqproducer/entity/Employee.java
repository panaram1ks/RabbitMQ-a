package com.course.rabbitmqproducer.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Employee {

    private String employeeId;
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;


}

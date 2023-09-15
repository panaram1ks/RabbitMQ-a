package com.parom.rabbitmq.two.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceCreatedMessage {

    private double amount;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;
    private String currency;
    private String invoiceNumber;
}

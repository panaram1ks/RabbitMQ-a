package com.parom.rabbitmq.two.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceCancelledMessage {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate cancelDate;
    private String invoiceNumber;
    private String reason;


}

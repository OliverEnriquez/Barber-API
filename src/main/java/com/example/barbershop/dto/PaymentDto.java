package com.example.barbershop.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentDto {

    private Long paymentId;
    private Long appointmentId;
    @JsonFormat(pattern = "yyyy-MM-d HH:mm")
    private LocalDateTime paymentDateTime;
    private Double amount;
    private String paymentMethod;
}

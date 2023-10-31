package com.example.barbershop.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDto {
    @JsonFormat(pattern = "yyyy-MM-d HH:mm")
    private LocalDateTime date;
    private Long barberId;
    private Long customerId;
    private Long serviceId;
}

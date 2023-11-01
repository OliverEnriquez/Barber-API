package com.example.barbershop.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewDto {


    private Long reviewId;
    private String comment;
    private Integer rating;
    private Long barberId;
    private Long customerId;
    private Long serviceId;
}

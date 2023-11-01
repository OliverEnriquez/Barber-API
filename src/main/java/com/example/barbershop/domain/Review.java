package com.example.barbershop.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "barber_id")
    private Barber barber;
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    private Integer rating;

    private String comment;

    private LocalDateTime reviewDateTime;

}

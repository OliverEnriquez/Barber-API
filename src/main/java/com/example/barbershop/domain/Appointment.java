package com.example.barbershop.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "barber_id")
    private Barber barber;
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;
    @JsonFormat(pattern = "yyyy-MM-d HH:mm")
    private LocalDateTime appointmentDateTime;
    private String status;


}

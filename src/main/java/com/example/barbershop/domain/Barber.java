package com.example.barbershop.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Barber {
    @Id
    @Column(name = "BARBER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long barberId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;

}

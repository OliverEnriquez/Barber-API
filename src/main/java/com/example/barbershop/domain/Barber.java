package com.example.barbershop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Barber {
    @Id
    @Column(name = "BARBER_ID")
    private Long barberId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;

}

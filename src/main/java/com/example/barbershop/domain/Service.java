package com.example.barbershop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Service {
    @Id
    private Long serviceId;

    private String serviceName;
    private String description;
    private Double price;
}

package com.example.barbershop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PAYMENT_ISTORY")
@Data
public class paymentHistory {
    @Id
    private Long paymentHistoryId;


}

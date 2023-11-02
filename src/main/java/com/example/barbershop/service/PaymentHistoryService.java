package com.example.barbershop.service;

import com.example.barbershop.domain.PaymentHistory;
import com.example.barbershop.dto.PaymentDto;

import java.util.List;
import java.util.Optional;

public interface PaymentHistoryService {

    void createPayment(PaymentDto dto);

    void updatePayment(PaymentDto dto);

    Optional<PaymentHistory> getPaymentById(Long id);

    List<PaymentHistory> getAllPayments();

    void deletePayment(Long id);
}

package com.example.barbershop.controller;

import com.example.barbershop.domain.PaymentHistory;
import com.example.barbershop.dto.PaymentDto;
import com.example.barbershop.service.PaymentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PaymentController {

    @Autowired
    PaymentHistoryService paymentHistoryService;

    @GetMapping(value = "/payments")
    public List<PaymentHistory> getPayments() {
        return paymentHistoryService.getAllPayments();
    }

    @GetMapping(value = "/payment/{id}")
    public Optional<PaymentHistory> getPaymentById(@PathVariable Long id) {
        return paymentHistoryService.getPaymentById(id);
    }

    @PostMapping(value = "/payment")
    public void createPayment(@RequestBody PaymentDto dto) {
        paymentHistoryService.createPayment(dto);
    }

    @PutMapping(value = "/payment")
    public void updatePayment(@RequestBody PaymentDto dto) {
        paymentHistoryService.updatePayment(dto);
    }

    @DeleteMapping(value = "/payment/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentHistoryService.deletePayment(id);
    }

}

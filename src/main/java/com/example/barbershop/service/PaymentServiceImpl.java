package com.example.barbershop.service;

import com.example.barbershop.domain.Appointment;
import com.example.barbershop.domain.PaymentHistory;
import com.example.barbershop.dto.PaymentDto;
import com.example.barbershop.repository.PaymentHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentHistoryService{

    @Autowired
    PaymentHistoryRepository paymentHistoryRepository;

    @Autowired
    AppointmentService appointmentService;
    @Override
    public void createPayment(PaymentDto dto) {
        paymentHistoryRepository.save(buildPayment(dto));
    }

    @Override
    public void updatePayment(PaymentDto dto) {
        paymentHistoryRepository.save(buildPayment(dto));
    }

    @Override
    public Optional<PaymentHistory> getPaymentById(Long id) {
        return paymentHistoryRepository.findById(id);
    }

    @Override
    public List<PaymentHistory> getAllPayments() {
        return paymentHistoryRepository.findAll();
    }

    @Override
    public void deletePayment(Long id) {
        paymentHistoryRepository.deleteById(id);
    }

    private PaymentHistory buildPayment(PaymentDto dto) {
        PaymentHistory paymentHistory = new PaymentHistory();
        try {
            if (dto.getPaymentId()!=null) {
                paymentHistory.setPaymentId(dto.getPaymentId());
            }
            Optional<Appointment> appointment = appointmentService.getAppointmentId(dto.getAppointmentId());
            if (appointment.isPresent()) {
                paymentHistory.setAppointment(appointment.get());
            }

            paymentHistory.setPaymentDateTime(dto.getPaymentDateTime());
            paymentHistory.setAmount(dto.getAmount());
            paymentHistory.setPaymentMethod(dto.getPaymentMethod());
            paymentHistoryRepository.save(paymentHistory);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return paymentHistory;
    }
}

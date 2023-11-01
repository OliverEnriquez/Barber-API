package com.example.barbershop.service;

import com.example.barbershop.domain.Appointment;
import com.example.barbershop.dto.AppointmentDto;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    void addAppointment(AppointmentDto dto);

    List<Appointment> findAll();

    Optional<Appointment> appointment(Long id);

    void updateAppointment(AppointmentDto dto);

    void deleteAppointment(Long id);
}

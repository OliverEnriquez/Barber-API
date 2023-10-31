package com.example.barbershop.service;

import com.example.barbershop.domain.Appointment;
import java.util.List;
public interface AppointmentService {

    void addAppointment(Appointment appointment);

    List<Appointment> findAll();
}

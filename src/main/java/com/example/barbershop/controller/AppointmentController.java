package com.example.barbershop.controller;

import com.example.barbershop.domain.Appointment;
import com.example.barbershop.domain.Barber;
import com.example.barbershop.domain.Customer;
import com.example.barbershop.domain.Service;
import com.example.barbershop.dto.AppointmentDto;
import com.example.barbershop.service.AppointmentService;
import com.example.barbershop.service.BarberService;
import com.example.barbershop.service.CustomerService;
import com.example.barbershop.service.ServiceBarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.List;
@RestController
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;



    @GetMapping(value = "/appointments")
    public List<Appointment> findAllAppointments() {
        return appointmentService.findAll();
    }


    @PostMapping(value = "/appointment")
    public void saveAppointment(@RequestBody AppointmentDto dto) {
        appointmentService.addAppointment(dto);
    }

    @PutMapping(value = "/appointment")
    public void updateAppointment(@RequestBody AppointmentDto dto) {
        appointmentService.updateAppointment(dto);
    }

    @DeleteMapping(value = "/appointment/{id}")
    public void deleteAppointment(@PathVariable("id") Long id) {
        appointmentService.deleteAppointment(id);
    }
}

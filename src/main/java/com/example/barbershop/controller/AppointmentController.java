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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.List;
@RestController
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    BarberService barberService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ServiceBarberService serviceBarberService;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @GetMapping(value = "/appointments")
    public List<Appointment> findAllAppointments() {
        return appointmentService.findAll();
    }


    @PostMapping(value = "/appointment")
    public void saveAppointment(@RequestBody AppointmentDto dto) {
        Optional<Customer> customer = customerService.findCustomerById(dto.getCustomerId());
        Optional<Barber> barber = barberService.findBarberById(dto.getBarberId());
        Optional<Service> service = serviceBarberService.findServiceById(dto.getServiceId());
        Appointment appointment = new Appointment();
        appointment.setAppointmentDateTime(dto.getDate());
        appointment.setStatus("Programado");


        appointment.setBarber(barber.get());
        appointment.setCustomer(customer.get());
        appointment.setService(service.get());

        appointmentService.addAppointment(appointment);


    }
}

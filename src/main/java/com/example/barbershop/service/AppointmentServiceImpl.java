package com.example.barbershop.service;

import com.example.barbershop.domain.Appointment;
import com.example.barbershop.domain.Barber;
import com.example.barbershop.domain.Customer;
import com.example.barbershop.dto.AppointmentDto;
import com.example.barbershop.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    BarberService barberService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ServiceBarberService serviceBarberService;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Override
    public void addAppointment(AppointmentDto dto) {
        appointmentRepository.save(buildAppointment(dto));
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Optional<Appointment> getAppointmentId(Long id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public void updateAppointment(AppointmentDto dto) {
        appointmentRepository.save(buildAppointment(dto));
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    private Appointment buildAppointment(AppointmentDto dto) {
        Optional<Customer> customer = customerService.findCustomerById(dto.getCustomerId());
        Optional<Barber> barber = barberService.findBarberById(dto.getBarberId());
        Optional<com.example.barbershop.domain.Service> service = serviceBarberService.findServiceById(dto.getServiceId());
        Appointment appointment = new Appointment();
        if(dto.getAppointmentId()!=null) {
            appointment.setAppointmentId(dto.getAppointmentId());
        }
        appointment.setAppointmentDateTime(dto.getDate());
        appointment.setStatus("Programado");

        if(barber.isPresent() && customer.isPresent() && service.isPresent()) {
            appointment.setBarber(barber.get());
            appointment.setCustomer(customer.get());
            appointment.setService(service.get());
        }

        return appointment;
    }
}

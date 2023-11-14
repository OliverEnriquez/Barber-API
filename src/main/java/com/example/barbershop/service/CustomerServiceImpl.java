package com.example.barbershop.service;

import com.example.barbershop.domain.Appointment;
import com.example.barbershop.domain.Customer;
import com.example.barbershop.repository.AppointmentRepository;
import com.example.barbershop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AppointmentRepository appointmentRepository;


    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        List<Appointment> appointments = appointmentRepository.findAppointmentsByCustomer_CustomerId(id);
        appointmentRepository.deleteAll(appointments);
        customerRepository.deleteById(id);
    }
}

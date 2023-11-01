package com.example.barbershop.service;

import com.example.barbershop.domain.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> findAllCustomers();
    Optional<Customer> findCustomerById(Long id);

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    void deleteCustomer(Long id);
}

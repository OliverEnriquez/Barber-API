package com.example.barbershop.controller;

import com.example.barbershop.domain.Customer;
import com.example.barbershop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@CrossOrigin
public class CustomerController {

    private static final Logger logger = Logger.getLogger(CustomerController.class.getName());


    @Autowired
    CustomerService customerService;


    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> findAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try {
            customers = customerService.findAllCustomers();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return (ResponseEntity<List<Customer>>) ResponseEntity.notFound();
        }
        return ResponseEntity.ok(customers);
    }

    @GetMapping(value = "/customer/{id}")
    public ResponseEntity<Optional<Customer>> findCustomerById(@PathVariable("id") Long id) {
        Optional<Customer> customer = Optional.of(new Customer());
        try {
            customer = customerService.findCustomerById(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return (ResponseEntity<Optional<Customer>>) ResponseEntity.notFound();
        }
        return ResponseEntity.ok(customer);
    }

    @PostMapping(value = "/customer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping(value = "/customer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}

package com.example.barbershop.controller;

import com.example.barbershop.domain.Customer;
import com.example.barbershop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
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
}

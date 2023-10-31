package com.example.barbershop.controller;

import com.example.barbershop.domain.Service;
import com.example.barbershop.service.ServiceBarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class ServiceController {

    @Autowired
    ServiceBarberService serviceBarberService;

    @GetMapping(value = "/services")
    public ResponseEntity<List<Service>> findAllServices() {
        List<Service> services = new ArrayList<>();
        try {
            services = serviceBarberService.findAllService();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return (ResponseEntity<List<Service>>) ResponseEntity.notFound();
        }

        return ResponseEntity.ok(services);

    }
}

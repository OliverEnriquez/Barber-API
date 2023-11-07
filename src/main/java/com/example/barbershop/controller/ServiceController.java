package com.example.barbershop.controller;

import com.example.barbershop.domain.Service;
import com.example.barbershop.service.ServiceBarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
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

    @GetMapping(value = "/service/{id}")
    public ResponseEntity<Optional<Service>> findAllServices(@PathVariable("id") Long id) {
        Optional<Service> service;
        try {
            service = serviceBarberService.findServiceById(id);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return (ResponseEntity<Optional<Service>>) ResponseEntity.notFound();
        }

        return ResponseEntity.ok(service);

    }

    @PostMapping(value = "/service")
    public void createService(@RequestBody Service service) {
        serviceBarberService.createService(service);
    }

    @PutMapping(value = "/service")
    public void updateService(@RequestBody Service service) {
        serviceBarberService.updateService(service);
    }

    @DeleteMapping(value = "/service/{id}")
    public void deleteService(@PathVariable("id") Long id) {
        serviceBarberService.deleteService(id);
    }
}

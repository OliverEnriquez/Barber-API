package com.example.barbershop.controller;

import com.example.barbershop.domain.Barber;
import com.example.barbershop.service.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BarberController {

    @Autowired
    BarberService barberService;

    @GetMapping()
    public String hello() {
        return "Hello barber";
    }

    @GetMapping(value = "/barbers")
    public List<Barber> findAllBarbers() {
        return barberService.findAllBarbers();
    }
}

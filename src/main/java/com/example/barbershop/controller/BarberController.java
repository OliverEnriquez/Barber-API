package com.example.barbershop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BarberController {

    @GetMapping()
    public String hello() {
        return "Hello barber";
    }
}

package com.example.barbershop.controller;

import com.example.barbershop.domain.Barber;
import com.example.barbershop.service.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
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

    @GetMapping(value = "/barber/{id}")
    public Optional<Barber> findBarberById(@PathVariable("id") Long id) {
        Optional<Barber> barber = barberService.findBarberById(id);
        return barber;
    }

    @PostMapping(value = "/barber")
    public Barber createBarber(@RequestBody Barber barber) {
        return barberService.createBarber(barber);
    }





    @PutMapping(value = "/barber")
    public Barber updateBarber(@RequestBody Barber barber) {
        return barberService.updateBarber(barber);
    }

    @DeleteMapping("/barber/{id}")
    public void deleteBarber(@PathVariable Long id) {
        barberService.deleteBarber(id);
    }
}

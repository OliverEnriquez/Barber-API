package com.example.barbershop.service;

import com.example.barbershop.domain.Barber;

import java.util.List;
import java.util.Optional;

public interface BarberService {

    List<Barber> findAllBarbers();
    Optional<Barber> findBarberById(Long id);

    Barber createBarber(Barber barber);


    Barber updateBarber(Barber barber);

    void deleteBarber(Long id);
}

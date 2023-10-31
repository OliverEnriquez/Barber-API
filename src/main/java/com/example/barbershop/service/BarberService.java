package com.example.barbershop.service;

import com.example.barbershop.domain.Barber;

import java.util.List;

public interface BarberService {

    List<Barber> findAllBarbers();
}

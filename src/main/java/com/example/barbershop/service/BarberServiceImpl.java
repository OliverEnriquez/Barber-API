package com.example.barbershop.service;

import com.example.barbershop.domain.Barber;
import com.example.barbershop.repository.BarberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarberServiceImpl implements BarberService {

    @Autowired
    BarberRepository barberRepository;
    @Override
    public List<Barber> findAllBarbers() {
        return barberRepository.findAll();
    }
}

package com.example.barbershop.service;

import com.example.barbershop.domain.Barber;
import com.example.barbershop.repository.BarberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarberServiceImpl implements BarberService {

    @Autowired
    BarberRepository barberRepository;
    @Override
    public List<Barber> findAllBarbers() {
        return barberRepository.findAll();
    }

    @Override
    public Optional<Barber> findBarberById(Long id) {
        return barberRepository.findById(id);
    }

    @Override
    public Barber createBarber(Barber barber) {
        return barberRepository.save(barber);
    }




    @Override
    public Barber updateBarber(Barber barber) {
        return barberRepository.save(barber);
    }

    @Override
    public void deleteBarber(Long id) {
        barberRepository.deleteById(id);
    }
}

package com.example.barbershop.service;

import com.example.barbershop.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceBarberServiceImpl implements ServiceBarberService{

    @Autowired
    ServiceRepository serviceRepository;
    @Override
    public List<com.example.barbershop.domain.Service> findAllService() {
        return serviceRepository.findAll();
    }

    @Override
    public Optional<com.example.barbershop.domain.Service> findServiceById(Long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public void createService(com.example.barbershop.domain.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void updateService(com.example.barbershop.domain.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}

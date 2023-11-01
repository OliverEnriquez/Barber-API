package com.example.barbershop.service;

import com.example.barbershop.domain.Service;
import java.util.List;
import java.util.Optional;

public interface ServiceBarberService {
    List<Service> findAllService();

    Optional<Service> findServiceById(Long id);

    void createService(Service service);

    void updateService(Service service);

    void deleteService(Long id);
}

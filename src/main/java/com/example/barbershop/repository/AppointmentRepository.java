package com.example.barbershop.repository;

import com.example.barbershop.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAppointmentsByCustomer_CustomerId(Long id);
}

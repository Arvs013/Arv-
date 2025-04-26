package com.blood_donation_backend.Repository;

import com.blood_donation_backend.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}

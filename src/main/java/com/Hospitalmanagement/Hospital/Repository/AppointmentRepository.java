package com.Hospitalmanagement.Hospital.Repository;

import com.Hospitalmanagement.Hospital.modles.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}

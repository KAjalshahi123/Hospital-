package com.Hospitalmanagement.Hospital.Repository;

import com.Hospitalmanagement.Hospital.modles.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor , Long> {
}

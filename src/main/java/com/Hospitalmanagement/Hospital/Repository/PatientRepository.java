package com.Hospitalmanagement.Hospital.Repository;

import com.Hospitalmanagement.Hospital.modles.Patients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patients,Long > {
}

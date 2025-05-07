package com.Hospitalmanagement.Hospital.Service;

import com.Hospitalmanagement.Hospital.Repository.PatientRepository;
import com.Hospitalmanagement.Hospital.modles.Patients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {


    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);
    @Autowired
    private PatientRepository patientRepository;
    public List<Patients> getAll() {
        try {
            System.out.println("Into the service layer");
            return patientRepository.findAll();
        } catch (Exception e) {
            logger.error("An error occurred while fetching all bills: {}", e.getMessage(), e);
            return null;
        }
    }

    public Patients getPatientByid(Long id) {
        try {
           // return null; // Replace with actual logic
            Optional<Patients>patients = patientRepository.findById(id);
            return patients.orElse(null);
        } catch (Exception e) {
            logger.error("Error message: {}", e.getMessage(), e);
            return null;
        }
    }

    public Patients createPatient(Patients patients) {
        try {
           // return null; // Replace with actual logic
            patientRepository.save(patients);
            return patients;
        } catch (Exception e) {
            logger.error("Error message: {}", e.getMessage(), e);
            return null;
        }
    }

    public void DeletePatientByid(Long id) {
        try {
            // Add logic here
            patientRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Error message: {}", e.getMessage(), e);
        }
    }

    public Patients updatePatientByid(Long id, Patients updatePatient) {
        try {
            Optional<Patients> existingPatient = patientRepository.findById(id);
            if (existingPatient.isPresent()) {
                Patients p = existingPatient.get();

                // Update all relevant fields
                p.setName(updatePatient.getName());
                p.setAge(updatePatient.getAge());
                p.setGender(updatePatient.getGender());
                p.setEmail(updatePatient.getEmail());
                p.setPhoneNumber(updatePatient.getPhoneNumber());
                p.setAddress(updatePatient.getAddress());
                p.setBloodGroup(updatePatient.getBloodGroup());
                p.setDisease(updatePatient.getDisease());
                p.setAdmissionDate(updatePatient.getAdmissionDate());
                p.setDischargeDate(updatePatient.getDischargeDate());
                p.setDoctorAssigned(updatePatient.getDoctorAssigned());

                // Save updated patient
                Patients savedPatient = patientRepository.save(p);
                return savedPatient; // return updated entity from DB
            } else {
                logger.error("Patient with id {} not found", id);
                return null;
            }
        } catch (Exception e) {
            logger.error("Error updating patient by ID {}: {}", id, e.getMessage(), e);
            return null;
        }
    }

}


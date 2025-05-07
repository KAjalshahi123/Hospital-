package com.Hospitalmanagement.Hospital.Service;

import com.Hospitalmanagement.Hospital.Repository.DoctorRepository;
import com.Hospitalmanagement.Hospital.modles.Doctor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private static final Logger logger = LoggerFactory.getLogger(DoctorService.class);
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAll() {
        try {
            logger.info("Fetching all doctors from service layer");
           // return null; // Replace with actual logic
            return doctorRepository.findAll();
        } catch (Exception e) {
            logger.error("Error occurred while fetching all doctors: {}", e.getMessage(), e);
            return null;
        }
    }

    public Doctor getDoctorByid(Long id) {
        try {
            //return null; // Replace with actual logic
            Optional<Doctor>doctor = doctorRepository.findById(id);
            return doctor.orElse(null);
        } catch (Exception e) {
            logger.error("Error occurred while fetching doctor by ID: {}", e.getMessage(), e);
            return null;
        }
    }

    public Doctor createDoctor(Doctor doctor) {
        try {
           // return null; // Replace with actual logic
            doctorRepository.save(doctor);
            return doctor;
        } catch (Exception e) {
            logger.error("Error occurred while creating doctor: {}", e.getMessage(), e);
            return null;
        }
    }

    public void DeleteDoctorByid(Long id) {
        try {
          doctorRepository.deleteById(id);  // Add logic here
        } catch (Exception e) {
            logger.error("Error occurred while deleting doctor by ID: {}", e.getMessage(), e);
        }
    }

    public Doctor updateDoctorById(Long id, Doctor updatedDoctor) {
        try {
            Optional<Doctor> existingDoctor = doctorRepository.findById(id);
            if (existingDoctor.isPresent()) {
                Doctor d = existingDoctor.get();
                d.setName(updatedDoctor.getName());
                d.setSpeciality(updatedDoctor.getSpeciality());
                d.setEmail(updatedDoctor.getEmail());
                d.setPhoneNumber(updatedDoctor.getPhoneNumber());
                d.setExperience(updatedDoctor.getExperience());
                d.setQualification(updatedDoctor.getQualification());
                d.setDepartment(updatedDoctor.getDepartment());
                d.setAvailableDays(updatedDoctor.getAvailableDays());
                d.setStartTime(updatedDoctor.getStartTime());
                d.setEndTime(updatedDoctor.getEndTime());

                doctorRepository.save(d); // Save the updated doctor
            } else {
                logger.warn("Doctor with ID {} not found.", id);
            }
        } catch (Exception e) {
            logger.error("Error occurred while updating doctor by ID: {}", e.getMessage(), e);
        }
        return updatedDoctor;
    }

}

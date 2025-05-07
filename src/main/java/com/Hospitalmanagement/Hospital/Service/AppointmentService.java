package com.Hospitalmanagement.Hospital.Service;

import com.Hospitalmanagement.Hospital.Repository.AppointmentRepository;
import com.Hospitalmanagement.Hospital.modles.Appointment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private static final Logger logger = LoggerFactory.getLogger(AppointmentService.class);
     @Autowired
     private AppointmentRepository appointmentRepository;
    public List<Appointment> getAll() {
        try {
            logger.info("Fetching all appointments from service layer");
           // return null; // Replace with actual logic
            return appointmentRepository.findAll();
        } catch (Exception e) {
            logger.error("Error occurred while fetching all appointments: {}", e.getMessage(), e);
            return null;
        }
    }

    public Appointment getAppointmentByid(Long id) {
        try {
          //  return null; // Replace with actual logic
            Optional<Appointment>appointment = appointmentRepository.findById(id);
            return appointment.orElse(null);
        } catch (Exception e) {
            logger.error("Error occurred while fetching appointment by ID: {}", e.getMessage(), e);
            return null;
        }
    }

    public Appointment createAppointment(Appointment appointment) {
        try {
           // return null; // Replace with actual logic
             appointmentRepository.save(appointment);
             return appointment;

        } catch (Exception e) {
            logger.error("Error occurred while creating appointment: {}", e.getMessage(), e);
            return null;
        }
    }

    public void DeleteAppointmentByid(Long id) {
        try {
            // Add logic here
            appointmentRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Error occurred while deleting appointment by ID: {}", e.getMessage(), e);
        }
    }

    public Appointment updateAppointmentByid(Long id, Appointment updatedAppointment) {
        try {
            // Fetch the existing appointment from the repository
            Optional<Appointment> existingAppointment = appointmentRepository.findById(id);

            // Check if the appointment exists
            if (existingAppointment.isPresent()) {
                Appointment appointment = existingAppointment.get();

                // Update relevant fields with the values from the updatedAppointment
                appointment.setPatientsId(updatedAppointment.getPatientsId());
                appointment.setDoctorId(updatedAppointment.getDoctorId());
                appointment.setDepartment(updatedAppointment.getDepartment());
                appointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
                appointment.setStatus(updatedAppointment.getStatus());
                appointment.setReason(updatedAppointment.getReason());
                appointment.setNotes(updatedAppointment.getNotes());

                // Save the updated appointment back to the repository
                return appointmentRepository.save(appointment);
            } else {
                logger.error("Appointment with id {} not found", id);
                return null; // Return null if appointment is not found
            }
        } catch (Exception e) {
            logger.error("Error occurred while updating appointment by ID: {}", e.getMessage(), e);
            return null; // Return null if an error occurs
        }
    }

}

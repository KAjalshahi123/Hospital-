package com.Hospitalmanagement.Hospital.Controller;

import com.Hospitalmanagement.Hospital.Service.AppointmentService;
import com.Hospitalmanagement.Hospital.modles.Appointment;
import com.Hospitalmanagement.Hospital.modles.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @GetMapping
    public List<Appointment> getAll(){
        System.out.println("Fetching the data");
        return appointmentService.getAll();
    }
    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment){
        System.out.println("Create Appointment");
       return appointmentService.createAppointment(appointment);
    }
    @GetMapping("/{id}")
    public Appointment createAppointment(@PathVariable Long id){
        System.out.println("Fetching id by ID");
        return appointmentService.getAppointmentByid(id);
    }
    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id){
     appointmentService.DeleteAppointmentByid(id);
    }
    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment updatedAppointment) {
        return appointmentService.updateAppointmentByid(id, updatedAppointment);
    }

}

package com.Hospitalmanagement.Hospital.Controller;

import com.Hospitalmanagement.Hospital.Service.DoctorService;
import com.Hospitalmanagement.Hospital.modles.Doctor;
import com.Hospitalmanagement.Hospital.modles.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/Doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @GetMapping
    public List<Doctor> getAll(){
        System.out.println("Fetching the data");
        return doctorService.getAll();
    }
    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor){
        System.out.println("Create Patients");
        return doctorService.createDoctor(doctor);
    }
    @GetMapping("/{id}")
    public Doctor getDoctorByid(@PathVariable Long id){
        System.out.println("Fetching id by ID");
        return doctorService.getDoctorByid(id);
    }
    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id){
      doctorService.DeleteDoctorByid(id);
    }
    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor updatedDoctor) {
        return doctorService.updateDoctorById(id, updatedDoctor);
    }

}



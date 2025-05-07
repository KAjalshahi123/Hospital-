package com.Hospitalmanagement.Hospital.Controller;

import com.Hospitalmanagement.Hospital.Service.PatientService;
import com.Hospitalmanagement.Hospital.modles.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/patients")
public class patientsController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patients> getAll(){
        System.out.println("Fetching the data");
        return patientService.getAll();

    }
    @PostMapping
    public Patients createPatients(@RequestBody Patients patients){
        System.out.println("Create Patients");
        return patientService.createPatient(patients);
    }
    @GetMapping("/{id}")
    public Patients createPatients(@PathVariable Long id){
        System.out.println("Fetching id by ID");
        return patientService.getPatientByid(id);

    }
    @DeleteMapping("/{id}")
    public void deletePatients(@PathVariable Long id){
        patientService.DeletePatientByid(id);

    }
    @PutMapping("/{id}")
    public Patients updatePatient(@PathVariable Long id, @RequestBody Patients updatedPatient) {
        System.out.println("Updating patient with ID " + id);
        return patientService.updatePatientByid(id, updatedPatient);  // Pass the updated patient details
    }
}

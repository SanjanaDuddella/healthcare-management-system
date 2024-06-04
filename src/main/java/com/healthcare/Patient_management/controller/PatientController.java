package com.healthcare.Patient_management.controller;

import com.healthcare.Patient_management.model.Patient;
import com.healthcare.Patient_management.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/health-mgmt/patients")
public class PatientController
{
    @Autowired
    private PatientService patientService;

    @PostMapping
    public Patient savePatient(@RequestBody Patient patient)
    {
        return patientService.savePatient(patient);
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id)
    {
        return patientService.getPatientById(id);
    }

    @GetMapping
    public List<Patient> getAllPatients()
    {
        return patientService.getAllPatients();
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient)
    {
        return patientService.updateDetails(id,patient);
    }

    @DeleteMapping("/id")
    public void deletePatient(@PathVariable Long id)
    {
         patientService.deletePatient(id);
    }
}

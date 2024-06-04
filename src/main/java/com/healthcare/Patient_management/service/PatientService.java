package com.healthcare.Patient_management.service;

import com.healthcare.Patient_management.exception.ResourceNotFound;
import com.healthcare.Patient_management.model.Patient;
import com.healthcare.Patient_management.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService
{
    @Autowired
    private PatientRepo patientRepo;

    public List<Patient> getAllPatients()
    {
       return patientRepo.findAll();
    }

    public Patient getPatientById(Long id)
    {
        return patientRepo.findById(id).orElseThrow(() -> new ResourceNotFound("No such patient details found."));
    }

    public Patient savePatient(Patient patient)
    {
        return patientRepo.save(patient);
    }

    public Patient updateDetails(Long id, Patient patient)
    {
        Patient details = patientRepo.findById(id).orElseThrow(() -> new ResourceNotFound("No patient record found to update"));
        details.setEmail(patient.getEmail());
        details.setAddress(patient.getAddress());
        details.setPhone(patient.getPhone());
        return details;
    }

     public void deletePatient(Long id)
     {
         Patient toBeDeleted = patientRepo.findById(id).orElseThrow(() -> new ResourceNotFound("No patient record found to delete."));
         patientRepo.delete(toBeDeleted);
     }





}

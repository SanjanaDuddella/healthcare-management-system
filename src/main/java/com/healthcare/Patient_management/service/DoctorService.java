package com.healthcare.Patient_management.service;


import com.healthcare.Patient_management.exception.ResourceNotFound;
import com.healthcare.Patient_management.model.Doctor;
import com.healthcare.Patient_management.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService
{
    @Autowired
    DoctorRepo doctorRepo;

    public Doctor addDoctor(Doctor doctor)
    {
        return doctorRepo.save(doctor);
    }

    public List<Doctor> getAllDoctors()
    {
        return doctorRepo.findAll();
    }
    public Doctor getDoctorById(Long docId)
    {
        Doctor doc = doctorRepo.findById(docId).orElseThrow(() -> new ResourceNotFound("Doctor record not found."));
        return doc;
    }
    public void deleteDoctor(Long docId)
    {
        Doctor doc = doctorRepo.findById(docId).orElseThrow(() -> new ResourceNotFound("Doctor record not found."));
        doctorRepo.delete(doc);
    }
}

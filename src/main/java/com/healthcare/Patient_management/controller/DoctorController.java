package com.healthcare.Patient_management.controller;


import com.healthcare.Patient_management.model.Doctor;
import com.healthcare.Patient_management.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/health-mgmt/doctor")
public class DoctorController
{
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor)
    {
        doctorService.addDoctor(doctor);
    }
    @GetMapping("/{id}")
    public Doctor getDoctorbyId(@PathVariable Long docId)
    {
        doctorService.getDoctorById(docId);
    }
     @GetMapping
     public
}

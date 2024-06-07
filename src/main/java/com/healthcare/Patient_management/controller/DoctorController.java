package com.healthcare.Patient_management.controller;


import com.healthcare.Patient_management.model.Doctor;
import com.healthcare.Patient_management.model.Patient;
import com.healthcare.Patient_management.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/health-mgmt/doctor")
public class DoctorController
{
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public String addDoctor(@ModelAttribute("doctor") Doctor doctor)

    {
        doctorService.addDoctor(doctor);
        return "redirect:/api/health-mgmt/doctor";
    }
    @GetMapping("/newDoctor")
    public String showNewDoctorForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "new_Doctor";
    }
    @GetMapping("/{id}")
    public String getDoctorbyId(@PathVariable Long docId, Model model)
    {
         Doctor doctor = doctorService.getDoctorById(docId);
         model.addAttribute("doctor", doctor);
         return "doctor";
    }
     @GetMapping
     public String doctorList(Model model)

     {
         List<Doctor> doctorList = doctorService.getAllDoctors();
         model.addAttribute("doctors", doctorList);
         return "doctors";
     }
     @GetMapping("delete/{id}")
     public String deleteDoctor(@PathVariable Long id)

     {
         doctorService.deleteDoctor(id);
         return "redirect:/api/health-mgmt/doctor";
     }
}

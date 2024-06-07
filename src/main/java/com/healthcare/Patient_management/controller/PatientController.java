package com.healthcare.Patient_management.controller;

import com.healthcare.Patient_management.model.Patient;
import com.healthcare.Patient_management.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/health-mgmt/patients")
public class PatientController
{
    @Autowired
    private PatientService patientService;

    @PostMapping
    public String savePatient(@ModelAttribute("patient") Patient patient)
    {
        patientService.savePatient(patient);
        return "redirect:/api/health-mgmt/patients";
    }
    @GetMapping("/new")
    public String showNewPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "new_patient";
    }
    @GetMapping("/{id}")
    public String getPatientById(@PathVariable Long id, Model model)

    {
        Patient patient = patientService.getPatientById(id);
        model.addAttribute("patient", patient);
        return "patient_detail";
    }

    @GetMapping
    public String getAllPatients(Model model)

    {
        List<Patient> patientList = patientService.getAllPatients();
        model.addAttribute("patients", patientList);
        return "patients";
    }

    @GetMapping("edit/{id}")
    public String showEditPatientForm(@PathVariable Long id, Model model) {
        Patient patient = patientService.getPatientById(id);
        model.addAttribute("patient", patient);
        return "edit_patient";
    }
    @PostMapping("/{id}")
    public String updatePatient(@PathVariable Long id, @ModelAttribute("patient") Patient patient)
    {
        patientService.updateDetails(id, patient);
        return "redirect:/api/health-mgmt/patients";
    }

    @GetMapping("delete/{id}")
    public String deletePatient(@PathVariable Long id)
    {
         patientService.deletePatient(id);
         return "redirect:/api/health-mgmt/patients";
    }
}

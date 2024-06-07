package com.healthcare.Patient_management.controller;

import com.healthcare.Patient_management.model.MedicalRecord;
import com.healthcare.Patient_management.repository.MedicalRecordRepo;
import com.healthcare.Patient_management.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/health-mgmt/medical-records")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    @PostMapping
    public String addRecord(@ModelAttribute("medicalrecord") MedicalRecord medicalRecord)
    {
        medicalRecordService.addReport(medicalRecord);
        return "redirect:/api/health-mgmt/medical-records";
    }
    @GetMapping
    public String getAllRecords(Model model)
    {
        List<MedicalRecord> records = medicalRecordService.getAllRecords();
        model.addAttribute("records", records);
        return "medicalrecords";
    }

    @GetMapping("/{id}")
    public String getRecordById(@PathVariable Long id, Model model)

    {
        MedicalRecord medicalRecord = medicalRecordService.getRecordById(id);
        model.addAttribute("record", medicalRecord);
        return "medicalrecord";
    }

    @GetMapping("delete/{id}")
    public String deleteRecord(@PathVariable Long id)
    {
        medicalRecordService.deleteRecord(id);
        return "redirect:/api/health-mgmt/medical-records";
    }


}

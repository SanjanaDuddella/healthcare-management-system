package com.healthcare.Patient_management.service;

import com.healthcare.Patient_management.exception.ResourceNotFound;
import com.healthcare.Patient_management.model.MedicalRecord;
import com.healthcare.Patient_management.repository.MedicalRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepo medicalRecordRepo;

    public MedicalRecord addReport(MedicalRecord medicalRecord)
    {
        return medicalRecordRepo.save(medicalRecord);
    }

    public List<MedicalRecord> getAllRecords()
    {
        return medicalRecordRepo.findAll();
    }

    public MedicalRecord getRecordById(Long medId)
    {
        return medicalRecordRepo.findById(medId).orElseThrow(() -> new ResourceNotFound("No medical record found."));
    }

    public void deleteRecord(Long id)
    {
        MedicalRecord rec = medicalRecordRepo.findById(id).orElseThrow(() -> new ResourceNotFound("No medical record found."));
        medicalRecordRepo.delete(rec);
    }

}

package com.healthcare.Patient_management.repository;

import com.healthcare.Patient_management.model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepo extends JpaRepository<MedicalRecord,Long> {
}

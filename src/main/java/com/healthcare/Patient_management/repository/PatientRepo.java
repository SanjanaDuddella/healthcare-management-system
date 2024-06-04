package com.healthcare.Patient_management.repository;

import com.healthcare.Patient_management.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long>
{
}

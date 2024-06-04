package com.healthcare.Patient_management.repository;

import com.healthcare.Patient_management.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.Doc;

public interface DoctorRepo extends JpaRepository<Doctor,Long> {
}

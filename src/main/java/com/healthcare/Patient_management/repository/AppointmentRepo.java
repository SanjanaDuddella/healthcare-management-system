package com.healthcare.Patient_management.repository;

import com.healthcare.Patient_management.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepo extends JpaRepository<Appointment,Long> {
    List<Appointment> findByPatientId(Long patientId);
}

package com.healthcare.Patient_management.service;

import com.healthcare.Patient_management.exception.ResourceNotFound;
import com.healthcare.Patient_management.model.Appointment;
import com.healthcare.Patient_management.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepo appointmentRepo;

    public List<Appointment> patientAppointments()
    {
        return appointmentRepo.findAll();
    }

    public Appointment appointmentsById(Long id)
    {
       Appointment appt = appointmentRepo.findById(id).orElseThrow(() -> new ResourceNotFound("No appointments found."));
       return appt;
    }
    public List<Appointment> appointmentsByPatientId(Long patientId)
    {
        List<Appointment> apptByPatient = appointmentRepo.findByPatientId(patientId);
        return apptByPatient;
    }
    public Appointment saveAppointment(Appointment appointment)
    {
        return appointmentRepo.save(appointment);
    }

    public Appointment updateApptTime(Long id, Appointment appointment)
    {
        Appointment appt = appointmentRepo.findById(id).orElseThrow(() -> new ResourceNotFound("No appointment record found."));
        appt.setAppointmentTime(appointment.getAppointmentTime());
        return appt;
    }
    public void deleteAppointment(Long id)
    {
        Appointment toBeDeleted = appointmentRepo.findById(id).orElseThrow(() -> new ResourceNotFound("No patient record found to delete."));
        appointmentRepo.delete(toBeDeleted);
    }


}

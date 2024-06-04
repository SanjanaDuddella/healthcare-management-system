package com.healthcare.Patient_management.controller;


import com.healthcare.Patient_management.model.Appointment;
import com.healthcare.Patient_management.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/health-mgmt/appt")
public class AppointmentController
{
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public Appointment saveAppt(@RequestBody Appointment appointment)
    {
        return appointmentService.saveAppointment(appointment);
    }

    @GetMapping("/{id}")
    public Appointment getApptById(@PathVariable Long id)
    {
        return appointmentService.appointmentsById(id);
    }
    @GetMapping("/{patientId}")
    public List<Appointment> getApptByPatientId(@PathVariable Long patientId)
    {
        return appointmentService.appointmentsByPatientId(patientId);
    }
    @GetMapping
    public List<Appointment> getAllPatients()
    {
        return appointmentService.patientAppointments();
    }

    @PutMapping("/{id}")
    public Appointment updateAppt(@PathVariable Long id, @RequestBody Appointment appointment)
    {
        return appointmentService.updateApptTime(id,appointment);
    }
    @DeleteMapping("/id")
    public void deleteAppointments(@PathVariable Long id)
    {
        appointmentService.deleteAppointment(id);
    }
}


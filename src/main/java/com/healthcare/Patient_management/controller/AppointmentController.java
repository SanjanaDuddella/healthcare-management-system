package com.healthcare.Patient_management.controller;


import com.healthcare.Patient_management.model.Appointment;
import com.healthcare.Patient_management.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/health-mgmt/appt")
public class AppointmentController
{
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public String saveAppt(@ModelAttribute("appointment") Appointment appointment)
    {
        appointmentService.saveAppointment(appointment);
        return "redirect:/api/health-mgmt/appt";
    }

    @GetMapping("/{id}")
    public String getApptById(@PathVariable Long id, Model model)
    {
        Appointment appt = appointmentService.appointmentsById(id);
        model.addAttribute("appointment", appt);
        return "appointment";

    }
    @GetMapping("/{patientId}")
    public String getApptByPatientId(@PathVariable Long patientId, Model model)
    {
        List<Appointment> apptListByPatient =  appointmentService.appointmentsByPatientId(patientId);
        model.addAttribute("appointments", apptListByPatient);
        return "patientappointments";
    }
    @GetMapping
    public String getAllAppointments(Model model)

    {
        List<Appointment> appointments = appointmentService.patientAppointments();
        model.addAttribute("appointmentlist", appointments);
        return "appointments";
    }

    @PostMapping("edit/{id}")
    public String updateAppt(@PathVariable Long id, @ModelAttribute("appointment") Appointment appointment)
    {
        Appointment appt = appointmentService.updateApptTime(id, appointment);
        return "redirect:/api/health-mgmt/appt";

    }
    @GetMapping("delete/id")
    public String deleteAppointments(@PathVariable Long id)

    {
        appointmentService.deleteAppointment(id);
        return "redirect:/api/health-mgmt/appt";
    }
}


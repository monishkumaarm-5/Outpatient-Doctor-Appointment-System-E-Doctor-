package com.infosys.eDoctor.controller;

import com.infosys.eDoctor.entity.Appointment;
import com.infosys.eDoctor.entity.Doctor;
import com.infosys.eDoctor.entity.Patient;
import com.infosys.eDoctor.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public Appointment getAppointment(@PathVariable int id) {
        return appointmentService.getAppointment(id);
    }

    @PostMapping
    public Appointment addAppointment(@RequestBody Appointment appointment) {
        return appointmentService.addAppointment(appointment);
    }

    @PutMapping
    public Appointment updateAppointment(@RequestBody Appointment appointment) {
        return appointmentService.updateAppointment(appointment);
    }
    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable int id) {
        appointmentService.deleteAppointment(id);
    }

    @GetMapping("/doctor")
    public List<Appointment> getAppointmentsByDoctorId(@RequestParam String doctorId) {
        return appointmentService.getAppointmentsByDoctorId(doctorId);
    }

    @GetMapping("/date")
    public List<Appointment> getAppointmentsByDate(@RequestParam LocalDate date) {
        return appointmentService.getAppointmentsByDate(date);
    }

    @GetMapping("/availability/count")
    public int getAvailabilityCountForDoctor(@RequestParam String doctorId,LocalDate date) {
        return appointmentService.getAvailabilityCountForDoctor(doctorId,date);
    }
// updated part -20-12-2024
    @GetMapping("/patients")
    public List<Patient> getPatientsByDoctorAndDate(@RequestParam String doctorId, @RequestParam String date) {
        LocalDate appointmentDate = LocalDate.parse(date);
        return appointmentService.getPatientsByDoctorAndDate(doctorId, appointmentDate);
    }


}

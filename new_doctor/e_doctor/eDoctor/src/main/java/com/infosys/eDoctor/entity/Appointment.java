package com.infosys.eDoctor.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;

    @Column(nullable = false)
    private LocalDate appointmentDate;

    private String appointmentStatus;
    private String remark;

    @ManyToOne
    @JoinColumn(name = "patientId") // Foreign key for Patient
    private Patient patient;  // Use Patient object directly for the relationship

    @ManyToOne
    @JoinColumn(name = "doctorId") // Foreign key for Patient
    private Doctor doctor;

    // Getters and setters...
    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}

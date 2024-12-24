package com.infosys.eDoctor.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.*;

@Entity
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int availabilityId;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "doctorId") // Foreign key for Patient
    private Doctor doctor2;

    public Availability() {
    }

    public Availability(String doctorId, LocalDate startDate, LocalDate endDate) {

        this.startDate = startDate;
        this.endDate = endDate;
    }
    // Getters and Setters
    public int getAvailabilityId() {
        return availabilityId;
    }

    public void setAvailabilityId(int availabilityId) {
        this.availabilityId = availabilityId;
    }

    public Doctor getDoctor2() {
        return doctor2;
    }

    public void setDoctor2(Doctor doctor2) {
        this.doctor2 = doctor2;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}

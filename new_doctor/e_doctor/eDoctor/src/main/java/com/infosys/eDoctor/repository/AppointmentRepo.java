package com.infosys.eDoctor.repository;

import com.infosys.eDoctor.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {

    // Find appointments by doctorId (corrected to use the Doctor entity's reference)
    List<Appointment> findByDoctor_DoctorId(String doctorId);

    // Find appointments by patientId (corrected to use the Patient entity's reference)
    List<Appointment> findByPatient_PatientId(int patientId);

    // Find appointments by doctorId and appointmentDate (corrected to use Doctor entity reference)
    List<Appointment> findByDoctor_DoctorIdAndAppointmentDate(String doctorId, LocalDate date);

    // Find appointments by appointment date
    List<Appointment> findByAppointmentDate(LocalDate date);

    // Query to count appointments by doctorId and appointmentDate
    @Query("SELECT COUNT(a) FROM Appointment a WHERE a.doctor.doctorId = :doctorId AND a.appointmentDate = :date")
    int countAppointmentsByDoctorAndDate(String doctorId, LocalDate date);
}

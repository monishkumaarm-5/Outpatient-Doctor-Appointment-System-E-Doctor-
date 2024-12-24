package com.infosys.eDoctor.repository;

import com.infosys.eDoctor.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {
    // Use Users' email to fetch Patient details
    Optional<Patient> findByUsers2_Email(String email); // Access the email field in the Users entity
    Optional<Patient> findByMobileNo(String mobileNo);
}

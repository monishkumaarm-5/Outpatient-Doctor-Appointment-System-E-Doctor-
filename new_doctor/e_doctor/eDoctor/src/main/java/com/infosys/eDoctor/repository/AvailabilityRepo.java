package com.infosys.eDoctor.repository;

import com.infosys.eDoctor.entity.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailabilityRepo extends JpaRepository<Availability, Integer> {

    @Query("SELECT COUNT(a) FROM Availability a WHERE a.doctor2.doctorId = :doctorId")
    int countAvailabilityByDoctor(String doctorId);

    List<Availability> findByDoctor2_DoctorId(String doctorId);
}

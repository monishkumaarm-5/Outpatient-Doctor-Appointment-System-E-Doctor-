package com.infosys.eDoctor.service;

import com.infosys.eDoctor.entity.Availability;
import com.infosys.eDoctor.repository.AvailabilityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailabilityService {

    @Autowired
    private AvailabilityRepo availabilityRepo;

    public Availability addAvailability(Availability availability) {
        return availabilityRepo.save(availability);
    }

    public List<Availability> getAvailabilityByDoctorId(String doctorId) {
        return availabilityRepo.findByDoctor2_DoctorId(doctorId);
    }

    public List<Availability> getAllAvailability() {
        return availabilityRepo.findAll();
    }
}

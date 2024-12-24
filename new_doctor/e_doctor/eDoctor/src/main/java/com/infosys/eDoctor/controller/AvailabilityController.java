package com.infosys.eDoctor.controller;

import com.infosys.eDoctor.entity.Availability;
import com.infosys.eDoctor.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/availability")
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    
    @PostMapping("/addAvailability")
    @CrossOrigin(origins = "http://localhost:3000")
    public Availability addAvailability(@RequestBody Availability availability) {
        return availabilityService.addAvailability(availability);
    }

    @GetMapping("/getByDoctor/{doctorId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Availability> getAvailabilityByDoctorId(@PathVariable String doctorId) {
        return availabilityService.getAvailabilityByDoctorId(doctorId);
    }



    @GetMapping("/getAll")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Availability> getAllAvailability() {
        return availabilityService.getAllAvailability();
    }
}

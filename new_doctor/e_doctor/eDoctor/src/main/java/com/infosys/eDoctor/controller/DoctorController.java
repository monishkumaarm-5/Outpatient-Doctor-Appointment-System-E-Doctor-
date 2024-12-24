package com.infosys.eDoctor.controller;

import com.infosys.eDoctor.entity.Doctor;
import com.infosys.eDoctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Add new doctor
    @PostMapping("/addDoctor")
    @CrossOrigin(origins = "http://localhost:3000")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }

    // Get doctor by ID
    @GetMapping("/getDoctor/{doctorId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Optional<Doctor> getDoctorById(@PathVariable String doctorId) {
        return doctorService.getDoctorById(doctorId);
    }

    // Get doctor by email
    @GetMapping("/getDoctorByEmail")
    @CrossOrigin(origins = "http://localhost:3000")
    public Optional<Doctor> getDoctorByEmail(@RequestParam String email) {
        return doctorService.getDoctorByEmail(email);
    }

    // Get all doctors
    @GetMapping("/getAllDoctors")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    // Update doctor details
    @PutMapping("/updateDoctor")
    @CrossOrigin(origins = "http://localhost:3000")
    public Doctor updateDoctor(@RequestBody Doctor doctor) {
        return doctorService.updateDoctor(doctor);
    }

    // Delete doctor
    @DeleteMapping("/deleteDoctor/{doctorId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> deleteDoctor(@PathVariable String doctorId) {
        doctorService.deleteDoctor(doctorId);
        return ResponseEntity.ok("Doctor deleted successfully");
    }


    // Doctor login
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        boolean isAuthenticated = doctorService.authenticateDoctor(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );

        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    // Inner class for login request
    public static class LoginRequest {
        private String email;
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}

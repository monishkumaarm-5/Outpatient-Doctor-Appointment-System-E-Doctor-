package com.infosys.eDoctor.controller;

import com.infosys.eDoctor.entity.Patient;
import com.infosys.eDoctor.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Add a new patient
    @PostMapping("/addPatient")
    @CrossOrigin(origins = "http://localhost:3000")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    // Get patient by ID
    @GetMapping("/getPatient/{patientId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Optional<Patient> getPatientById(@PathVariable int patientId) {
        return patientService.getPatientById(patientId);
    }

    // Get patient by email
    @GetMapping("/getPatientByEmail")
    @CrossOrigin(origins = "http://localhost:3000")
    public Optional<Patient> getPatientByEmail(@RequestParam String email) {
        return patientService.getPatientByEmail(email);
    }

    // Get all patients (admin use)
    @GetMapping("/getAllPatients")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    // Update patient details
    @PutMapping("/updatePatient")
    @CrossOrigin(origins = "http://localhost:3000")
    public Patient updatePatient(@RequestBody Patient patient) {
        return patientService.updatePatient(patient);
    }

    // Delete patient
    @DeleteMapping("/deletePatient/{patientId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> deletePatient(@PathVariable int patientId) {
        patientService.deletePatient(patientId);
        return ResponseEntity.ok("Patient deleted successfully");
    }

    // Patient login
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        boolean isAuthenticated = patientService.authenticatePatient(
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
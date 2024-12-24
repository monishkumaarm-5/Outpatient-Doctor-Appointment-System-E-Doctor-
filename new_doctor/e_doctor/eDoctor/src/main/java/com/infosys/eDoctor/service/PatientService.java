package com.infosys.eDoctor.service;

import com.infosys.eDoctor.entity.Patient;
import com.infosys.eDoctor.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender mailSender;
    // Add a new patient
    public Patient addPatient(Patient patient) {
        // Encrypt the password before saving
        patient.getUsers2().setPassword(patient.getUsers2().getPassword());
        if (patient != null) {
            // Email to patient
            String patientSubject = "Welcome to eDoctor!";
            String patientBody = "Dear " + patient.getPatientName() + ",\n\n" +
                    "Thank you for registering with eDoctor. Your account has been successfully created.\n\n" +
                    "Here are your account details:\n" +
                    "Name: " + patient.getPatientName() + "\n" +
                    "Email: " + patient.getUsers2().getEmail() + "\n" +
                    "Mobile Number: " + patient.getMobileNo() + "\n\n" +
                    "We are excited to have you on board. Please log in to your account to explore our services.\n\n" +
                    "Thank you,\nThe eDoctor Team";
            sendEmail(patient.getUsers2().getEmail(), patientSubject, patientBody);
        }
        return patientRepo.save(patient);



    }

    // Get patient by ID
    public Optional<Patient> getPatientById(int patientId) {
        return patientRepo.findById(patientId);
    }

    // Get patient by email
    public Optional<Patient> getPatientByEmail(String email) {
        return patientRepo.findByUsers2_Email(email);
    }

    // Get all patients
    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    // Update patient details
    public Patient updatePatient(Patient patient) {
        // Check if patient exists
        Patient existingPatient = patientRepo.findById(patient.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // Update fields
        existingPatient.setPatientName(patient.getPatientName());
        existingPatient.setMobileNo(patient.getMobileNo());
        existingPatient.getUsers2().setEmail(patient.getUsers2().getEmail());
        existingPatient.setBloodGroup(patient.getBloodGroup());
        existingPatient.setGender(patient.getGender());
        existingPatient.setAge(patient.getAge());
        existingPatient.setAddress(patient.getAddress());

        return patientRepo.save(existingPatient);
    }

    // Delete patient
    public void deletePatient(int patientId) {
        patientRepo.deleteById(patientId);
    }

    // Patient login
    public boolean authenticatePatient(String email, String password) {
        Optional<Patient> patient = patientRepo.findByUsers2_Email(email);
        return patient.map(value -> passwordEncoder.matches(password, value.getUsers2().getPassword()))
                .orElse(false);
    }

    // Update request status
    public Patient updateRequestStatus(int patientId, String status) {
        if (!status.equalsIgnoreCase("Accepted") && !status.equalsIgnoreCase("Rejected")) {
            throw new IllegalArgumentException("Invalid status. Use 'Accepted' or 'Rejected'.");
        }

        // Fetch the patient
        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // Update the request status
        patient.setRequestStatus(status);
        return patientRepo.save(patient);
    }

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}
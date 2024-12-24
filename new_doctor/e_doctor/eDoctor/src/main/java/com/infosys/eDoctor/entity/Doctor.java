package com.infosys.eDoctor.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Doctor {

    @Id
    private String doctorId;
    private String doctorName;
    private String speciality;
    private String location;
    private String experience;
    private String mobileNo;

    @OneToOne
    @JoinColumn(name = "email") // Use email as a foreign key
    private Users users;
    @OneToMany(mappedBy = "doctor") // One Patient can have many Appointments
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "doctor2") // One Patient can have many Appointments
    private List<Availability> availability;

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Lob
    private byte[] profilePhoto;

    public Doctor() {}

    public Doctor(String doctorId, String doctorName, String speciality, String location, String experience,
                  String mobileNo, Users users, byte[] profilePhoto) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.speciality = speciality;
        this.location = location;
        this.experience = experience;
        this.mobileNo = mobileNo;
        this.users = users;
        this.profilePhoto = profilePhoto;
    }

    // Getters and Setters
    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public byte[] getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(byte[] profilePhoto) {
        this.profilePhoto = profilePhoto;
    }
}

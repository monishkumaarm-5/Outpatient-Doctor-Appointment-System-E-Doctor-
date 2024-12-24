package com.infosys.eDoctor.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Patient {

    @Id
    private int patientId;
    private String patientName;
    private String mobileNo;
    private String bloodGroup;
    private String gender;
    private int age;
    private String address;

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @OneToOne
    @JoinColumn(name = "email") // Use email as a foreign key
    private Users users2;
    //Request
    @OneToMany(mappedBy = "patient") // One Patient can have many Appointments
    private List<Appointment> appointments;

    private String requestStatus;



    // Default constructor
    public Patient() {
    }

    // Parameterized constructor
    public Patient(int patientId, String patientName, String mobileNo, String email,
                   String password, String bloodGroup, String gender, int age, String address) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.mobileNo = mobileNo;
        this.users2=users2;
        this.bloodGroup = bloodGroup;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    // Getters and setters
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public Users getUsers2() {
        return users2;
    }

    public void setUsers2(Users users2) {
        this.users2 = users2;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }
}

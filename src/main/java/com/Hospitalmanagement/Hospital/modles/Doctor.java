package com.Hospitalmanagement.Hospital.modles;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String speciality;
    private String email;
    private String phoneNumber;
    private int experience; // in years
    private String qualification;
    private String department;
    private String availableDays; // e.g., "Mon-Fri"
    private String startTime; // e.g., "09:00 AM"
    private String endTime;   // e.g., "05:00 PM"

    // Constructors
    public Doctor() {
    }

    public Doctor(long id, String name, String speciality, String email, String phoneNumber,
                  int experience, String qualification, String department,
                  String availableDays, String startTime, String endTime) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.experience = experience;
        this.qualification = qualification;
        this.department = department;
        this.availableDays = availableDays;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(String availableDays) {
        this.availableDays = availableDays;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}

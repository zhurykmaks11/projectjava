package org.example;

import java.time.LocalDate;

public class Driver {
    private int id;
    private String fullName;
    private LocalDate birthDate;
    private int drivingExperience;
    private String phoneNumber;
    private int carId;

    public Driver(int id, String fullName, LocalDate birthDate, int drivingExperience, String phoneNumber) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.drivingExperience = drivingExperience;
        this.phoneNumber = phoneNumber;
        this.carId = carId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public void setDrivingExperience(int drivingExperience) {
        this.drivingExperience = drivingExperience;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }
}

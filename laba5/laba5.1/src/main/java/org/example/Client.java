package org.example;

import java.time.LocalDate;

public class Client {
    private int id;
    private String fullName;
    private LocalDate birthDate; // Залишаємо birthDate, а не dateOfBirth
    private String phoneNumber;

    public Client(int id, String fullName, LocalDate birthDate, String phoneNumber) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
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

    public LocalDate getBirthDate() { // Виправлено назву метода
        return birthDate; // Повертаємо birthDate
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

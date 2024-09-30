package org.example;

import lombok.Setter;


public class Car {
    private int id;
    private final String make;
    private String model;
    private int year;
    private String fuelType;
    private String bodyType;
    private String color;
    private String licensePlate;
    private int passengerCapacity;

    public Car(int id, String make, String model, int year, String fuelType, String bodyType, String color, String licensePlate, int passengerCapacity) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.bodyType = bodyType;
        this.color = color;
        this.licensePlate = licensePlate;
        this.passengerCapacity = passengerCapacity;
    }

    public int getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getColor() {
        return color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }


}


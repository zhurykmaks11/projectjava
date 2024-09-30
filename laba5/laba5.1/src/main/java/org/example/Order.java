package org.example;

public class Order {
    private int id;
    private double distance;
    private int driverId;
    private int clientId;

    public Order(int id, double distance, int driverId, int clientId) {
        this.id = id;
        this.distance = distance;
        this.driverId = driverId;
        this.clientId = clientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}

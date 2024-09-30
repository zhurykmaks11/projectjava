package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {
    private Connection connection;

    public CarDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Car car) throws SQLException {
        String sql = "INSERT INTO car (make, model, year, fuel_type, body_type, color, license_plate, passenger_capacity) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, car.getMake());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setInt(3, car.getYear());
            preparedStatement.setString(4, car.getFuelType());
            preparedStatement.setString(5, car.getBodyType());
            preparedStatement.setString(6, car.getColor());
            preparedStatement.setString(7, car.getLicensePlate());
            preparedStatement.setInt(8, car.getPassengerCapacity());
            preparedStatement.executeUpdate();
        }
    }

    public List<Car> getAll() throws SQLException {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM car";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Car car = new Car(resultSet.getInt("id"),
                        resultSet.getString("make"),
                        resultSet.getString("model"),
                        resultSet.getInt("year"),
                        resultSet.getString("fuel_type"),
                        resultSet.getString("body_type"),
                        resultSet.getString("color"),
                        resultSet.getString("license_plate"),
                        resultSet.getInt("passenger_capacity"));
                cars.add(car);
            }
        }
        return cars;
    }

    public void update(Car car) throws SQLException {
        String sql = "UPDATE car SET make=?, model=?, year=?, fuel_type=?, body_type=?, color=?, license_plate=?, passenger_capacity=?, WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, car.getMake());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setInt(3, car.getYear());
            preparedStatement.setString(4, car.getFuelType());
            preparedStatement.setString(5, car.getBodyType());
            preparedStatement.setString(6, car.getColor());
            preparedStatement.setString(7, car.getLicensePlate());
            preparedStatement.setInt(8, car.getPassengerCapacity());
            preparedStatement.setInt(10, car.getId());
            preparedStatement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM car WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}

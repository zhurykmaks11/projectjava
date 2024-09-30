package org.example;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Підключення до бази даних
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "user";
        String password = "123456";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            /*// Приклад додавання нової машини
            Car auto = new Car(1, "Toyota", "Corolla", 2020, "Petrol", "Sedan", "White", "ABC-123", 5);
            insertAuto(connection, auto);

            // Приклад додавання водія
            Driver driver = new Driver(1, "Ivan Ivanov", LocalDate.of(1985, 1, 15), 10, "0501234567");
            insertDriver(connection, driver);

            // Приклад додавання клієнта
            Client client = new Client(1, "Petro Petrov", LocalDate.of(1990, 2, 20), "0507654321");
            insertClient(connection, client);*/

            // Створюємо об'єкт OrderDAO
            OrderDAO orderDAO = new OrderDAO(connection);

// Додаємо нове замовлення
            Order order = new Order(1, 12.5, 28, 1); // Приклад
            orderDAO.insertOrder(connection, order);
            List<Order> orders = orderDAO.getAllOrders();
            System.out.println("All Orders:");
            for (Order o : orders) {
                System.out.println("Order ID: " + o.getId() + ", Distance: " + o.getDistance() +
                        ", Driver ID: " + o.getDriverId() + ", Client ID: " + o.getClientId());
            }

            // Сортування авто за довжиною здоланої дистанції
            sortCarsByDistance(connection);

            // Сортування клієнтів за частотою користування службою таксі
            sortClientsByFrequency(connection);

            try {
                // Пошук водія
                Driver foundDriver = getDriverById(connection, order.getDriverId());
                if (foundDriver != null) {
                    System.out.println("Driver Name: " + foundDriver.getFullName());
                } else {
                    throw new NullPointerException("Driver not found for ID: " + order.getDriverId());
                }
            // Пошук клієнта
            Client foundClient = getClientById(connection, 1);
            if (foundClient != null) {
                System.out.println("Found Client: " + foundClient.getFullName());
            } else {
                throw new NullPointerException("Client not found for ID: " + order.getClientId());
            }

        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Метод для вставки машини в базу даних
    public static void insertAuto(Connection connection, Car auto) throws SQLException {
        String sql = "INSERT INTO car (make, model, year, fuel_type, body_type, color, license_plate, passenger_capacity) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, auto.getMake());
            preparedStatement.setString(2, auto.getModel());
            preparedStatement.setInt(3, auto.getYear());
            preparedStatement.setString(4, auto.getFuelType());
            preparedStatement.setString(5, auto.getBodyType());
            preparedStatement.setString(6, auto.getColor());
            preparedStatement.setString(7, auto.getLicensePlate());
            preparedStatement.setInt(8, auto.getPassengerCapacity());
            preparedStatement.executeUpdate();
        }
    }

    // Метод для вставки водія в базу даних
    public static void insertDriver(Connection connection, Driver driver) throws SQLException {
        String sql = "INSERT INTO driver (full_name,birth_date, driving_experience, phone_number) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, driver.getFullName());
            preparedStatement.setDate(2, Date.valueOf(driver.getBirthDate()));
            preparedStatement.setInt(3, driver.getDrivingExperience());
            preparedStatement.setString(4, driver.getPhoneNumber());
            preparedStatement.executeUpdate();
        }
    }

    // Метод для вставки клієнта в базу даних
    public static void insertClient(Connection connection, Client client) throws SQLException {
        String sql = "INSERT INTO client (full_name, birth_date, phone_number) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, client.getFullName());
            preparedStatement.setDate(2, Date.valueOf(client.getBirthDate()));
            preparedStatement.setString(3, client.getPhoneNumber());
            preparedStatement.executeUpdate();
        }
    }

    // Метод для отримання водія за ID
    private static Driver getDriverById(Connection connection, int driverId) throws SQLException {
        String sql = "SELECT * FROM driver WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, driverId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Driver(
                        resultSet.getInt("id"),
                        resultSet.getString("full_name"),
                        resultSet.getDate("birth_date").toLocalDate(),
                        resultSet.getInt("driving_experience"),
                        resultSet.getString("phone_number")
                );
            }
        }
        return null;
    }

    // Метод для отримання клієнта за ID
    public static Client getClientById(Connection connection, int clientId) throws SQLException {
        String sql = "SELECT * FROM client WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, clientId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String fullName = resultSet.getString("full_name");
                    LocalDate birthDate = resultSet.getDate("birth_date").toLocalDate();
                    String phoneNumber = resultSet.getString("phone_number");
                    return new Client(clientId, fullName, birthDate, phoneNumber);
                } else {
                    return null;
                }
            }
        }
    }

    private static void sortCarsByDistance(Connection connection) throws SQLException {
        String sql = "SELECT car.*, SUM(norder.distance) AS total_distance " +
                "FROM car LEFT JOIN norder ON car.id = norder.driver_id " +
                "GROUP BY car.id ORDER BY total_distance DESC";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            System.out.println("Cars sorted by total distance:");
            while (resultSet.next()) {
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                double totalDistance = resultSet.getDouble("total_distance");
                System.out.println("Car: " + make + " " + model + ", Total Distance: " + totalDistance);
            }
        }
    }


    private static void sortClientsByFrequency(Connection connection) throws SQLException {
        String sql = "SELECT client.full_name, COUNT(norder.client_id) AS frequency " +
                "FROM client LEFT JOIN norder ON client.id = norder.client_id " +
                "GROUP BY client.id ORDER BY frequency DESC";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            System.out.println("Clients sorted by frequency:");
            while (resultSet.next()) {
                String fullName = resultSet.getString("full_name");
                int frequency = resultSet.getInt("frequency");
                System.out.println("Client: " + fullName + ", Frequency: " + frequency);
            }
        }
    }

}

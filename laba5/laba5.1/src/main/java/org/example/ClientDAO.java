package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    private Connection connection;

    public ClientDAO(Connection connection) {
        this.connection = connection;
    }


    public List<Client> getAll() throws SQLException {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM client";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Client client = new Client(resultSet.getInt("id"),
                        resultSet.getString("full_name"),
                        resultSet.getDate("birth_date").toLocalDate(),
                        resultSet.getString("phone_number"));

                clients.add(client);
            }
        }
        return clients;
    }

    public void update(Client client) throws SQLException {
        String sql = "UPDATE client SET full_name=?, birth_date=?, phone_number=? WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, client.getFullName());
            preparedStatement.setString(2, client.getBirthDate().toString());
            preparedStatement.setString(3, client.getPhoneNumber());
            preparedStatement.setInt(4, client.getId());
            preparedStatement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM client WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
    public void insert(Client client) throws SQLException {
        String sql = "INSERT INTO client (full_name, birth_date, phone_number) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, client.getFullName());
            preparedStatement.setDate(2, Date.valueOf(client.getBirthDate())); // Використання LocalDate
            preparedStatement.setString(3, client.getPhoneNumber());
            preparedStatement.executeUpdate();
        }
    }

}

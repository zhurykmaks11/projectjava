/*
package org.example;

import java.sql.*;

public class User {
    private String username;
    private String password;

    // Конструктор
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Геттери
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Сеттер для паролю
    public void setPassword(String password) {
        this.password = password;
    }

    public void register(Connection connection) throws SQLException {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password); // Зберігаємо пароль у відкритому вигляді
            preparedStatement.executeUpdate();
        }
    }

    public boolean login(Connection connection) throws SQLException {
        String sql = "SELECT password FROM users WHERE username = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");
                return password.equals(storedPassword); // Перевірка паролю
            }
            return false;
        }
    }
}
*/

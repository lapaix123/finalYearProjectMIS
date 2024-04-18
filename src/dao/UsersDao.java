/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lapaix
 */
public class UsersDao {
    private Connection connection;

    public UsersDao(Connection connection) {
        this.connection = connection;
    }

    public String validateUser(String email, String password) throws SQLException {
        String query = "SELECT type FROM Users WHERE email = ? AND password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("type");
                }
            }
        }
        return null; // Invalid credentials
    }
    
    public boolean createUser(String name, String email, String password, String type) throws SQLException {
    String query = "INSERT INTO Users (names, email, password, type) VALUES (?, ?, ?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, name);
        stmt.setString(2, email);
        stmt.setString(3, password);
        stmt.setString(4, type);
        int rowsInserted = stmt.executeUpdate();
        return rowsInserted > 0;
    }
}

    
}

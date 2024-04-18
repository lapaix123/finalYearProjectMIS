/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.ConfirmedProject;

/**
 *
 * @author lapaix
 */
public class ConfirmedProjectDao {
    private Connection connection;

    public ConfirmedProjectDao(Connection connection) {
        this.connection = connection;
    }

    public boolean addConfirmedProject(ConfirmedProject confirmedProject) throws SQLException {
        String query = "INSERT INTO ConfirmedProject (projectId, status, comments) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, confirmedProject.getProjectId());
            stmt.setString(2, confirmedProject.getStatus());
            stmt.setString(3, confirmedProject.getComments());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        }
    }
}

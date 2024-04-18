/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Project;

/**
 *
 * @author lapaix
 */
public class ProjectDao {
    private Connection connection;

    public ProjectDao(Connection connection) {
        this.connection = connection;
    }
    
     public boolean addProject(Project project) throws SQLException {
    String query = "INSERT INTO Project (title, caseStudy, description, studentId) VALUES (?, ?, ?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, project.getTittle());
        stmt.setString(2, project.getCaseStudy());
        stmt.setString(3, project.getDescription());
        stmt.setInt(4, project.getStudentId());
        int rowsInserted = stmt.executeUpdate();
        return rowsInserted > 0;
    }
}

     
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lapaix
 */
public class DatabaseConnection {
     private static final String URL = "jdbc:mysql://localhost:3306/finalYearProjctMIS";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Lapaix@123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}

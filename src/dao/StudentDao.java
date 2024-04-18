/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Student;

/**
 *
 * @author lapaix
 */
public class StudentDao {
     private Connection connection;

    public StudentDao(Connection connection) {
        this.connection = connection;
    }

    public void addStudent(Student student) throws SQLException {
        String query = "INSERT INTO Student (studentId, fName, lName, email, faculty, department) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, student.getStudentId());
            stmt.setString(2, student.getfName());
            stmt.setString(3, student.getlName());
            stmt.setString(4, student.getEmail());
            stmt.setString(5, student.getFuculty());
            stmt.setString(6, student.getDepartment());
            stmt.executeUpdate();
        }
    }

    public Student getStudentById(int studentId) throws SQLException {
        String query = "SELECT * FROM Student WHERE studentId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Student student = new Student();
                    student.setStudentId(rs.getInt("studentId"));
                    student.setfName(rs.getString("fName"));
                    student.setlName(rs.getString("lName"));
                    student.setEmail(rs.getString("email"));
                    student.setFuculty(rs.getString("faculty"));
                    student.setDepartment(rs.getString("department"));
                    return student;
                }
            }
        }
        return null; // Student with the given ID not found
    }

    public void updateStudent(Student student) throws SQLException {
        String query = "UPDATE Student SET fName=?, lName=?, email=?, faculty=?, department=? WHERE studentId=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, student.getfName());
            stmt.setString(2, student.getlName());
            stmt.setString(3, student.getEmail());
            stmt.setString(4, student.getFuculty());
            stmt.setString(5, student.getDepartment());
            stmt.setInt(6, student.getStudentId());
            stmt.executeUpdate();
        }
    }

    public void deleteStudent(String studentId) throws SQLException {
        String query = "DELETE FROM Student WHERE studentId=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, studentId);
            stmt.executeUpdate();
        }
    }

//    public List<Student> getAllStudents() throws SQLException {
//        List<Student> students = new ArrayList<>();
//        String query = "SELECT * FROM Student";
//        try (PreparedStatement stmt = connection.prepareStatement(query);
//             ResultSet rs = stmt.executeQuery()) {
//            while (rs.next()) {
//                Student student = new Student();
//                student.setStudentId(rs.getInt("studentId"));
//                student.setfName(rs.getString("fName"));
//                student.setlName(rs.getString("lName"));
//                student.setEmail(rs.getString("email"));
//                student.setFuculty(rs.getString("faculty"));
//                student.setDepartment(rs.getString("department"));
//                students.add(student);
//            }
//        }
//        return students;
//    }
}

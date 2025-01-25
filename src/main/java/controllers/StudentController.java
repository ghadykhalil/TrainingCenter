/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dbWrapper.JsonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Student;

/**
 *
 * @author User
 */
public class StudentController {

    private static final String STUDENT_FILE = "src/main/java/data/students.json";

    private static final JsonUtils json = JsonUtils.getInstance();

    public StudentController() {
    }

    public static List<Student> getStudents() {
        try {
            List<Student> students = json.readData(STUDENT_FILE, Student.class);
            return students != null ? students : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error reading academic years data: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static Student getStudentById(String studentId) {
        List<Student> allStudents = getStudents();
        if (allStudents != null) {
            for (Student student : allStudents) {
                if (student.getId().equals(studentId)) {
                    return student;
                }
            }
        }
        return null;
    }

    public static void addStudent(Student student) {
        try {
            if (alreadyExists(student.getUsername())) {
                JOptionPane.showMessageDialog(null,
                        "A student with the username '" + student.getUsername() + "' already exists.",
                        "Duplicate Entry",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                json.saveData(STUDENT_FILE, student);
                JOptionPane.showMessageDialog(null,
                        "Student added successfully!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred while adding the student: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean alreadyExists(String username) {
        try {
            List<Student> allStudents = json.readData(STUDENT_FILE, Student.class);
            for (Student objStudent : allStudents) {
                if (objStudent.getUsername().equals(username)) {
                    return true; 
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading student data: " + e.getMessage());
        }
        return false; 
    }

}

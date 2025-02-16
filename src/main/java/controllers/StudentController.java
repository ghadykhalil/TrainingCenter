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

    public static List<Student> getStudents() {
        try {
            List<Student> students = json.readData(STUDENT_FILE, Student.class);
            return students != null ? students : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error reading students data: " + e.getMessage());
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

    public static boolean addStudent(Student student) {
        boolean success = false;
        try {
            if (alreadyExists(student.getUsername())) {
                JOptionPane.showMessageDialog(null,
                        "A student with the username '" + student.getUsername() + "' already exists.",
                        "Duplicate Entry",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                json.saveData(STUDENT_FILE, student);
                success = true;
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
        return success;
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
    
    public static void updateStudent(Student updatedStudent) {
        List<Student> allStudents = getStudents();
        for (int i = 0; i < allStudents.size(); i++) {
            Student student = allStudents.get(i);
            if (student.getId().equals(updatedStudent.getId())) {
                allStudents.set(i, updatedStudent);
                try {
                    json.writeData(STUDENT_FILE, allStudents);
                    return;
                } catch (IOException e) {
                    System.out.println("Error updating isntructors: " + e.getMessage());
                }
            }
        }
        System.out.println("Answer not found: " + updatedStudent.getId());
    }

}

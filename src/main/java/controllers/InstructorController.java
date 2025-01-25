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
import models.Instructor;

/**
 *
 * @author User
 */
public class InstructorController {

    private static final String INSTRUCTOR_FILE = "src/main/java/data/instructors.json";

    private static final JsonUtils json = JsonUtils.getInstance();

    public InstructorController() {
    }

    public static List<Instructor> getInstructors() {
        try {
            List<Instructor> instructors = json.readData(INSTRUCTOR_FILE, Instructor.class);
            return instructors != null ? instructors : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error reading academic years data: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static Instructor getInstructorById(String instructorId) {
        List<Instructor> allInstructors = getInstructors();
        if (allInstructors != null) {
            for (Instructor instructor : allInstructors) {
                if (instructor.getId().equals(instructorId)) {
                    return instructor;
                }
            }
        }
        return null;
    }

    public static void addInstructor(Instructor instructor) {
        try {
            if (alreadyExists(instructor.getUsername())) {
                JOptionPane.showMessageDialog(null,
                        "An instructor with the username '" + instructor.getUsername() + "' already exists.",
                        "Duplicate Entry",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                json.saveData(INSTRUCTOR_FILE, instructor);
                JOptionPane.showMessageDialog(null,
                        "Instructor added successfully!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred while adding the instructor: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean alreadyExists(String username) {
        try {
            List<Instructor> allinstructors = json.readData(INSTRUCTOR_FILE, Instructor.class);
            for (Instructor objInstructor: allinstructors) {
                if (objInstructor.getUsername().equals(username)) {
                    return true; // Username exists
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading instructor data: " + e.getMessage());
        }
        return false; // Username does not exist
    }

}

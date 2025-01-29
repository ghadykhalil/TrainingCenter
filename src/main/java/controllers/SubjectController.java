/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import static controllers.StudentController.alreadyExists;
import dbWrapper.JsonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Student;
import models.Subject;

/**
 *
 * @author User
 */
public class SubjectController {

    private static final String SUBJECT_FILE = "src/main/java/data/subjects.json";

    private static final JsonUtils json = JsonUtils.getInstance();

    public static List<Subject> getSubjects() {
        try {
            List<Subject> subjects = json.readData(SUBJECT_FILE, Subject.class);
            return subjects != null ? subjects : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error reading subjectsdata: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static Subject getSubjectById(String studentId) {
        List<Subject> allSubjects = getSubjects();
        if (allSubjects != null) {
            for (Subject subject : allSubjects) {
                if (subject.getId().equals(studentId)) {
                    return subject;
                }
            }
        }
        return null;
    }

    public static boolean addSubject(Subject subject) {
        boolean success = false;
        try {
            json.saveData(SUBJECT_FILE, subject);
            success = true;
            JOptionPane.showMessageDialog(null,
                    "Subject added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred while adding the syvject: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    public static boolean addSubjects(List<Subject> subjects) {
        boolean success = false;
        try {
            json.saveData(SUBJECT_FILE, subjects);
            success = true;
            JOptionPane.showMessageDialog(null,
                    "Subject added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred while adding the subject: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

}

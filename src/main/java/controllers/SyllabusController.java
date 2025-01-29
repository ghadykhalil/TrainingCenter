/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author User
 */

import dbWrapper.JsonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Syllabus;

public class SyllabusController {

    private static final String SYLLABUS_FILE = "src/main/java/data/syllabus.json";
    private static final JsonUtils json = JsonUtils.getInstance();

    public static List<Syllabus> getSyllabi() {
        try {
            List<Syllabus> syllabi = json.readData(SYLLABUS_FILE, Syllabus.class);
            return (syllabi != null) ? syllabi : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error reading syllabus data: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static Syllabus getSyllabusById(String syllabusId) {
        List<Syllabus> allSyllabi = getSyllabi();
        for (Syllabus syllabus : allSyllabi) {
            if (syllabus.getId().equals(syllabusId)) {
                return syllabus;
            }
        }
        return null;
    }

    public static boolean addSyllabus(Syllabus syllabus) {
        boolean success = false;
        try {
            json.saveData(SYLLABUS_FILE, syllabus);
            success = true;
            JOptionPane.showMessageDialog(null,
                    "Syllabus added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred while adding the syllabus: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    public static boolean addSyllabi(List<Syllabus> syllabi) {
        boolean success = false;
        try {
            json.saveData(SYLLABUS_FILE, syllabi);
            success = true;
            JOptionPane.showMessageDialog(null,
                    "Syllabi added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred while adding the syllabi: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    public static void updateSyllabus(Syllabus updatedSyllabus) {
        List<Syllabus> allSyllabi = getSyllabi();
        for (int i = 0; i < allSyllabi.size(); i++) {
            Syllabus syllabus = allSyllabi.get(i);
            if (syllabus.getId().equals(updatedSyllabus.getId())) {
                allSyllabi.set(i, updatedSyllabus);
                try {
                    json.writeData(SYLLABUS_FILE, allSyllabi);
                    JOptionPane.showMessageDialog(null,
                            "Syllabus updated successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                } catch (IOException e) {
                    System.out.println("Error updating syllabus: " + e.getMessage());
                }
            }
        }
        System.out.println("Syllabus not found: " + updatedSyllabus.getId());
    }
}

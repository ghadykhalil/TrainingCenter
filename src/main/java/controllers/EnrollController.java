/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dbWrapper.JsonUtils;
import enums.enrollStatus;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Enroll;
import models.Payment;
import models.Student;
import models.Subject;

public class EnrollController {

    private static final String ENROLL_FILE = "src/main/java/data/enroll.json";
    private static final JsonUtils json = JsonUtils.getInstance();

    public static List<Enroll> getEnrollments() {
        try {
            List<Enroll> enrollments = json.readData(ENROLL_FILE, Enroll.class);
            return (enrollments != null) ? enrollments : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error reading enroll data: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static Enroll getEnrollmentById(String enrollId) {
        List<Enroll> allEnrollments = getEnrollments();
        for (Enroll enroll : allEnrollments) {
            if (enroll.getId().equals(enrollId)) {
                return enroll;
            }
        }
        return null;
    }

    public static boolean addEnrollment(Enroll enroll) {
        Student student = enroll.getStudent();
        Subject subject = enroll.getSubject();

        // Fetch only the enrollments for this specific student
        List<Enroll> studentEnrollments = getEnrollmentsByStudent(student.getId());

        // Check if this student is already enrolled in this subject
        for (Enroll existingEnroll : studentEnrollments) {
            if (existingEnroll.getSubject().getId().equals(subject.getId())
                    && (existingEnroll.getStatus() == enrollStatus.Active
                    || existingEnroll.getStatus() == enrollStatus.PendingPayment)) {
                JOptionPane.showMessageDialog(null,
                        "You are already enrolled in this subject!",
                        "Enrollment Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        // Check if the student has completed all prerequisites
        List<Enroll> completedEnrollments = getEnrollmentsByStudentAndStatus(student.getId(), enrollStatus.Completed);
        List<Subject> completedSubjects = new ArrayList<>();
        for (Enroll e : completedEnrollments) {
            completedSubjects.add(e.getSubject());
        }

        for (Subject prerequisite : subject.getPrerequisites()) {
            if (!completedSubjects.contains(prerequisite)) {
                JOptionPane.showMessageDialog(null,
                        "You need to finish the prerequisite: " + prerequisite.getName() + " " + prerequisite.getLevel(),
                        "Enrollment Error",
                        JOptionPane.ERROR_MESSAGE);
                return false; // Prevent enrollment
            }
        }

        // Save the enrollment
        boolean success = false;
        try {
            json.saveData(ENROLL_FILE, enroll);
            success = true;
            JOptionPane.showMessageDialog(null,
                    "Enrollment added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred while adding the enrollment: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    public static boolean addEnrollments(List<Enroll> enrollments) {
        boolean success = false;
        try {
            json.saveData(ENROLL_FILE, enrollments);
            success = true;
            JOptionPane.showMessageDialog(null,
                    "Enrollments added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred while adding the enrollments: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    public static void updateEnrollment(Enroll updatedEnroll) {
        List<Enroll> allEnrollments = getEnrollments();
        for (int i = 0; i < allEnrollments.size(); i++) {
            Enroll enroll = allEnrollments.get(i);
            if (enroll.getId().equals(updatedEnroll.getId())) {
                allEnrollments.set(i, updatedEnroll);
                try {
                    json.writeData(ENROLL_FILE, allEnrollments);
                    JOptionPane.showMessageDialog(null,
                            "Enrollment updated successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                } catch (IOException e) {
                    System.out.println("Error updating enrollment: " + e.getMessage());
                }
            }
        }
        System.out.println("Enrollment not found: " + updatedEnroll.getId());
    }

    // Query: Get enrollments by Subject ID
    public static List<Enroll> getEnrollmentsBySubject(String subjectId) {
        List<Enroll> results = new ArrayList<>();
        for (Enroll enroll : getEnrollments()) {
            if (enroll.getSubject().getId().equals(subjectId)) {
                results.add(enroll);
            }
        }
        return results;
    }

    // Query: Get enrollments by Status
    public static List<Enroll> getEnrollmentsByStatus(enrollStatus status) {
        List<Enroll> results = new ArrayList<>();
        for (Enroll enroll : getEnrollments()) {
            if (enroll.getStatus() == status) {
                results.add(enroll);
            }
        }
        return results;
    }

    // Query: Get pending payments
    public static List<Enroll> getPendingPayments() {
        return getEnrollmentsByStatus(enrollStatus.PendingPayment);
    }

    // Query: Get active enrollments
    public static List<Enroll> getActiveEnrollments() {
        return getEnrollmentsByStatus(enrollStatus.Active);
    }

    // Query: Get completed enrollments
    public static List<Enroll> getCompletedEnrollments() {
        return getEnrollmentsByStatus(enrollStatus.Completed);
    }

    // Query: Get enrollments by Student ID and Status
    public static List<Enroll> getEnrollmentsByStudentAndStatus(String studentId, enrollStatus status) {
        List<Enroll> results = new ArrayList<>();
        for (Enroll enroll : getEnrollments()) {
            if (enroll.getStudent().getId().equals(studentId) && enroll.getStatus() == status) {
                results.add(enroll);
            }
        }
        return results;
    }

    public static List<Subject> getAvailableSubjects(Student student) {
        List<Subject> enrolledSubjects = new ArrayList<>();
        List<Subject> availableSubjects = SubjectController.getSubjects();
        for (Enroll enroll : getEnrollments()) {
            if (enroll.getStudent().getId().equals(student.getId())) {
                enrolledSubjects.add(enroll.getSubject());
            }
        }
        availableSubjects.removeAll(enrolledSubjects);
        return availableSubjects;
    }

    public static List<Enroll> getEnrollmentsByStudent(String studentId) {
        List<Enroll> results = new ArrayList<>();
        for (Enroll enroll : getEnrollments()) {
            if (enroll.getStudent().getId().equals(studentId)) {
                results.add(enroll);
            }
        }
        return results;
    }

    public static List<Enroll> getDuePaymentsForStudent(String studentId) {
        List<Enroll> dueEnrollments = new ArrayList<>();
        // Get all enrollments for the student
        List<Enroll> studentEnrollments = getEnrollmentsByStudent(studentId);
        for (Enroll enroll : studentEnrollments) {
            Payment payment = enroll.getPayment();
            // Check if payment is unpaid (status is false)
            if (payment != null && !payment.getStatus()) {
                dueEnrollments.add(enroll);
            }
        }
        return dueEnrollments;
    }

    public static List<Enroll> getActiveCourses(String studentId) {
        List<Enroll> dueEnrollments = new ArrayList<>();
        // Get all enrollments for the student
        List<Enroll> studentEnrollments = getEnrollmentsByStudent(studentId);
        for (Enroll enroll : studentEnrollments) {
            Payment payment = enroll.getPayment();
            // Check if payment is unpaid (status is false)
            if (payment != null && !payment.getStatus() == true && enroll.getStatus() == enrollStatus.Active) {
                dueEnrollments.add(enroll);
            }
        }
        return dueEnrollments;

    }

    public static List<Enroll> getFinishedPayment(String studentId) {
        List<Enroll> dueEnrollments = new ArrayList<>();
        // Get all enrollments for the student
        List<Enroll> studentEnrollments = getEnrollmentsByStudent(studentId);
        for (Enroll enroll : studentEnrollments) {
            Payment payment = enroll.getPayment();
            // Check if payment is unpaid (status is false)
            if (payment != null && enroll.getStatus() != enrollStatus.PendingPayment) {
                dueEnrollments.add(enroll);
            }
        }
        return dueEnrollments;
    }
}

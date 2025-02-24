/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import static controllers.EnrollController.getEnrollmentsByStudent;
import dbWrapper.JsonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Enroll;
import models.Payment;

public class PaymentController {

    private static final String PAYMENT_FILE = "src/main/java/data/payment.json";
    private static final JsonUtils json = JsonUtils.getInstance();

    public static List<Payment> getPayments() {
        try {
            List<Payment> payments = json.readData(PAYMENT_FILE, Payment.class);
            return (payments != null) ? payments : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error reading payment data: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static Payment getPaymentById(String paymentId) {
        List<Payment> allPayments = getPayments();
        for (Payment payment : allPayments) {
            if (payment.getId().equals(paymentId)) {
                return payment;
            }
        }
        return null;
    }

    public static boolean addPayment(Payment payment) {
        boolean success = false;
        try {
            json.saveData(PAYMENT_FILE, payment);
            success = true;
            JOptionPane.showMessageDialog(null,
                    "Payment added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred while adding the payment: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    public static boolean addPayments(List<Payment> payments) {
        boolean success = false;
        try {
            json.saveData(PAYMENT_FILE, payments);
            success = true;
            JOptionPane.showMessageDialog(null,
                    "Payments added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred while adding the payments: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    public static void updatePayment(Payment updatedPayment) {
        List<Payment> allPayments = getPayments();
        for (int i = 0; i < allPayments.size(); i++) {
            Payment payment = allPayments.get(i);
            if (payment.getId().equals(updatedPayment.getId())) {
                allPayments.set(i, updatedPayment);
                try {
                    json.writeData(PAYMENT_FILE, allPayments);
                    JOptionPane.showMessageDialog(null,
                            "Payment updated successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                } catch (IOException e) {
                    System.out.println("Error updating payment: " + e.getMessage());
                }
            }
        }
        System.out.println("Payment not found: " + updatedPayment.getId());
    }

    public static List<Payment> getDuePaymentsForStudent(String studentId) {
        List<Payment> duePayments = new ArrayList<>();
        for (Enroll enroll : getEnrollmentsByStudent(studentId)) {
            Payment payment = enroll.getPayment();
            if (payment != null && !payment.getStatus()) { // Unpaid payments
                duePayments.add(payment);
            }
        }
        return duePayments;
    }

}

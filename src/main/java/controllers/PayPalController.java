package controllers;

import dbWrapper.JsonUtils;
import models.Paypal;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PayPalController {

    private static final String PAYPAL_FILE = "src/main/java/data/paypal.json";
    private static final JsonUtils json = JsonUtils.getInstance();

    public static List<Paypal> getPaypals() {
        try {
            List<Paypal> paypals = json.readData(PAYPAL_FILE, Paypal.class);
            return (paypals != null) ? paypals : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error reading Paypal data: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static Paypal getPaypalById(String paypalId) {
        List<Paypal> allPaypals = getPaypals();
        for (Paypal paypal : allPaypals) {
            if (paypal.getId().equals(paypalId)) {
                return paypal;
            }
        }
        return null;
    }

    public static boolean addPaypal(Paypal paypal) {
        boolean success = false;
        try {
            json.saveData(PAYPAL_FILE, paypal);
            success = true;
            JOptionPane.showMessageDialog(null,
                    "Paypal added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred while adding the Paypal: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    public static boolean addPaypals(List<Paypal> paypals) {
        boolean success = false;
        try {
            json.saveData(PAYPAL_FILE, paypals);
            success = true;
            JOptionPane.showMessageDialog(null,
                    "Paypals added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred while adding the Paypals: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    public static void updatePaypal(Paypal updatedPaypal) {
        List<Paypal> allPaypals = getPaypals();
        for (int i = 0; i < allPaypals.size(); i++) {
            Paypal paypal = allPaypals.get(i);
            if (paypal.getId().equals(updatedPaypal.getId())) {
                allPaypals.set(i, updatedPaypal);
                try {
                    json.writeData(PAYPAL_FILE, allPaypals);
                    JOptionPane.showMessageDialog(null,
                            "Paypal updated successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                } catch (IOException e) {
                    System.out.println("Error updating Paypal: " + e.getMessage());
                }
            }
        }
        System.out.println("Paypal not found: " + updatedPaypal.getId());
    }
}

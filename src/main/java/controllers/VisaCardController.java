package controllers;

import dbWrapper.JsonUtils;
import models.VisaCard;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VisaCardController {

    private static final String VISACARD_FILE = "src/main/java/data/visacard.json";
    private static final JsonUtils json = JsonUtils.getInstance();

    public static List<VisaCard> getVisaCards() {
        try {
            List<VisaCard> visaCards = json.readData(VISACARD_FILE, VisaCard.class);
            return (visaCards != null) ? visaCards : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error reading VisaCard data: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static VisaCard getVisaCardById(String visaCardId) {
        List<VisaCard> allVisaCards = getVisaCards();
        for (VisaCard visaCard : allVisaCards) {
            if (visaCard.getId().equals(visaCardId)) {
                return visaCard;
            }
        }
        return null;
    }

    public static boolean addVisaCard(VisaCard visaCard) {
        boolean success = false;
        try {
            json.saveData(VISACARD_FILE, visaCard);
            success = true;
            JOptionPane.showMessageDialog(null,
                    "Visa Card added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred while adding the Visa Card: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    public static boolean addVisaCards(List<VisaCard> visaCards) {
        boolean success = false;
        try {
            json.saveData(VISACARD_FILE, visaCards);
            success = true;
            JOptionPane.showMessageDialog(null,
                    "Visa Cards added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred while adding the Visa Cards: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    public static void updateVisaCard(VisaCard updatedVisaCard) {
        List<VisaCard> allVisaCards = getVisaCards();
        for (int i = 0; i < allVisaCards.size(); i++) {
            VisaCard visaCard = allVisaCards.get(i);
            if (visaCard.getId().equals(updatedVisaCard.getId())) {
                allVisaCards.set(i, updatedVisaCard);
                try {
                    json.writeData(VISACARD_FILE, allVisaCards);
                    JOptionPane.showMessageDialog(null,
                            "Visa Card updated successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                } catch (IOException e) {
                    System.out.println("Error updating Visa Card: " + e.getMessage());
                }
            }
        }
        System.out.println("Visa Card not found: " + updatedVisaCard.getId());
    }
}

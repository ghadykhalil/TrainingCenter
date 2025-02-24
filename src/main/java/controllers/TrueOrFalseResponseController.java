package controllers;

import dbWrapper.JsonUtils;
import models.TrueOrFalseResponse;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrueOrFalseResponseController {

    private static final String RESPONSE_FILE = "src/main/java/data/trueOrFalseResponses.json";
    private static final JsonUtils json = JsonUtils.getInstance();

    // Get all True/False responses
    public static List<TrueOrFalseResponse> getResponses() {
        try {
            List<TrueOrFalseResponse> responses = json.readData(RESPONSE_FILE, TrueOrFalseResponse.class);
            return (responses != null) ? responses : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error reading True/False responses: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Add a new True/False response
    public static boolean addResponse(TrueOrFalseResponse response) {
        try {
            List<TrueOrFalseResponse> allResponses = getResponses();
            allResponses.add(response);
            json.writeData(RESPONSE_FILE, allResponses);
            return true;
        } catch (IOException e) {
            System.out.println("Error adding True/False response: " + e.getMessage());
            return false;
        }
    }

    // Update an existing True/False response
    public static boolean updateResponse(TrueOrFalseResponse updatedResponse) {
        List<TrueOrFalseResponse> allResponses = getResponses();
        for (int i = 0; i < allResponses.size(); i++) {
            if (allResponses.get(i).getId().equals(updatedResponse.getId())) {
                allResponses.set(i, updatedResponse);
                try {
                    json.writeData(RESPONSE_FILE, allResponses);
                    return true;
                } catch (IOException e) {
                    System.out.println("Error updating True/False response: " + e.getMessage());
                    return false;
                }
            }
        }
        return false;
    }
}

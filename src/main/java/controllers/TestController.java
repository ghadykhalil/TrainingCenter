package controllers;

import dbWrapper.JsonUtils;
import models.Test;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestController {

    private static final String TEST_FILE = "src/main/java/data/test.json"; // Path to your test data file
    private static final JsonUtils json = JsonUtils.getInstance();

    // Method to get all tests from the JSON file
    public static List<Test> getTests() {
        try {
            List<Test> tests = json.readData(TEST_FILE, Test.class);
            return (tests != null) ? tests : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error reading Test data: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Method to get a specific test by its ID
    public static Test getTestById(String testId) {
        List<Test> allTests = getTests();
        for (Test test : allTests) {
            if (test.getId().equals(testId)) {
                return test;
            }
        }
        return null;
    }

    public static List<Test> getTestsByArray(List<Test> testArray) {
        List<Test> allTests = getTests();  // Get the list of all tests stored in the JSON
        List<Test> matchingTests = new ArrayList<>();

        for (Test test : testArray) {
            for (Test storedTest : allTests) {
                // Compare by ID
                if (test.getId().equals(storedTest.getId())) {
                    matchingTests.add(storedTest);  // Add to the matching list if IDs match
                    break;  // No need to check other stored tests once a match is found
                }
            }
        }

        return matchingTests;  // Return the list of tests that have matching IDs
    }

    // Method to add a single test to the JSON file
    public static boolean addTest(Test test) {
        boolean success = false;
        try {
            List<Test> allTests = getTests();
            allTests.add(test); // Add the test to the list directly
            json.writeData(TEST_FILE, allTests); // Write the updated list of tests to the file
            success = true;
            JOptionPane.showMessageDialog(null,
                    "Test added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred while adding the Test: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    // Method to add multiple tests at once
    public static boolean addTests(List<Test> tests) {
        boolean success = false;
        try {
            List<Test> allTests = getTests();
            allTests.addAll(tests); // Add all tests to the existing list
            json.writeData(TEST_FILE, allTests); // Write the updated list of tests to the file
            success = true;
            JOptionPane.showMessageDialog(null,
                    "Tests added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred while adding the Tests: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    // Method to update an existing test
    public static void updateTest(Test updatedTest) {
        List<Test> allTests = getTests();
        for (int i = 0; i < allTests.size(); i++) {
            Test test = allTests.get(i);
            if (test.getId().equals(updatedTest.getId())) {
                allTests.set(i, updatedTest);
                try {
                    json.writeData(TEST_FILE, allTests); // Write the updated list back to the file
                    JOptionPane.showMessageDialog(null,
                            "Test updated successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                } catch (IOException e) {
                    System.out.println("Error updating Test: " + e.getMessage());
                }
            }
        }
        System.out.println("Test not found: " + updatedTest.getId());
    }
}

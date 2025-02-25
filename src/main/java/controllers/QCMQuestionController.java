package controllers;

import dbWrapper.JsonUtils;
import models.QCMQuestion;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QCMQuestionController {

    private static final String QUESTION_FILE = "src/main/java/data/qcmQuestions.json";
    private static final JsonUtils json = JsonUtils.getInstance();

    // Get all QCM questions
    public static List<QCMQuestion> getQuestions() {
        try {
            List<QCMQuestion> questions = json.readData(QUESTION_FILE, QCMQuestion.class);
            return (questions != null) ? questions : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error reading QCM questions: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Add a new QCM question
    public static boolean addQuestion(QCMQuestion question) {
        try {
            List<QCMQuestion> allQuestions = getQuestions();
            allQuestions.add(question);
            json.writeData(QUESTION_FILE, allQuestions);
            return true;
        } catch (IOException e) {
            System.out.println("Error adding QCM question: " + e.getMessage());
            return false;
        }
    }

    // Update an existing QCM question
    public static boolean updateQuestion(QCMQuestion updatedQuestion) {
        List<QCMQuestion> allQuestions = getQuestions();
        for (int i = 0; i < allQuestions.size(); i++) {
            if (allQuestions.get(i).getId().equals(updatedQuestion.getId())) {
                allQuestions.set(i, updatedQuestion);
                try {
                    json.writeData(QUESTION_FILE, allQuestions);
                    return true;
                } catch (IOException e) {
                    System.out.println("Error updating QCM question: " + e.getMessage());
                    return false;
                }
            }
        }
        return false;
    }

    // Get questions by comparing the ID from an array of questions
    public static List<QCMQuestion> getQuestionsByArray(List<QCMQuestion> questionArray) {
        List<QCMQuestion> allQuestions = getQuestions();  // Get the list of all questions stored in the JSON
        List<QCMQuestion> matchingQuestions = new ArrayList<>();

        for (QCMQuestion question : questionArray) {
            for (QCMQuestion storedQuestion : allQuestions) {
                // Compare by ID
                if (question.getId().equals(storedQuestion.getId())) {
                    matchingQuestions.add(storedQuestion);  // Add to the matching list if IDs match
                    break;  // No need to check other stored questions once a match is found
                }
            }
        }

        return matchingQuestions;  // Return the list of questions that have matching IDs
    }
}

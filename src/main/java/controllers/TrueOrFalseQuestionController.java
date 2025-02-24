package controllers;

import dbWrapper.JsonUtils;
import models.TrueOrFalseQuestion;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrueOrFalseQuestionController {

    private static final String QUESTION_FILE = "src/main/java/data/trueOrFalseQuestions.json";
    private static final JsonUtils json = JsonUtils.getInstance();

    // Get all True/False questions
    public static List<TrueOrFalseQuestion> getQuestions() {
        try {
            List<TrueOrFalseQuestion> questions = json.readData(QUESTION_FILE, TrueOrFalseQuestion.class);
            return (questions != null) ? questions : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error reading True/False questions: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Add a new True/False question
    public static boolean addQuestion(TrueOrFalseQuestion question) {
        try {
            List<TrueOrFalseQuestion> allQuestions = getQuestions();
            allQuestions.add(question);
            json.writeData(QUESTION_FILE, allQuestions);
            return true;
        } catch (IOException e) {
            System.out.println("Error adding True/False question: " + e.getMessage());
            return false;
        }
    }

    // Update an existing True/False question
    public static boolean updateQuestion(TrueOrFalseQuestion updatedQuestion) {
        List<TrueOrFalseQuestion> allQuestions = getQuestions();
        for (int i = 0; i < allQuestions.size(); i++) {
            if (allQuestions.get(i).getId().equals(updatedQuestion.getId())) {
                allQuestions.set(i, updatedQuestion);
                try {
                    json.writeData(QUESTION_FILE, allQuestions);
                    return true;
                } catch (IOException e) {
                    System.out.println("Error updating True/False question: " + e.getMessage());
                    return false;
                }
            }
        }
        return false;
    }

    // Get questions by comparing the ID from an array of questions
    public static List<TrueOrFalseQuestion> getQuestionsByArray(List<TrueOrFalseQuestion> questionArray) {
        List<TrueOrFalseQuestion> allQuestions = getQuestions();  // Get the list of all questions stored in the JSON
        List<TrueOrFalseQuestion> matchingQuestions = new ArrayList<>();

        for (TrueOrFalseQuestion question : questionArray) {
            for (TrueOrFalseQuestion storedQuestion : allQuestions) {
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

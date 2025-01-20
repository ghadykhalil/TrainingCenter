/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class QCMQuestion implements Question {

    private int id;
    private static int next = 0;
    private String questionText;
    private List<String> choices;

    public QCMQuestion() {
        choices = new ArrayList<>();
    }

    public QCMQuestion(String questionText) {
        this.id = ++next;
        this.questionText = questionText;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void addChoice(String choice) {
        this.choices.add(choice);
    }

    public List<String> getChoices() {
        return this.choices;
    }
}

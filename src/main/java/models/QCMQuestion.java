/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dbWrapper.IdGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class QCMQuestion implements Question {

    private String id;
    private String questionText;
    private List<String> choices = new ArrayList<>();

    public QCMQuestion() {
        id = IdGenerator.generateId();
    }

    public QCMQuestion(String questionText) {
        this();
        this.questionText = questionText;
    }

    @Override
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

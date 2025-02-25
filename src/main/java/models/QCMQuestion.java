package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import helpers.IdGenerator;
import java.util.ArrayList;
import java.util.List;

public class QCMQuestion implements Question {

    private String id;
    private String questionText;
    private List<String> choices;
    private List<String> correctAnswers;
    private double grade;

    @JsonIgnore
    private transient QCMQuestionVisitor visitor;

    public QCMQuestion() {
        this.id = IdGenerator.generateId();
    }

    public QCMQuestion(String questionText, List<String> choices, List<String> correctAnswers, double grade) {
        this();
        this.questionText = questionText;
        this.choices = new ArrayList<>(choices);
        this.correctAnswers = new ArrayList<>(correctAnswers);
        this.grade = grade;
    }

    @Override
    public String getQuestionText() {
        return questionText;
    }

    @Override
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<String> getChoices() {
        return choices;
    }

    public List<String> getCorrectAnswers() {
        return correctAnswers;
    }

    public double getGrade() {
        return grade;
    }

    public boolean evaluate(Object studentResponse) {
        List<String> selectedAnswers = (List<String>) studentResponse;
        return selectedAnswers.containsAll(correctAnswers) && correctAnswers.containsAll(selectedAnswers);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public QCMQuestionVisitor getVisitor() {
        return visitor;
    }

    public void setVisitor(QCMQuestionVisitor qcmQuestionVIsitor) {
        this.visitor = qcmQuestionVIsitor;
    }

    @Override
    public String toString() {
        return this.accept(visitor);
    }

    public String accept(QCMQuestionVisitor visitor) {
        return visitor.visitQCMQuestionVisitor(this);
    }

}

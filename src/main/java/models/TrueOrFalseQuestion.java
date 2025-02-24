package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import helpers.IdGenerator;

public class TrueOrFalseQuestion implements Question {

    private String id;
    private String questionText;
    private boolean correctAnswer; // Stores the correct answer (true/false)
    private double grade; // Grade for the question
    
    @JsonIgnore
    private transient TrueOrFalseQuestionVisitor visitor;

    public TrueOrFalseQuestion() {
        this.id = IdGenerator.generateId();
    }

    public TrueOrFalseQuestion(String questionText, boolean correctAnswer, double grade) {
        this();
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
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

    public String getId() {
        return id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public boolean getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    /**
     * Evaluates the student's response using the Interpreter pattern.
     */
    public double evaluate(TrueOrFalseResponse studentResponse) {
        boolean isCorrect = studentResponse.evaluate(correctAnswer);
        return isCorrect ? grade : 0.0;
    }

    public String accept(TrueOrFalseQuestionVisitor visitor) {
        return visitor.visitTrueOrFalseQuestion(this);
    }
    
    @Override
    public String toString(){
        return this.accept(visitor);
    }

    public TrueOrFalseQuestionVisitor getVisitor() {
        return visitor;
    }

    public void setVisitor(TrueOrFalseQuestionVisitor visitor) {
        this.visitor = visitor;
    }
    
    
}

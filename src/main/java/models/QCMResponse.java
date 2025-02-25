package models;

import helpers.IdGenerator;
import java.util.List;

public class QCMResponse implements Response {

    private String id;
    private List<String> selectedAnswers;

    public QCMResponse() {
        id = IdGenerator.generateId();
    }

    public QCMResponse(List<String> selectedAnswers) {
        this();
        this.selectedAnswers = selectedAnswers;
    }

    @Override
    public boolean evaluate(Object correctAnswer) {
        if (!(correctAnswer instanceof List)) {
            throw new IllegalArgumentException("Correct answer must be a list.");
        }
        List<String> correctAnswers = (List<String>) correctAnswer;
        return selectedAnswers.containsAll(correctAnswers) && correctAnswers.containsAll(selectedAnswers);
    }

    public List<String> getSelectedAnswers() {
        return selectedAnswers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}

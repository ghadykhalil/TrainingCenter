package models;

import java.util.List;

public class QCMResponse implements Response {

    private List<String> selectedAnswers;

    public QCMResponse(List<String> selectedAnswers) {
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
}

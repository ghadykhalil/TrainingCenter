package models;

import java.util.List;

public class QCMFactory implements QuestionFactory {

    @Override
    public QCMQuestion createQuestion(String questionText, double grade) {
        return new QCMQuestion(questionText, List.of(), List.of(), grade); // Empty choices, can be added later
    }

    @Override
    public QCMResponse createSolution(Object selectedAnswers) {
        return new QCMResponse((List<String>) selectedAnswers);
    }
}

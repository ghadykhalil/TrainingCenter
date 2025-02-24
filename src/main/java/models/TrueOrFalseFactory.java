package models;

public class TrueOrFalseFactory implements QuestionFactory {

    @Override
    public TrueOrFalseQuestion createQuestion(String questionText, double grade) {
        return new TrueOrFalseQuestion(questionText, false, grade); // Default false, can be updated later
    }

    @Override
    public TrueOrFalseResponse createSolution(Object selectedAnswer) {
        return new TrueOrFalseResponse((boolean) selectedAnswer);
    }
}

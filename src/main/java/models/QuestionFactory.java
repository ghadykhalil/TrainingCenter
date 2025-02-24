package models;

public interface QuestionFactory {

    Question createQuestion(String questionText, double grade);

    Response createSolution(Object selectedAnswer);
}

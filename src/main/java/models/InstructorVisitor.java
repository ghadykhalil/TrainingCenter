/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author User
 */
public class InstructorVisitor implements MeetingVisitor, TrueOrFalseQuestionVisitor, QCMQuestionVisitor {

    private Instructor instructor;
    private Chapter chapter;

    public InstructorVisitor() {
    }

    public InstructorVisitor(Instructor instructor, Chapter chapter) {
        this.instructor = instructor;
        this.chapter = chapter;
    }

    @Override
    public void visit(Meeting meeting) {
        MeetingScreenBuilder builder = new InstructorScreenBuilder(meeting, this.instructor, this.chapter);
        builder.buildScreen();
    }

    @Override
    public String visitTrueOrFalseQuestion(TrueOrFalseQuestion trueOrFalseQuestion) {
        return "Grade: " + trueOrFalseQuestion.getGrade() + " " + trueOrFalseQuestion.getQuestionText() + "\n Answer: " + (trueOrFalseQuestion.getCorrectAnswer() ? "True" : "False");
    }

    @Override
    public String visitQCMQuestionVisitor(QCMQuestion qcmQuestion) {
        StringBuilder builder = new StringBuilder();
        builder.append("\nGrade: ").append(qcmQuestion.getGrade() + " ");
        builder.append(qcmQuestion.getQuestionText());
        builder.append("\nChoices: ");
        for (String choice : qcmQuestion.getChoices()) {
            builder.append(choice).append(", ");
        }
        builder.append("\nCorrect Answers: ");
        for (String correctAnswer : qcmQuestion.getCorrectAnswers()) {
            builder.append(correctAnswer).append(", ");
        }
        return builder.toString();
    }

}

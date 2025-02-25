/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author User
 */
public class StudentVisitor implements MeetingVisitor, TrueOrFalseQuestionVisitor, QCMQuestionVisitor {

    private Student student;
    private Chapter chapter;

    public StudentVisitor() {
    }

    ;

    public StudentVisitor(Student student, Chapter chapter) {
        this.student = student;
        this.chapter = chapter;
    }

    @Override
    public void visit(Meeting meeting) {
        if (student.getStudentMainScreen() == null) {
            MeetingScreenBuilder builder = new StudentScreenBuilder(meeting, this.student, this.chapter);
            builder.buildScreen();
        }
    }

    @Override
    public String visitTrueOrFalseQuestion(TrueOrFalseQuestion trueOrFalseQuestion) {
        return "Grade: " + trueOrFalseQuestion.getGrade() + " " + trueOrFalseQuestion.getQuestionText();
    }

    @Override
    public String visitQCMQuestionVisitor(QCMQuestion qcmQuestion) {
        StringBuilder builder = new StringBuilder();
        builder.append("\n Correct Answers: ");
        builder.append("\n Grade: ").append(qcmQuestion.getGrade() + " ");
        builder.append(qcmQuestion.getQuestionText());
        builder.append("\n Choices: ");
        for (String choice : qcmQuestion.getChoices()) {
            builder.append(choice).append(", ");
        }

        return builder.toString();
    }

}

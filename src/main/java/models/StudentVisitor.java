/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author User
 */
public class StudentVisitor implements MeetingVisitor, TrueOrFalseQuestionVisitor {

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
        return trueOrFalseQuestion.getQuestionText() + " " + trueOrFalseQuestion.getGrade();
    }

}

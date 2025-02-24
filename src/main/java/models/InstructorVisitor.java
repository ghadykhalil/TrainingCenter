/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author User
 */
public class InstructorVisitor implements MeetingVisitor, TrueOrFalseQuestionVisitor {

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
        return trueOrFalseQuestion.getQuestionText() + "\n Answer: " + (trueOrFalseQuestion.getCorrectAnswer() ? "True" : "False")+" "+ trueOrFalseQuestion.getGrade();
    }

}

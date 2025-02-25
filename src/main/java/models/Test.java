package models;

import helpers.IdGenerator;
import java.util.ArrayList;
import java.util.List;

public class Test {

    private String id;
    private String title;
    private List<TrueOrFalseQuestion> trueOrFalseQuestions; // List of True/False questions
    private List<QCMQuestion> qcmQuestions; // List of QCM questions
    private List<StudentAnswer> studentAnswers; // List of student responses
    private double totalMaxGrade; // The maximum total grade, e.g., 20

    public Test() {
        this.id = IdGenerator.generateId();
        this.trueOrFalseQuestions = new ArrayList<>();
        this.qcmQuestions = new ArrayList<>();
        this.studentAnswers = new ArrayList<>();
    }

    public Test(String title, double totalMaxGrade) {
        this();
        this.title = title;
        this.totalMaxGrade = totalMaxGrade; // The desired total grade (e.g., 20)
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setTrueOrFalseQuestions(List<TrueOrFalseQuestion> trueOrFalseQuestions) {
        this.trueOrFalseQuestions = trueOrFalseQuestions;
    }

    public void setStudentAnswers(List<StudentAnswer> studentAnswers) {
        this.studentAnswers = studentAnswers;
    }

    public List<QCMQuestion> getQcmQuestions() {
        return qcmQuestions;
    }

    public void setQcmQuestions(List<QCMQuestion> qcmQuestions) {
        this.qcmQuestions = qcmQuestions;
    }

    public double getTotalMaxGrade() {
        return totalMaxGrade;
    }

    public void setTotalMaxGrade(double totalMaxGrade) {
        this.totalMaxGrade = totalMaxGrade;
    }

    public List<TrueOrFalseQuestion> getTrueOrFalseQuestions() {
        return trueOrFalseQuestions;
    }

    public void addTrueOrFalseQuestion(TrueOrFalseQuestion question) {
        this.trueOrFalseQuestions.add(question);
    }

    public void addQCMQuestion(QCMQuestion question) {
        this.qcmQuestions.add(question);
    }

    public List<StudentAnswer> getStudentAnswers() {
        return studentAnswers;
    }

    public void addStudentAnswer(StudentAnswer answer) {
        studentAnswers.add(answer);
    }

    // ✅ Method to get the grade as a fraction (e.g., "13/20") with normalized total
    // Method to get the specific grade for a student as a fraction (e.g., "13/20")
    public String getStudentGradeAsFraction(Student student) {
        double earnedGrade = 0.0;
        double totalGrade = 0.0;

        // Loop through the True/False questions and accumulate the grade for the specific student
        for (StudentAnswer answer : studentAnswers) {
            if (answer.getStudent().equals(student)) {
                // If it's a True/False question, add the earned grade
                if (answer.getTrueOrFalseQuestion() != null) {
                    earnedGrade += answer.getEarnedGrade();
                    totalGrade += answer.getTrueOrFalseQuestion().getGrade();
                }
                // If it's a QCM question, add the earned grade
                if (answer.getQCMQuestion() != null) {
                    earnedGrade += answer.getEarnedGrade();
                    totalGrade += answer.getQCMQuestion().getGrade();
                }
            }
        }

        // Normalize the earned grade to the test's max grade (e.g., 20 or 30)
        double normalizedEarnedGrade = (earnedGrade / totalGrade) * totalMaxGrade;

        // Return the grade as a fraction (e.g., "13/20")
        return String.format("%.2f", normalizedEarnedGrade) + "/" + totalMaxGrade;
    }

    @Override
    public String toString() {
        return this.title + " Weight: " + this.getTotalMaxGrade();
    }
}

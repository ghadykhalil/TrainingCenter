package models;

public class StudentAnswer {

    private final Student student;  // The student who answered
    private final TrueOrFalseQuestion trueOrFalseQuestion; // If the question is True/False
    private final QCMQuestion qcmQuestion; // If the question is QCM
    private final TrueOrFalseResponse trueOrFalseResponse; // Response for True/False
    private final QCMResponse qcmResponse; // Response for QCM
    private double earnedGrade; // Earned grade for the question

    // ✅ Constructor for True/False Questions
    public StudentAnswer(Student student, TrueOrFalseQuestion question, TrueOrFalseResponse response) {
        this.student = student;
        this.trueOrFalseQuestion = question;
        this.qcmQuestion = null; // Not applicable
        this.trueOrFalseResponse = response;
        this.qcmResponse = null; // Not applicable
        this.earnedGrade = 0.0;
        evaluateAnswer(); // Automatically evaluate
    }

    // ✅ Constructor for QCM Questions
    public StudentAnswer(Student student, QCMQuestion question, QCMResponse response) {
        this.student = student;
        this.qcmQuestion = question;
        this.trueOrFalseQuestion = null; // Not applicable
        this.qcmResponse = response;
        this.trueOrFalseResponse = null; // Not applicable
        this.earnedGrade = 0.0;
        evaluateAnswer(); // Automatically evaluate
    }

    public Student getStudent() {
        return student;
    }

    public TrueOrFalseQuestion getTrueOrFalseQuestion() {
        return trueOrFalseQuestion;
    }

    public QCMQuestion getQCMQuestion() {
        return qcmQuestion;
    }

    public TrueOrFalseResponse getTrueOrFalseResponse() {
        return trueOrFalseResponse;
    }

    public QCMResponse getQCMResponse() {
        return qcmResponse;
    }

    public double getEarnedGrade() {
        return earnedGrade;
    }

    // ✅ Evaluates the answer based on the concrete question type
    private void evaluateAnswer() {
        // If this is a True/False question, evaluate the response
        if (trueOrFalseQuestion != null && trueOrFalseResponse != null) {
            // Use the evaluate method from TrueOrFalseResponse to check correctness
            earnedGrade = trueOrFalseResponse.evaluate(trueOrFalseQuestion.getCorrectAnswer())
                    ? trueOrFalseQuestion.getGrade() : 0.0;

            // If this is a QCM question, evaluate the response
        } else if (qcmQuestion != null && qcmResponse != null) {
            earnedGrade = qcmResponse.evaluate(qcmQuestion.getCorrectAnswers())
                    ? qcmQuestion.getGrade() : 0.0;
        }
    }
}

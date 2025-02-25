package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import helpers.IdGenerator; // Consider dependency injection for this
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Meeting implements Observable {

    private String id;
    private double duration;
    private String topic;
    private List<Student> admittedStudents = new ArrayList<>();
    private String dateTime;
    private boolean ended;

    @JsonIgnore
    private Subject subject;
    @JsonIgnore
    private Chapter chapter;
    @JsonIgnore
    private transient List<Observer> observers = new ArrayList<>();
    @JsonIgnore
    private transient List<Student> pendingAttendance = new ArrayList<>();
    @JsonIgnore
    private transient MeetingState state = new NotStartedState(); // Initial state

    public Meeting(){}
    
    public Meeting(Subject subject, Chapter chapter) {
        this(LocalDateTime.now().toString(), 30, "No topic", subject, chapter); // Call the other constructor
    }

    public Meeting(String dateTime, double duration, String topic, Subject subject, Chapter chapter) {
        this.id = IdGenerator.generateId(); // Or inject IdGenerator
        this.duration = duration;
        this.topic = topic;
        this.dateTime = dateTime;
        this.subject = subject;
        this.chapter = chapter;
        setEnded(false);
    }

    public void announce(String message) {
        System.out.println("Meeting on " + topic + ": " + message);
        notifyObservers(message);
    }

    public void admitStudent(Student student) {
        if (!admittedStudents.contains(student)) {
            admittedStudents.add(student);

            // Notify only the observers about the new admission
            student.studentAdmitted(this, student, chapter);  // Notify all observers

        } else {
            System.out.println("Student " + student.getName() + " is already admitted.");
        }
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {

    }

    public List<Student> getAdmittedStudents() {
        return admittedStudents;
    }

    public void setAdmittedStudents(List<Student> admittedStudents) {
        this.admittedStudents = admittedStudents;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Student> students) {
        this.observers.clear();  // Clear previous observers (if needed)
        this.observers.addAll(students);  // Add new observers
    }

    public List<Student> getPendingAttendance() {
        return pendingAttendance;
    }

    public void setPendingAttendance(List<Student> pendingAttendance) {
        this.pendingAttendance = pendingAttendance;
    }

    public void accept(MeetingVisitor visitor) {
        visitor.visit(this); // The Meeting "accepts" the visitor and calls its visit() method
    }

    public MeetingState getState() {
        return state;
    }

    public void setState(MeetingState state) {
        this.state = state;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void startMeeting(Instructor instructor) {
        this.state = new StartedState();  // Update MeetingState
        state.startMeeting(this, instructor);
    }

    public void endMeeting(String instructorName) {
        this.state = new EndedState(); // Update MeetingState
        for (Observer observer : observers) {
            observer.meetingEnded(this, instructorName);
        }
    }

    public void updateMeetingDetails(String newDateTime, double newDuration, String newTopic) {
        this.dateTime = newDateTime;
        this.duration = newDuration;
        this.topic = newTopic;
        for (Observer observer : observers) {
            observer.meetingUpdated(this); // Notify about the update
        }
    }

    public void rejectStudent(Student student) {
        if (admittedStudents.contains(student)) {
            admittedStudents.remove(student);
        }
        for (Observer observer : observers) {
            observer.studentRejected(this, student); // Use specific method
        }
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %s | Topic: %s | Duration: %.1f mins | Date: %s | Ended: %s | Students: %d",
                id, topic, duration, dateTime, ended ? "Yes" : "No", admittedStudents.size()
        );
    }

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }

}
